package bwpt.webservice;

import java.util.Set;
import javax.jws.WebMethod;
import com.alibaba.fastjson.JSON;

import bwpt.ssp.domain.Ssp;
import bwpt.ssp.service.SspService;

public class WsServiceImpl {
    private SspService sspService;
    public void setSspService(SspService sspService) {
		this.sspService = sspService;
	}



@WebMethod
public String insert(String jsonStr) throws Exception{
	  System.out.println(jsonStr);
	  
	  
	  Ssp ssp = new Ssp();
	//  sspService.saveOrUpdate(ssp);
	  
	  //海关人员根据自己的审核标准，决定是否通过，最终以json数据作为响应的结果
	  /**
	   * {
			 exportId:"",
			 state:"",
			 remark:"",
			 products:[
			            {
			               exportProductId:"",
			               tax:""
			            },
				   {
			               exportProductId:"",
			               tax:""
			            }
			          ]
			}
	   * 
	   */
/*	  StringBuffer sb = new StringBuffer();
	  sb.append("{exportId:\"").append(export.getExportId()).append("\",");
	  sb.append("state:\"").append(2).append("\",");
	  sb.append("remark:\"").append("申报成功").append("\",");
	  sb.append("products:[");
	  Set<ExportProduct> exportSet = export.getProducts();
	  double i=1;
	  for(ExportProduct ep :exportSet){
		  sb.append("{exportProductId:\"").append(ep.getExportProductId()).append("\",");
		  sb.append("tax:\"").append(10+(i++)*0.4).append("\"},");
	  }
	  sb.delete(sb.length()-1, sb.length());
	  sb.append("]}");
	  System.out.println(sb.toString());
	  
	  return sb.toString();*/
	  
	  return "success";
  }
}
