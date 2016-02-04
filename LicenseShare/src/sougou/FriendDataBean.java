package sougou;

import java.io.Serializable;
import java.util.ArrayList;

public class FriendDataBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<FriendBean> friendArray;
	
	public FriendDataBean() {
		friendArray = new ArrayList<FriendBean>();
	}
	
	public void addFriend(FriendBean obj) {
		friendArray.add(obj);
	}
	
	public int getArraySize() {
		return friendArray.size();
	}
	
	public ArrayList<FriendBean>getFriendArray() {
		return friendArray;
	}
	
	public void setFriendArray(ArrayList<FriendBean> friendArray) {
		this.friendArray = friendArray;
	}
	
}