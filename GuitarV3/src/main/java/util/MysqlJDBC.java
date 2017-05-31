package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlJDBC {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/guitar?characterEncoding=utf-8&useSSL=true";
	private static final String DBNAME="root";
	private static final String DBPASS="123456";
	/**获取连接对象*/
	public static Connection getConnection(){
		Connection con = null;
		try{
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,DBNAME,DBPASS);
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	/**关闭连接**/
	public static void closeConnection(Connection con){
		try{
			if(con==null){
				con.close();
			}
		}
		catch(SQLException sqlEx){
			sqlEx.printStackTrace();
		}
	}
	/**关闭记录集**/
	public static void closeResultSet(ResultSet rs){
		try{
			if(rs==null){
				rs.close();
			}
		}
		catch(SQLException sqlEx){
			sqlEx.printStackTrace();
		}
	}
	/**关闭语句**/
	public static void closeStatement(PreparedStatement pst){
		try{
			if(pst==null){
				pst.close();
			}
		}
		catch(SQLException sqlEx){
			sqlEx.printStackTrace();
		}
	}
}

