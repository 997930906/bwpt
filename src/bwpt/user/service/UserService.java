package bwpt.user.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import bwpt.tool.utils.Page;
import bwpt.user.domain.User;

public interface UserService {

	//查询所有，带条件查询
		public  List<User> find(String hql, Class<User> entityClass, Object[] params);
		//获取一条记录
		public  User get(Class<User> entityClass, Integer id);
		//分页查询，将数据封装到一个page分页工具类对象
		public  Page<User> findPage(String hql, Page<User> page, Class<User> entityClass, Object[] params);
		
		//新增和修改保存
		public  void saveOrUpdate(User entity);
		//批量新增和修改保存
		public  void saveOrUpdateAll(Collection<User> entitys);
		
		//单条删除，按id
		public  void deleteById(Class<User> entityClass, Integer id);
		//批量删除
		public  void delete(Class<User> entityClass, Integer[] ids);
		
		//保存
		public void update(User user);
}
