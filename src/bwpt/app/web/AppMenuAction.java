package bwpt.app.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import bwpt.app.domain.AppMenu;
import bwpt.app.service.AppMenuService;
import bwpt.base.action.BaseAction;
import bwpt.tool.utils.Page;
import bwpt.user.domain.User;
import bwpt.user.service.UserService;

public class AppMenuAction extends BaseAction implements ModelDriven<AppMenu>{
	//注入service
	private AppMenuService appMenuService;
	public void setAppMenuService(AppMenuService appMenuService) {
		this.appMenuService = appMenuService;
	}
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//分页查询
	private Page page  = new Page();
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	//模型驱动
	private AppMenu model = new AppMenu();
	public AppMenu getModel() {
		return model;
	}
	// 文件上传需要的三个属性:
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	//批量删除的ids
	private String ids;
	
	/**
	 * 分页查询
	 */
	public String list() throws Exception {
		page.setPageSize(12);
		appMenuService.findPage("from AppMenu a where a.parentId is null", page, AppMenu.class, null);
		
		
		//设置分页的url地址
		page.setUrl("appMenuAction_list");
		
		//将page对象压入栈顶
		super.push(page);
		
		
		return "list";
	}
	
	/**
	 * 子图标分页查询
	 */
	public String slist() throws Exception {
		System.out.println("parentId:"+model.getParentId());
		page.setPageSize(12);
		Integer parentId = model.getParentId();
		String parentIdString = Integer.toString(parentId);
		if(parentIdString == null || parentIdString.length() <= 0 ) {
			appMenuService.findPage("from AppMenu ", page, AppMenu.class, null);
		} else {
			Object[] parm = new Object[]{parentId};
			appMenuService.findPage("from AppMenu a where a.parentId = ?", page, AppMenu.class, parm);
		}
		
		//设置分页的url地址
		page.setUrl("appMenuAction_list");
		
		//将page对象压入栈顶
		super.push(page);
		
		
		return "list";
	}
	
	/**
	 * app分页查询
	 */
	public String plist() throws Exception {
		page.setPageSize(15);
		//appMenuService.findPage("from AppMenu a where a.parentId is null", page, AppMenu.class, null);
		appMenuService.findPage("from AppMenu as a inner join fetch a.users as u where u.id=1  and a.parentId is null ", page, AppMenu.class, null);
		//设置分页的url地址
		page.setUrl("appMenuAction_list");
		
		//将page对象压入栈顶
		super.push(page);
		
		
		return "plist";
	}
	
	/**
	 * app子图标分页查询
	 */
	public String pslist() throws Exception {
		page.setPageSize(15);
		System.out.println("parentId:"+model.getParentId());
		
		Integer parentId = model.getParentId();
		String parentIdString = Integer.toString(parentId);
		if(parentIdString == null || parentIdString.length() <= 0 ) {
			appMenuService.findPage("from AppMenu ", page, AppMenu.class, null);
		} else {
			Object[] parm = new Object[]{parentId};
			appMenuService.findPage("from AppMenu as a inner join fetch a.users as u where u.id=1  and  a.parentId = ?", page, AppMenu.class, parm);
		}
		
		//设置分页的url地址
		page.setUrl("appMenuAction_list");
		
		//将page对象压入栈顶
		super.push(page);
		
		
		return "plist";
	}
	/**
	 * 查询自定义菜单
	 * @throws IOException 
	 */
	public void findAutoMenu() throws IOException {
		//通过对象导航加载该用户的Menu
		  User user = userService.get(User.class, 1);
		  Set<AppMenu> hadAppMenus = user.getAppMenus();
		//找出所有的Menu
		  List<AppMenu> appMenusList = appMenuService.find("from AppMenu", AppMenu.class, null);
		  
			int size=appMenusList.size();
			//4.组织json串
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			
			for(AppMenu appMenu :appMenusList){
				size--;
				sb.append("{\"id\":\"").append(appMenu.getId());
				sb.append("\",\"pId\":\"").append(appMenu.getParentId());
				sb.append("\",\"name\":\"").append(appMenu.getName());
				sb.append("\",\"checked\":\"");
				if(hadAppMenus.contains(appMenu)){
					sb.append("true");
				}else{
					sb.append("false");
				}
				sb.append("\"}");
				
				if(size>0){
					sb.append(",");
				}
			}
			
			sb.append("]");
			
			//5.得到response对象
			HttpServletResponse response = ServletActionContext.getResponse();
			
			response.setContentType("application/json;charset=UTF-8");
			response.setHeader("Cache-Control", "no-cache");
			//6.使用 response对象输出json串
			response.getWriter().write(sb.toString());
	}
	/**
	 *保存当前用户选中的appMenu 
	 */
	public String changeAppMenu() throws Exception {
		//1.哪个角色？
		User user = userService.get(User.class, 1);
		//2.选中的模块有哪些？
		String ids [] = checkedIds.split(",");
		System.out.println(ids);
		Integer intIds[] = changToInteger(ids);
		//加载出这些模块列表
		Set<AppMenu> appMenuSet = new HashSet<AppMenu>();
		if(ids!=null && ids.length>0){
			for(Integer id :intIds){
				
				appMenuSet.add(appMenuService.get(AppMenu.class, id));//添加选中的模块，放到模块列表中
			}
		}
		
		//3.实现用户分配新的AppMenu
		user.setAppMenus(appMenuSet);
		//4.保存结果
		userService.update(user);
		
		//5.跳页面
		return "changePlist";
	}
	/**
	 * 新增
	 */
	public String insert() throws IOException {
		if(upload != null){
			int last = uploadFileName.lastIndexOf(".");
			String type = uploadFileName.substring(last);
			String newFileName = getUUID()+type;
			System.out.println("新的文件名称是："+newFileName);
			// 将图片上传到服务器上.
			// 获得上传图片的服务器端路径.
			String path = ServletActionContext.getServletContext().getRealPath(
					"/source/appMenu");
			System.out.println("路径："+path);
			// 创建文件类型对象:
			File diskFile = new File(path + "/" + newFileName);
			// 文件上传:
			FileUtils.copyFile(upload, diskFile);
			
			// 将提交的数据添加到数据库中.
			model.setUploadTime(new Date());
			model.setPath(newFileName);
			appMenuService.saveOrUpdate(model);
			return "insert";
		} else {
			ActionContext.getContext().getSession().put("errMsg", "上传失败！");
			return "error";
		}
	}
	
	/**
	 * 批量删除
	 * @return
	 * @throws IOException 
	 */
	public void deleteByIds() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();  
		response.setContentType("text/html;charset=utf-8");
		System.out.println("ids:"+ids);
        //用response向前台写数据  
		String[] delId = ids.split(",");
		appMenuService.delete(AppMenu.class, changToInteger(delId));
		System.out.println(delId);
		String json;
		json = "{\"success\":\"true\"}";
        response.getWriter().write(json);  
        response.getWriter().flush();  
        response.getWriter().close();
	}
	
	
	//============================
	private String checkedIds;//选中的id
	public void setCheckedIds(String checkedIds) {
		this.checkedIds = checkedIds;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
}

