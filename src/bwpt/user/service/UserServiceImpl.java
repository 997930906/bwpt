package bwpt.user.service;

import java.util.Collection;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import bwpt.tool.utils.Page;
import bwpt.user.dao.UserDao;
import bwpt.user.domain.User;
@Transactional
public class UserServiceImpl implements UserService{

	//注入dao
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> find(String hql, Class<User> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return userDao.find(hql, entityClass, params);
	}

	@Override
	public User get(Class<User> entityClass, Integer id) {
		return userDao.get(entityClass, id);
	}
	@Override
	public Page<User> findPage(String hql, Page<User> page, Class<User> entityClass, Object[] params) {
		return userDao.findPage(hql, page, entityClass, params);
	}
	@Override
	public void saveOrUpdate(User entity) {
		userDao.saveOrUpdate(entity);
		
	}
	@Override
	public void saveOrUpdateAll(Collection<User> entitys) {
		userDao.saveOrUpdateAll(entitys);
		
	}
	@Override
	public void deleteById(Class<User> entityClass, Integer id) {
		userDao.deleteById(entityClass, id);//删除一个对象
		
	}
	@Override
	public void delete(Class<User> entityClass, Integer[] ids) {
		for(Integer id :ids){
			this.deleteById(User.class,id);
		}
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}
	
}
