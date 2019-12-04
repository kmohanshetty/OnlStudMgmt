package com.student.ams.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtility {


	private static Connection con = null;

	public static Connection getConnection(){
		if(con == null){
			URL url = JdbcUtility.class.getClassLoader().getResource("sql-db.properties");
			String filePath = url.getFile();
			File file = new File(filePath);
			InputStream is = null;
			Properties props = null;
			String driverUrl = "";
			String driverName = "";
			String user = "";
			String password = "";

			try{
				is = new FileInputStream(file);
				props = new Properties();
				props.load(is);
				driverUrl = props.getProperty("url");
				driverName = props.getProperty("driverName");
				user = props.getProperty("user");
				password = props.getProperty("password");

				Class.forName(driverName);
				
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				con = DriverManager.getConnection(driverUrl,user,password);
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return con;
	}

	public static void main(String[] args){
		getConnection();
	}
}
