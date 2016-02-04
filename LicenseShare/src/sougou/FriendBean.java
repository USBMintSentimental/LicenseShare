package sougou;

import java.io.Serializable;

public class FriendBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userid;
	private String friendid;
	
	public FriendBean() {
		
	}
	
	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getFriendid() {
		return friendid;
	}
	
	public void setFriendid(String friendid) {
		this.friendid = friendid;
	}
}