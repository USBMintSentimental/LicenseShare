package sougou;

import java.io.Serializable;
import java.util.Date;

public class UserLicenseBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userid;
	private String licenseid;
	private String comment;
	private int count;
	private Date datetime;
	private String pass;
	
	public UserLicenseBean() {
		
	}
	
	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getLicenseid() {
		return licenseid;
	}
	
	public void setLicenseid(String licenseid) {
		this.licenseid = licenseid;
	}
		
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public Date getDatetime() {
		return datetime;
	}
	
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}