package bwpt.tool.utils;

import java.util.List;

/**
 * 分页的JavaBean
 * @author Administrator
 */
public class PageBean<T> {
	
	// 常量，每页显示3条
	public static final int PAGESIZE_CRM = 8;
	
	// 当前页
	private int pageCode;
	
	// 总页数 = 总记录数 / 每页显示的记录的条数
	// private int totalPage;
	
	// 总记录数
	private int totalCount;
	// 每页显示的记录的条数
	private int pageSize;
	// 每页显示的数据
	private List<T> beanList;
	
	// 作为查询的条件
	private String url;
	
	public int getPageCode() {
		return pageCode;
	}
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	
	// 获取总页数 totalPage
	public int getTotalPage() {
		// 可以计算
		int totalPage = totalCount / pageSize;
		// 说明是整除
		if(totalCount % pageSize == 0){
			return totalPage;
		}else{
			return totalPage + 1;
		}
	}
	
	/*
	// 不用自己设置值的，计算出来的
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}*/
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
