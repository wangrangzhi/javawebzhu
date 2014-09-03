package edu.freshen.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 与数据连接
 * @author Administrator
 *
 */
public class DaoHelper {
	private static Connection conn;
	
	//获取与数据库的连接
	public static Connection getConn(){
		if(conn!=null)return conn;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/musicdb?user=root&password=146641");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
	}
	public static void close(Statement stm ,PreparedStatement pstm,ResultSet rs){
		try {
			if(rs!=null)rs.close();
			if(pstm!=null)pstm.close();
			if(stm!=null)stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
