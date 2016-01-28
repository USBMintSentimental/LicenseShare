package sougou;

import java.io.Serializable;
import java.util.Date;

public class LicenseBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userid;
	private String licenseid;
	private String licensename;
	private String licensegroup;
	private int licenseprice;
	private Date datetime;
	
	public LicenseBean() {
		
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
	
	public String getLicensename() {
		return licensename;
	}
	
	public void setLicensename(String licensename) {
		this.licensename = licensename;
	}
	
	public String getLicensegroup() {
		return licensegroup;
	}
	
	public void setLicensegroup(String licensegroup) {
		this.licensegroup = licensegroup;
	}
	
	public int getLicenseprice() {
		return licenseprice;
	}
	
	public void setLicenseprice(int licenseprice) {
		this.licenseprice = licenseprice;
	}
	
	public Date getDatetime() {
		return datetime;
	}
	
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}