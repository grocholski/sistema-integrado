package dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BDUtil {
	
	public static final String URL = "jdbc:mysql://localhost:3306/integrados3";
	public static final String USR = "utfpr";
	public static final String PSW = "utfpr";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = 	DriverManager.getConnection(URL, USR, PSW);
		} catch (SQLException e) {
			throw new RuntimeException("erro: getconnection");
		}
		return conn;
	}
	
	public static ResultSet executeSQL(Connection conn, String sql, List<Object> params) {
		ResultSet rs = null;
		try {
		
			PreparedStatement stmt = conn.prepareStatement(sql);	
			int i = 1;
			for (Object object : params) {
	      stmt.setObject(i, object);
	      i++;
      }
			rs = stmt.executeQuery();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException("erro executesql");
		} finally {
			closeConnection(conn);
		}
		
		return rs;
	}
	
	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException("erro: closeconnection");
		}
	}

}
