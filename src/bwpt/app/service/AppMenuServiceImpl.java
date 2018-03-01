package bwpt.app.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import bwpt.app.dao.AppMenuDao;
import bwpt.app.domain.AppMenu;
import bwpt.tool.utils.Page;

@Transactional
public class AppMenuServiceImpl implements AppMenuService{
	//注入dao
	private AppMenuDao appMenuDao;
	public void setAppMenuDao(AppMenuDao appMenuDao) {
		this.appMenuDao = appMenuDao;
	}
	@Override
	public List<AppMenu> find(String hql, Class<AppMenu> entityClass, Object[] params) {
		return appMenuDao.find(hql, entityClass, params);
	}
	@Override
	public AppMenu get(Class<AppMenu> entityClass, Integer id) {
		return appMenuDao.get(entityClass, id);
	}
	@Override
	public Page<AppMenu> findPage(String hql, Page<AppMenu> page, Class<AppMenu> entityClass, Object[] params) {
		return appMenuDao.findPage(hql, page, entityClass, params);
	}
	@Override
	public void saveOrUpdate(AppMenu entity) {
		appMenuDao.saveOrUpdate(entity);
		
	}
	@Override
	public void saveOrUpdateAll(Collection<AppMenu> entitys) {
		appMenuDao.saveOrUpdateAll(entitys);
		
	}
	@Override
	public void deleteById(Class<AppMenu> entityClass, Integer id) {
		appMenuDao.deleteById(entityClass, id);//删除一个对象
		
	}
	@Override
	public void delete(Class<AppMenu> entityClass, Integer[] ids) {
		for(Integer id :ids){
			this.deleteById(AppMenu.class,id);
		}
		
	}
	
	
}
