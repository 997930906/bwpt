package bwpt.service.pc.machine;

import java.util.Collection;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import bwpt.dao.pc.machine.MachineDao;
import bwpt.domain.pc.machine.Machine;
import bwpt.tool.utils.Page;

@Transactional
public class MachineServiceImpl implements MachineService{
	//注入dao
	private MachineDao machineDao;
	public void setMachineDao(MachineDao machineDao) {
		this.machineDao = machineDao;
	}
	@Override
	public List<Machine> find(String hql, Class<Machine> entityClass, Object[] params) {
		return machineDao.find(hql, entityClass, params);
	}
	@Override
	public Machine get(Class<Machine> entityClass, Integer id) {
		return machineDao.get(entityClass, id);
	}
	@Override
	public Page<Machine> findPage(String hql, Page<Machine> page, Class<Machine> entityClass, Object[] params) {
		return machineDao.findPage(hql, page, entityClass, params);
	}
	@Override
	public void saveOrUpdate(Machine entity) {
		machineDao.saveOrUpdate(entity);
		
	}
	@Override
	public void saveOrUpdateAll(Collection<Machine> entitys) {
		machineDao.saveOrUpdateAll(entitys);
		
	}
	@Override
	public void deleteById(Class<Machine> entityClass, Integer id) {
		machineDao.deleteById(entityClass, id);//删除一个对象
		
	}
	@Override
	public void delete(Class<Machine> entityClass, Integer[] ids) {
		for(Integer id :ids){
			this.deleteById(Machine.class,id);
		}
		
	}
	
	
}
