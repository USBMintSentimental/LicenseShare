package sougou.parameter;

public class DatabaseParameters {
	public static final String USER_ID = "USER_ID";
	public static final String USER_NAME = "USER_NAME";
	public static final String PASSWORD = "PASSWORD";
	public static final String ROLE = "ROLE";
	public static final String TIME = "TIME";
	
	public static final String LICENSE_ID = "LICENSE_ID";
	public static final String LICENSE_NAME = "LICENSE_NAME";
	public static final String COMMENT = "COMMENT";
	public static final String COUNT = "COUNT";
	public static final String CREATE_DATE = "CREATE_DATE";
	public static final String LICENSE_GROUP = "LICENSE_GROUP";
	public static final String LICENSE_PRICE = "LICENSE_PRICE";
	
	public static final String SQL_SELECT_USER = "SELECT * FROM User";
	public static final String SQL_SELECT_PERSON_USER = "SELECT * FROM User,Role WHERE User.USER_ID = Role.USER_ID AND User.USER_ID=?";
	public static final String SQL_UPDATE_USER = "UPDATE User SET USER_NAME=?,PASSWORD=? WHERE USER_ID=?";
	public static final String SQL_UPDATE_ROLE = "UPDATE Role SET ROLE=? WHERE USER_ID=?";
	public static final String SQL_DELETE_ROLE = "DELETE FROM Role WHERE USER_ID=?";
	public static final String SQL_DELETE_USER = "DELETE FROM User WHERE USER_ID=?";
	
	public static final String SQL_INSERT_LICENSE = "INSERT INTO License VALUES(?,?,?,?,?)";
	public static final String SQL_SELECT_LICENSE = "SELECT * FROM License";
	public static final String SQL_UPDATE_LICENSE = "UPDATE License SET LICENSE_NAME=? WHERE LICENSE_ID=?";
	public static final String SQL_DELETE_LICENSE = "DELETE FROM License WHERE LICENSE_ID=?";
	
	public static final String SQL_SELECT_ALL_USER_LICENSE = "SELECT * FROM Syutoku";
	
	public static final String SQL_INSERT_USER_LICENSE = "INSERT INTO Syutoku VALUES(?,?,?,?,?)";
	public static final String SQL_SELECT_USER_LICENSE = "SELECT LICENSE_NAME FROM License WHERE LICENSE_ID=?";
	public static final String SQL_UPDATE_USER_LICENSE = "UPDATE Syutoku SET LICENSE_ID=? WHERE USER_ID=?";
	public static final String SQL_DELETE_USER_LICENSE = "DELETE FROM Syutoku WHERE LICENSE_ID=? AND USER_ID=?";
	
	public static final String SQL_SELECT_USER_NAME = "SELECT USER_NAME FROM User WHERE USER_ID=?";
	public static final String SQL_SELECT_PASSWORD = "SELECT PASSWORD FROM User WHERE USER_ID=?";
	public static final String SQL_SELECT_ROLE = "SELECT ROLE FROM Role WHERE USER_ID=?";
	
	public static final String SQL_SELECT_LICENSE_NAME = "SELECT LICENSE_NAME FROM License WHERE LICENSE_ID=?";
	public static final String SQL_SELECT_LICENSE_CREATE_DATE = "SELECT CREATE_DATE FROM License WHERE LICENSE_ID=?";
	public static final String SQL_SELECT_LICENSE_GROUP = "SELECT LICENSE_GROUP FROM License WHERE LICENSE_ID=?";
	public static final String SQL_SELECT_LICENSE_PRICE = "SELECT LICENSE_PRICE FROM License WHERE LICENSE_ID=?";
	public static final String SQL_SELECT_LICENSE_COUNT = "SELECT COUNT FROM Syutoku WHERE LICENSE_ID=? AND USER_ID=?";
}