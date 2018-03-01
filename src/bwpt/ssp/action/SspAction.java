package bwpt.ssp.action;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;

import bwpt.base.action.BaseAction;
import bwpt.ssp.domain.Ssp;
import bwpt.ssp.service.SspService;
import sun.misc.BASE64Decoder;

public class SspAction extends BaseAction implements ModelDriven<Ssp>{

	private Ssp ssp = new Ssp();
	public Ssp getModel() {
		return ssp;
	}
	
	//注入service
	private SspService sspService;
	public void setSspService(SspService sspService) {
		this.sspService = sspService;
	}

	
	// 文件上传需要的三个属性:
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
			
			
	//随手拍保存
	public String  insert() {
		System.out.println("??????");
		return "insert";
	}
	// 上传？
	// 服务器端的webservice代码 ：
		public void uploadImage() { 
			String image;
			String filename;
			HttpServletRequest request = ServletActionContext.getRequest();
			image = request.getParameter("image");
			filename = request.getParameter("filename");
			System.out.println("上传图片吗");
			System.out.println(image);
			System.out.println(filename);
			FileOutputStream fos = null;  //import 了
			try{ 
				/*int comma = filename.indexOf(",");
				String projectName = filename.substring(0, comma);
				filename = filename.substring(comma+1);
				Date time = new Date();
				String newToDir = filename.substring(0,8);
				filename = filename.substring(8);
				Ssp ssp = new Ssp();
				
//				String toDir = "C:\\Usessp\\Administrator\\Desktop\\images\\" + newToDir;
				String toDir = "F:\\eclipse\\Tomcat8\\apache-tomcat-8.5.20\\webapps\\bwpt\\upload\\images\\" + newToDir;  
				
				
				byte[] buffer = new BASE64Decoder().decodeBuffer(image);   //对传过来的图片字符串进行解码   
				File destDir = new File(toDir);    
				if(!destDir.exists()) destDir.mkdir();  
				fos = new FileOutputStream(new File(destDir,filename));   //保存图片  
				fos.write(buffer);  
				fos.flush();  
				fos.close();
				
				ssp.setPath(toDir);
				sspService.saveOrUpdate(ssp);*/
		/*		String takeTime = Text.substring(0,10);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.passpe(takeTime );
				System.out.println(date);
				Text = Text.substring(11);
				comma = Text.indexOf(",");
				String position = Text.substring(0,comma);
				Text = Text.substring(comma+1);
				String url = "upload\\images\\" + newToDir + "\\" + filename;
				ssp.setComment(Text);
				ssp.setUrl(url);
				ssp.setUploadTime(time);
				ssp.setUploadedBy(userAccount);
				ssp.setPosition(position);
				ssp.setTakeTime(date);
				ssp.setProjectName(projectName);
				hiddenTroubleSolutionDAO.insertReadilyShoot(ssp);*/
				System.out.println("!!!!!!!!!!!!!");
				
			}catch (Exception e){  
				e.printStackTrace();  
			}  
		}  


}
