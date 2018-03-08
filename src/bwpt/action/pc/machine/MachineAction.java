package bwpt.action.pc.machine;

import java.io.File;
import com.opensymphony.xwork2.ModelDriven;

import bwpt.base.action.BaseAction;
import bwpt.domain.pc.machine.Machine;
import bwpt.service.pc.machine.MachineService;
import bwpt.tool.utils.Page;

public class MachineAction extends BaseAction implements ModelDriven<Machine>{
	//注入service
	private MachineService machineService;
	public void setMachineService(MachineService machineService) {
		this.machineService = machineService;
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
	private Machine model = new Machine();
	public Machine getModel() {
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
		machineService.findPage("from Machine", page, Machine.class, null);
		
		
		//设置分页的url地址
		page.setUrl("machineAction_list");
		
		//将page对象压入栈顶
		super.push(page);
		
		
		return "list";
	}
	
	/**
	 * 到定义机器页面
	 */
	public String machineDefineUI() {
		
		return "machineDefineUI";
	}
	
	
}

