package sougou.parameter;

public class DatabaseParameters {
	public static final String USER_ID = "USER_ID";
	public static final String USER_NAME = "USER_NAME";
	public static final String PASSWORD = "PASSWORD";
	public static final String ROLE = "ROLE";
	
	public static final String LICENSE_GROUP = "LICENSE_GROUP";
	public static final String LICENSE_ID = "LICENSE_ID";
	public static final String LICENSE_NAME = "LICENSE_NAME";
	public static final String LICENSE_PRICE = "LICENSE_PRICE";
	public static final String LICENSE_COMMENT = "LICENSE_COMMENT";
	public static final String LICENSE_COUNT = "LICENSE_COUNT";
	public static final String LICENSE_PASS = "LICENSE_PASS";
	public static final String CREATE_DATE = "CREATE_DATE";
	public static final String SYUTOKU_DATE = "SYUTOKU_DATE";
	
	public static final String FRIEND_ID = "FRIEND_ID";
	public static final String FRIEND_CHECK = "FRIEND_CHECK";
	
	public static final String COUNTER = "COUNTER";
	
	public static final String SQL_SELECT_COUNTER = "SELECT COUNTER FROM Counter";
	public static final String SQL_UPDATE_COUNTER = "UPDATE Counter SET COUNTER = COUNTER+1";
	
	public static final String SQL_SELECT_USER = "SELECT * FROM User";
	public static final String SQL_SELECT_PERSON_USER = "SELECT * FROM User,Role WHERE User.USER_ID = Role.USER_ID AND User.USER_ID=?";
	public static final String SQL_UPDATE_USER = "UPDATE User SET USER_NAME=?,PASSWORD=? WHERE USER_ID=?";
	public static final String SQL_UPDATE_ROLE = "UPDATE Role SET ROLE=? WHERE USER_ID=?";
	public static final String SQL_DELETE_ROLE = "DELETE FROM Role WHERE USER_ID=?";
	public static final String SQL_DELETE_USER = "DELETE FROM User WHERE USER_ID=?";
	
	public static final String SQL_INSERT_LICENSE = "INSERT INTO License VALUES(?,?,?,?,?,?,?)";
	public static final String SQL_SELECT_LICENSE = "SELECT * FROM License ORDER BY LICENSE_GROUP,LICENSE_ID";
	public static final String SQL_SELECT_LICENSE_ALL_COUNT = "SELECT * FROM License ORDER BY LICENSE_COUNT DESC LIMIT 5";
	public static final String SQL_SELECT_LICENSE_ALL_PASS = "SELECT * FROM License ORDER BY LICENSE_PASS DESC LIMIT 5";
	public static final String SQL_UPDATE_LICENSE = "UPDATE License SET LICENSE_GROUP=?,LICENSE_NAME=?,LICENSE_PRICE=? WHERE LICENSE_ID=?";
	public static final String SQL_UPDATE_LICENSE_COUNT = "UPDATE License SET LICENSE_COUNT = LICENSE_COUNT+? WHERE LICENSE_ID=?";
	public static final String SQL_UPDATE_LICENSE_PASS = "UPDATE License SET LICENSE_PASS = LICENSE_PASS+1 WHERE LICENSE_ID=?";
	public static final String SQL_UPDATE_USER_PASS = "UPDATE User SET LICENSE_PASS = LICENSE_PASS+1 WHERE USER_ID=?";
	public static final String SQL_DELETE_USER_PASS = "UPDATE User SET LICENSE_PASS = LICENSE_PASS-1 WHERE USER_ID=?";
	public static final String SQL_SELECT_USER_PASS = "SELECT * FROM User ORDER BY PASS DESC LIMIT 5";
	public static final String SQL_DELETE_LICENSE = "DELETE FROM License WHERE LICENSE_ID=?";
	
	public static final String SQL_SELECT_ALL_USER_LICENSE = "SELECT * FROM Syutoku ORDER BY LICENSE_ID DESC";
	
	public static final String SQL_INSERT_USER_LICENSE = "INSERT INTO Syutoku VALUES(?,?,?,?,?,?)";
	public static final String SQL_SELECT_USER_LICENSE = "SELECT LICENSE_NAME FROM License WHERE LICENSE_ID=?";
	public static final String SQL_UPDATE_USER_LICENSE = "UPDATE Syutoku SET LICENSE_ID=? WHERE USER_ID=?";
	public static final String SQL_DELETE_USER_LICENSE = "DELETE FROM Syutoku WHERE LICENSE_ID=? AND USER_ID=?";
	
	public static final String SQL_SELECT_USER_ID = "SELECT USER_ID FROM User WHERE USER_ID=?";
	public static final String SQL_SELECT_USER_NAME = "SELECT USER_NAME FROM User WHERE USER_ID=?";
	public static final String SQL_SELECT_PASSWORD = "SELECT PASSWORD FROM User WHERE USER_ID=?";
	public static final String SQL_SELECT_ROLE = "SELECT ROLE FROM Role WHERE USER_ID=?";
	
	public static final String SQL_SELECT_LICENSE_NAME = "SELECT LICENSE_NAME FROM License WHERE LICENSE_ID=?";
	public static final String SQL_SELECT_LICENSE_CREATE_DATE = "SELECT CREATE_DATE FROM License WHERE LICENSE_ID=?";
	public static final String SQL_SELECT_LICENSE_GROUP = "SELECT LICENSE_GROUP FROM License WHERE LICENSE_ID=?";
	public static final String SQL_SELECT_LICENSE_PRICE = "SELECT LICENSE_PRICE FROM License WHERE LICENSE_ID=?";
	public static final String SQL_SELECT_USER_LICENSE_COUNT = "SELECT LICENSE_COUNT FROM Syutoku WHERE LICENSE_ID=? AND USER_ID=?";
	
	public static final String SQL_SELECT_LICENSE_COUNT = "SELECT LICENSE_COUNT FROM License WHERE LICENSE_ID=?";
	public static final String SQL_SELECT_LICENSE_PASS = "SELECT LICENSE_PASS FROM License WHERE LICENSE_ID=?";
	
	public static final String SQL_SELECT_FRIEND = "SELECT * FROM FRIEND";
	
	public static final String SQL_INSERT_FRIEND = "INSERT INTO Friend VALUES(?,?,?,?)";
	public static final String SQL_UPDATE_FRIEND = "UPDATE Friend SET FRIEND_CHECK=? WHERE USER_ID=? AND FRIEND_ID=?";
	public static final String SQL_DELETE_FRIEND = "DELETE FROM Friend WHERE USER_ID=? AND FRIEND_ID=?";
	
	public static final String SQL_SELECT_FRIEND_STATE = "SELECT * FROM FRIEND WHERE USER_ID=? AND FRIEND_ID=?";
	public static final String SQL_SELECT_FRIEND_CHECK = "SELECT * FROM FRIEND WHERE USER_ID=? AND FRIEND_ID=?";
	
	public static final String SQL_DELETE_FRIEND_DATA = "DELETE FROM Friend WHERE USER_ID=? OR FRIEND_ID=?";
}
