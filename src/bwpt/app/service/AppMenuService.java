package bwpt.app.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import bwpt.app.domain.AppMenu;
import bwpt.tool.utils.Page;


public interface AppMenuService {

	//查询所有，带条件查询
	public  List<AppMenu> find(String hql, Class<AppMenu> entityClass, Object[] params);
	//获取一条记录
	public  AppMenu get(Class<AppMenu> entityClass, Integer id);
	//分页查询，将数据封装到一个page分页工具类对象
	public  Page<AppMenu> findPage(String hql, Page<AppMenu> page, Class<AppMenu> entityClass, Object[] params);
	
	//新增和修改保存
	public  void saveOrUpdate(AppMenu entity);
	//批量新增和修改保存
	public  void saveOrUpdateAll(Collection<AppMenu> entitys);
	
	//单条删除，按id
	public  void deleteById(Class<AppMenu> entityClass, Integer id);
	//批量删除
	public  void delete(Class<AppMenu> entityClass, Integer[] ids);
}
