package sougou;

import java.io.Serializable;
import java.util.ArrayList;

public class UserLicenseDataBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<UserLicenseBean> userlicenseArray;
	
	public UserLicenseDataBean() {
		userlicenseArray = new ArrayList<UserLicenseBean>();
	}
	
	public void addUserLicense(UserLicenseBean obj) {
		userlicenseArray.add(obj);
	}
	
	public int getArraySize() {
		return userlicenseArray.size();
	}
	
	public ArrayList<UserLicenseBean>getUserLicenseArray() {
		return userlicenseArray;
	}
	
	public void setUserLicenseArray(ArrayList<UserLicenseBean> userlicenseArray) {
		this.userlicenseArray = userlicenseArray;
	}
	
}