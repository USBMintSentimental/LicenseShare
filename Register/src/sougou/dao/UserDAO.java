package sougou.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import sougou.exception.DatabaseException;
import sougou.exception.SystemException;
import sougou.parameter.ExceptionParameters;
import sougou.parameter.DatabaseParameters;
import sougou.UserBean;

public class UserDAO extends DAOBase {
	public void insertUser(UserBean user) throws DatabaseException,SystemException {
		PreparedStatement stmt = null;
		this.open();
		try {
			stmt = con.prepareStatement(DatabaseParameters.SQL_INSERT_USER);
			stmt.setString(1, user.getUserid());
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getPasswd());
			stmt.setInt(4, 0);
			stmt.executeUpdate();
			stmt = con.prepareStatement(DatabaseParameters.SQL_INSERT_ROLE);
			stmt.setString(1, user.getUserid());
			stmt.setString(2, user.getRole());
			stmt.executeUpdate();
		}
		catch(SQLException e){
			throw new DatabaseException(
					ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
		}
		finally{
			this.close(stmt);
		}
	}
}