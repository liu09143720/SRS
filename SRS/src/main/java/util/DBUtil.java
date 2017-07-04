package util;

import java.sql.*;

import sqliteDAOImpl.TranscriptDAOImpl;


public class DBUtil {
	
	public static Connection getSqliteConnection(){
		String driver="org.sqlite.JDBC";
		String conStr="jdbc:sqlite:D:/SRSData.db";
		Connection conn=null;
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(conStr);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;			
	}
	
	public static void closeConnection(){
		SQLException ex=null;
		if(TranscriptDAOImpl.conn2!=null){
			try{
				TranscriptDAOImpl.conn2.close();
			}catch(SQLException e){
				if(ex==null){
					ex=e;
				}
			}
		}
	}
	
}
