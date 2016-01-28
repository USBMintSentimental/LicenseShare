package sougou;

import java.io.Serializable;
import java.util.ArrayList;

public class LicenseDataBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<LicenseBean> licenseArray;
	
	public LicenseDataBean() {
		licenseArray = new ArrayList<LicenseBean>();
	}
	
	public void addLicense(LicenseBean obj) {
		licenseArray.add(obj);
	}
	
	public int getArraySize() {
		return licenseArray.size();
	}
	
	public ArrayList<LicenseBean>getLicenseArray() {
		return licenseArray;
	}
	
	public void setLicenseArray(ArrayList<LicenseBean> licenseArray) {
		this.licenseArray = licenseArray;
	}
	
}