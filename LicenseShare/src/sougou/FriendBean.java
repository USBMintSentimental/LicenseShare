package sougou;

import java.io.Serializable;
import java.util.Date;

public class FriendBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userid;
	private String friendid;
	private String check;
	private Date createdate;
	
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
	
	public String getCheck() {
		return check;
	}
	
	public void setCheck(String check) {
		this.check = check;
	}
	
	public Date getCreatedate() {
		return createdate;
	}
	
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
}