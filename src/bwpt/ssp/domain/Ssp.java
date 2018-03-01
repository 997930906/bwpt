package bwpt.ssp.domain;

import java.io.Serializable;

public class Ssp implements Serializable{
	private static final long serialVersionUID = -8532675785240297606L;
	private Integer id;
	private String path;
	private int state;
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
