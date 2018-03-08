package bwpt.domain.pc.machine;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import bwpt.user.domain.User;

public class Machine implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String machineName;
	private String startPoint;
	private String endPoint;
	private String pointName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public String getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}
	public String getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	public String getPointName() {
		return pointName;
	}
	public void setPointName(String pointName) {
		this.pointName = pointName;
	}
	
	
}
