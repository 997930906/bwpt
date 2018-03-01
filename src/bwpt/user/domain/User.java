package bwpt.user.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import bwpt.app.domain.AppMenu;

public class User implements Serializable {
	private static final long serialVersionUID = 7944167099709117227L;

	private Integer id;
	private String dept;// 部门
	private String position;// 职位
	private String username;// 用户名
	private String password;// 密码 要加密
	private String trueName;// 真实姓名
	private Integer state;// 状态
	private String phone;// 电话
	private Set<AppMenu> appMenus = new HashSet<AppMenu>(0);

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<AppMenu> getAppMenus() {
		return appMenus;
	}

	public void setAppMenus(Set<AppMenu> appMenus) {
		this.appMenus = appMenus;
	}

	
	
}
