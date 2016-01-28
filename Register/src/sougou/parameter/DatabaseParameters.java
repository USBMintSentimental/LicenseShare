package sougou.parameter;

public class DatabaseParameters {
	public static final String USER_ID = "USER_ID";
	public static final String USER_NAME = "USER_NAME";
	public static final String PASSWORD = "PASSWORD";
	public static final String ROLE = "ROLE";
	
	public static final String SQL_INSERT_USER = "INSERT INTO User VALUES(?,?,?)";
	public static final String SQL_INSERT_ROLE = "INSERT INTO Role VALUES(?,?)";
}
