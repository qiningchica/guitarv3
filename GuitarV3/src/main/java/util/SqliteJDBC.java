package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqliteJDBC {
	public static Connection getConnection(){
	    try {
	    	Class.forName("org.sqlite.JDBC");
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:guitar2.db");        
	        return conn;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null; 
    }
}
