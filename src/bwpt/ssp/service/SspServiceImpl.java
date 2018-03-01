package bwpt.ssp.service;

import bwpt.ssp.dao.SspDao;
import bwpt.ssp.domain.Ssp;
import bwpt.tool.utils.UtilFuns;

public class SspServiceImpl implements SspService{

	private SspDao sspDao;
	public void setSspDao(SspDao sspDao) {
		this.sspDao = sspDao;
	}
	
	public void saveOrUpdate(Ssp entity) {
		if(UtilFuns.isEmpty(entity.getId().toString())){
			//新增
			entity.setState(1);//1启用  0停用  默认为启用
		}
		sspDao.saveOrUpdate(entity);
	}
}
