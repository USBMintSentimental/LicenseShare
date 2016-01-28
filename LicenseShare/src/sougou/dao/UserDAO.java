package sougou.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sougou.exception.DatabaseException;
import sougou.exception.SystemException;
import sougou.parameter.ExceptionParameters;
import sougou.parameter.DatabaseParameters;
import sougou.UserDataBean;
import sougou.UserBean;

public class UserDAO extends DAOBase {
	public UserDataBean getUserData() throws DatabaseException, SystemException {
        Statement stmt = null;
        UserDataBean userArray = new UserDataBean();
        this.open();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(DatabaseParameters.SQL_SELECT_USER);
            while (rs.next()) {
                UserBean record = new UserBean();
                record.setUserid(rs.getString(DatabaseParameters.USER_ID));
                record.setUsername(rs.getString(DatabaseParameters.USER_NAME));
                record.setPasswd(rs.getString(DatabaseParameters.PASSWORD));
                userArray.addUser(record);
            }
        }
        catch(SQLException e){
            throw new DatabaseException(
                    ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
        }
        finally{
            this.close(stmt);
        }
        return userArray;
    }
	
	public UserBean getUser(String userid) throws DatabaseException,SystemException {
		UserBean record = null;
		PreparedStatement stmt = null;
		this.open();
		try {
			stmt = con.prepareStatement(DatabaseParameters.SQL_SELECT_PERSON_USER);
			stmt.setString(1, userid);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			record = new UserBean();
			record.setUserid(rs.getString(DatabaseParameters.USER_ID));
			record.setPasswd(rs.getString(DatabaseParameters.PASSWORD));
			record.setRole(rs.getString(DatabaseParameters.ROLE));
		}
		catch (SQLException e){
			throw new DatabaseException(
					ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
		}
		finally{
			this.close(stmt);
		}
		return record;
	}
	
	public void updateUser(UserBean user) throws DatabaseException,SystemException {
		PreparedStatement stmt = null;
		this.open();
		try {
			stmt = con.prepareStatement(DatabaseParameters.SQL_UPDATE_USER);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPasswd());
			stmt.setString(3, user.getUserid());
			stmt.executeUpdate();
			stmt = con.prepareStatement(DatabaseParameters.SQL_UPDATE_ROLE);
			stmt.setString(1, user.getRole());
			stmt.setString(2, user.getUserid());
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
	
		public void deleteUser(String userid) throws DatabaseException,SystemException {
			PreparedStatement stmt = null;
			this.open();
			try {
				stmt = con.prepareStatement(DatabaseParameters.SQL_DELETE_ROLE);
				stmt.setString(1, userid);
				stmt.executeUpdate();
				stmt = con.prepareStatement(DatabaseParameters.SQL_DELETE_USER);
				stmt.setString(1, userid);
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