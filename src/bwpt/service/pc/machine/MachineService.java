package bwpt.service.pc.machine;

import java.util.Collection;
import java.util.List;

import bwpt.domain.pc.machine.Machine;
import bwpt.tool.utils.Page;


public interface MachineService {

	//查询所有，带条件查询
	public  List<Machine> find(String hql, Class<Machine> entityClass, Object[] params);
	//获取一条记录
	public  Machine get(Class<Machine> entityClass, Integer id);
	//分页查询，将数据封装到一个page分页工具类对象
	public  Page<Machine> findPage(String hql, Page<Machine> page, Class<Machine> entityClass, Object[] params);
	
	//新增和修改保存
	public  void saveOrUpdate(Machine entity);
	//批量新增和修改保存
	public  void saveOrUpdateAll(Collection<Machine> entitys);
	
	//单条删除，按id
	public  void deleteById(Class<Machine> entityClass, Integer id);
	//批量删除
	public  void delete(Class<Machine> entityClass, Integer[] ids);
}
