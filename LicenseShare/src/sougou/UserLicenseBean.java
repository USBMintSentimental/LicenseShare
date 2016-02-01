package sougou;

import java.io.Serializable;
import java.util.Date;

public class UserLicenseBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userid;
	private String licenseid;
	private String licensecomment;
	private String licensepass;
	private int licensecount;
	private Date datetime;
	
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
		
	public String getLicensecomment() {
		return licensecomment;
	}
	
	public void setLicensecomment(String licensecomment) {
		this.licensecomment = licensecomment;
	}
	
	public int getLicensecount() {
		return licensecount;
	}
	
	public void setLicensecount(int licensecount) {
		this.licensecount = licensecount;
	}
	
	public String getLicensepass() {
		return licensepass;
	}
	
	public void setLicensepass(String licensepass) {
		this.licensepass = licensepass;
	}
	
	public Date getDatetime() {
		return datetime;
	}
	
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}