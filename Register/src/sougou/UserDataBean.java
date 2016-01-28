package sougou;

import java.io.Serializable;
import java.util.ArrayList;

public class UserDataBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<UserBean> userArray;
	
	public UserDataBean() {
		userArray = new ArrayList<UserBean>();
	}
	
	public void addUser(UserBean obj) {
		userArray.add(obj);
	}
	
	public int getArraySize() {
		return userArray.size();
	}
	
	public ArrayList<UserBean>getUserArray() {
		return userArray;
	}
	
	public void setUserArray(ArrayList<UserBean> userArray) {
		this.userArray = userArray;
	}
	
}