package sougou.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sougou.exception.DatabaseException;
import sougou.exception.SystemException;
import sougou.parameter.ExceptionParameters;
import sougou.parameter.DatabaseParameters;

public class OnlyDAO extends DAOBase {
	public String getUsername(String userid) throws DatabaseException,SystemException {
        String str=null;
        PreparedStatement stmt = null;
        this.open();
        try {
            stmt = con.prepareStatement(DatabaseParameters.SQL_SELECT_USER_NAME);
            stmt.setString(1, userid);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            str=(rs.getString(DatabaseParameters.USER_NAME));
        }
        catch (SQLException e){
            throw new DatabaseException(
                    ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
        }
        finally{
            this.close(stmt);
        }
        return str;
    }
	
	public String getPassword(String userid) throws DatabaseException,SystemException {
        String str=null;
        PreparedStatement stmt = null;
        this.open();
        try {
            stmt = con.prepareStatement(DatabaseParameters.SQL_SELECT_PASSWORD);
            stmt.setString(1, userid);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            str=(rs.getString(DatabaseParameters.PASSWORD));
        }
        catch (SQLException e){
            throw new DatabaseException(
                    ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
        }
        finally{
            this.close(stmt);
        }
        return str;
    }
	
	public String getRole(String userid) throws DatabaseException,SystemException {
        String str=null;
        PreparedStatement stmt = null;
        this.open();
        try {
            stmt = con.prepareStatement(DatabaseParameters.SQL_SELECT_ROLE);
            stmt.setString(1, userid);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            str=(rs.getString(DatabaseParameters.ROLE));
        }
        catch (SQLException e){
            throw new DatabaseException(
                    ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
        }
        finally{
            this.close(stmt);
        }
        return str;
    }
	
	public String getLicensename(String licenseid) throws DatabaseException,SystemException {
        String str=null;
        PreparedStatement stmt = null;
        this.open();
        try {
            stmt = con.prepareStatement(DatabaseParameters.SQL_SELECT_LICENSE_NAME);
            stmt.setString(1, licenseid);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            str=(rs.getString(DatabaseParameters.LICENSE_NAME));
        }
        catch (SQLException e){
            throw new DatabaseException(
                    ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
        }
        finally{
            this.close(stmt);
        }
        return str;
    }
	
	public String getLicensecreatedate(String licenseid) throws DatabaseException,SystemException {
        String str=null;
        PreparedStatement stmt = null;
        this.open();
        try {
            stmt = con.prepareStatement(DatabaseParameters.SQL_SELECT_LICENSE_CREATE_DATE);
            stmt.setString(1, licenseid);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            str=(rs.getString(DatabaseParameters.CREATE_DATE));
        }
        catch (SQLException e){
            throw new DatabaseException(
                    ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
        }
        finally{
            this.close(stmt);
        }
        return str;
    }
	
	public String getLicensegroup(String licenseid) throws DatabaseException,SystemException {
        String str=null;
        PreparedStatement stmt = null;
        this.open();
        try {
            stmt = con.prepareStatement(DatabaseParameters.SQL_SELECT_LICENSE_GROUP);
            stmt.setString(1, licenseid);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            str=(rs.getString(DatabaseParameters.LICENSE_GROUP));
        }
        catch (SQLException e){
            throw new DatabaseException(
                    ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
        }
        finally{
            this.close(stmt);
        }
        return str;
    }
	
	public int getLicenseprice(String licenseid) throws DatabaseException,SystemException {
        int integer=0;
        PreparedStatement stmt = null;
        this.open();
        try {
            stmt = con.prepareStatement(DatabaseParameters.SQL_SELECT_LICENSE_PRICE);
            stmt.setString(1, licenseid);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            integer=(rs.getInt(DatabaseParameters.LICENSE_PRICE));
        }
        catch (SQLException e){
            throw new DatabaseException(
                    ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
        }
        finally{
            this.close(stmt);
        }
        return integer;
    }
	
	public int getLicenseusercount(String licenseid,String userid) throws DatabaseException,SystemException {
        int integer=0;
        PreparedStatement stmt = null;
        this.open();
        try {
            stmt = con.prepareStatement(DatabaseParameters.SQL_SELECT_USER_LICENSE_COUNT);
            stmt.setString(1, licenseid);
            stmt.setString(2, userid);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            integer=(rs.getInt(DatabaseParameters.COUNT));
        }
        catch (SQLException e){
            throw new DatabaseException(
                    ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
        }
        finally{
            this.close(stmt);
        }
        return integer;
    }
	
	public int getLicensecount(String licenseid) throws DatabaseException,SystemException {
        int integer=0;
        PreparedStatement stmt = null;
        this.open();
        try {
            stmt = con.prepareStatement(DatabaseParameters.SQL_SELECT_LICENSE_COUNT);
            stmt.setString(1, licenseid);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            integer=(rs.getInt(DatabaseParameters.LICENSE_COUNT));
        }
        catch (SQLException e){
            throw new DatabaseException(
                    ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
        }
        finally{
            this.close(stmt);
        }
        return integer;
    }
	
	public int getLicensepass(String licenseid) throws DatabaseException,SystemException {
        int integer=0;
        PreparedStatement stmt = null;
        this.open();
        try {
            stmt = con.prepareStatement(DatabaseParameters.SQL_SELECT_LICENSE_PASS);
            stmt.setString(1, licenseid);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            integer=(rs.getInt(DatabaseParameters.LICENSE_PASS));
        }
        catch (SQLException e){
            throw new DatabaseException(
                    ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
        }
        finally{
            this.close(stmt);
        }
        return integer;
    }
	
	public void updateLicensecount(String licenseid,int count) throws DatabaseException,SystemException {
		PreparedStatement stmt = null;
		this.open();
		try {
			stmt = con.prepareStatement(DatabaseParameters.SQL_UPDATE_LICENSE_COUNT);
			stmt.setInt(1, count);
			stmt.setString(2, licenseid);
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
	
	public void updateLicensepass(String licenseid) throws DatabaseException,SystemException {
		PreparedStatement stmt = null;
		this.open();
		try {
			stmt = con.prepareStatement(DatabaseParameters.SQL_UPDATE_LICENSE_PASS);
			stmt.setString(1, licenseid);
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
	
	public void updateUserpass(String userid) throws DatabaseException,SystemException {
		PreparedStatement stmt = null;
		this.open();
		try {
			stmt = con.prepareStatement(DatabaseParameters.SQL_UPDATE_USER_PASS);
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
	
	public void deleteUserpass(String userid) throws DatabaseException,SystemException {
		PreparedStatement stmt = null;
		this.open();
		try {
			stmt = con.prepareStatement(DatabaseParameters.SQL_DELETE_USER_PASS);
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