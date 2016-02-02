package sougou.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import sougou.exception.DatabaseException;
import sougou.exception.SystemException;
import sougou.parameter.ExceptionParameters;
import sougou.parameter.DatabaseParameters;
import sougou.LicenseDataBean;
import sougou.LicenseBean;
import sougou.UserLicenseBean;
import sougou.UserLicenseDataBean;

public class LicenseDAO extends DAOBase {
	public LicenseDataBean getLicenseData() throws DatabaseException, SystemException {
        Statement stmt = null;
        LicenseDataBean licenseArray = new LicenseDataBean();
        this.open();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(DatabaseParameters.SQL_SELECT_LICENSE);
            while (rs.next()) {
                LicenseBean record = new LicenseBean();
                record.setLicensegroup(rs.getString(DatabaseParameters.LICENSE_GROUP));
                record.setLicenseid(rs.getString(DatabaseParameters.LICENSE_ID));
                record.setLicensename(rs.getString(DatabaseParameters.LICENSE_NAME));
                record.setLicenseprice(rs.getInt(DatabaseParameters.LICENSE_PRICE));
                licenseArray.addLicense(record);
            }
        }
        catch(SQLException e){
            throw new DatabaseException(
                    ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
        }
        finally{
            this.close(stmt);
        }
        return licenseArray;
    }
	
	public LicenseDataBean getLicenseCountData() throws DatabaseException, SystemException {
        Statement stmt = null;
        LicenseDataBean licenseArray = new LicenseDataBean();
        this.open();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(DatabaseParameters.SQL_SELECT_LICENSE_ALL_COUNT);
            while (rs.next()) {
                LicenseBean record = new LicenseBean();
                record.setLicensegroup(rs.getString(DatabaseParameters.LICENSE_GROUP));
                record.setLicenseid(rs.getString(DatabaseParameters.LICENSE_ID));
                record.setLicensename(rs.getString(DatabaseParameters.LICENSE_NAME));
                record.setLicenseprice(rs.getInt(DatabaseParameters.LICENSE_PRICE));
                record.setLicensecount(rs.getInt(DatabaseParameters.LICENSE_COUNT));
                licenseArray.addLicense(record);
            }
        }
        catch(SQLException e){
            throw new DatabaseException(
                    ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
        }
        finally{
            this.close(stmt);
        }
        return licenseArray;
    }
	
	public LicenseDataBean getLicensePassData() throws DatabaseException, SystemException {
        Statement stmt = null;
        LicenseDataBean licenseArray = new LicenseDataBean();
        this.open();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(DatabaseParameters.SQL_SELECT_LICENSE_ALL_PASS);
            while (rs.next()) {
                LicenseBean record = new LicenseBean();
                record.setLicensegroup(rs.getString(DatabaseParameters.LICENSE_GROUP));
                record.setLicenseid(rs.getString(DatabaseParameters.LICENSE_ID));
                record.setLicensename(rs.getString(DatabaseParameters.LICENSE_NAME));
                record.setLicenseprice(rs.getInt(DatabaseParameters.LICENSE_PRICE));
                record.setLicensepass(rs.getInt(DatabaseParameters.LICENSE_PASS));
                licenseArray.addLicense(record);
            }
        }
        catch(SQLException e){
            throw new DatabaseException(
                    ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
        }
        finally{
            this.close(stmt);
        }
        return licenseArray;
    }
	
	public UserLicenseDataBean getUserLicenseData() throws DatabaseException, SystemException {
        Statement stmt = null;
        UserLicenseDataBean userlicenseArray = new UserLicenseDataBean();
        this.open();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(DatabaseParameters.SQL_SELECT_ALL_USER_LICENSE);
            while (rs.next()) {
                UserLicenseBean record = new UserLicenseBean();
                record.setUserid(rs.getString(DatabaseParameters.USER_ID));
                record.setLicenseid(rs.getString(DatabaseParameters.LICENSE_ID));
                record.setLicensecomment(rs.getString(DatabaseParameters.LICENSE_COMMENT));
                record.setLicensepass(rs.getString(DatabaseParameters.LICENSE_PASS));
                record.setDatetime(rs.getDate(DatabaseParameters.SYUTOKU_DATE));
                userlicenseArray.addUserLicense(record);
            }
        }
        catch(SQLException e){
            throw new DatabaseException(
                    ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
        }
        finally{
            this.close(stmt);
        }
        return userlicenseArray;
    }
	
	public void insertLicense(LicenseBean license) throws DatabaseException,SystemException {
		PreparedStatement stmt = null;
		this.open();
		try {
			stmt = con.prepareStatement(DatabaseParameters.SQL_INSERT_LICENSE);
			stmt.setString(1, license.getLicensegroup());
			stmt.setString(2, license.getLicenseid());
			stmt.setString(3, license.getLicensename());
			stmt.setInt(4, license.getLicenseprice());
			stmt.setInt(5, license.getLicensecount());
			stmt.setInt(6, license.getLicensepass());
			stmt.setString(7, new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(license.getDatetime()));
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
	
	public void insertUserLicense(UserLicenseBean license) throws DatabaseException,SystemException {
		PreparedStatement stmt = null;
		this.open();
		try {
			stmt = con.prepareStatement(DatabaseParameters.SQL_INSERT_USER_LICENSE);
			stmt.setString(1, license.getLicenseid());
			stmt.setString(2, license.getUserid());
			stmt.setString(3, license.getLicensecomment());
			stmt.setInt(4, license.getLicensecount());
			stmt.setString(5, license.getLicensepass());
			stmt.setString(6, new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(license.getDatetime()));
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
	
	public void updateLicense(LicenseBean license) throws DatabaseException,SystemException {
		PreparedStatement stmt = null;
		this.open();
		try {
			stmt = con.prepareStatement(DatabaseParameters.SQL_UPDATE_LICENSE);
			stmt.setString(1, license.getLicensegroup());
			stmt.setString(2, license.getLicensename());
			stmt.setInt(3, license.getLicenseprice());
			stmt.setString(4, license.getLicenseid());
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
	
	public void updateUserLicense(LicenseBean license) throws DatabaseException,SystemException {
		PreparedStatement stmt = null;
		this.open();
		try {
			stmt = con.prepareStatement(DatabaseParameters.SQL_UPDATE_USER_LICENSE);
			stmt.setString(1, license.getLicenseid());
			stmt.setString(2, license.getUserid());
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
	
	public void deleteLicense(String licenseid) throws DatabaseException,SystemException {
		PreparedStatement stmt = null;
		this.open();
		try {
			stmt = con.prepareStatement(DatabaseParameters.SQL_DELETE_LICENSE);
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
	
	public void deleteUserLicense(LicenseBean license) throws DatabaseException,SystemException {
		PreparedStatement stmt = null;
		this.open();
		try {
			stmt = con.prepareStatement(DatabaseParameters.SQL_DELETE_USER_LICENSE);
			stmt.setString(1, license.getLicenseid());
			stmt.setString(2, license.getUserid());
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