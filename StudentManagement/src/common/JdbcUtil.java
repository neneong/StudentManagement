package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * JDBCUtil, DB에 연결하는 역할을 맡는다.
 * 
 * */


public class JdbcUtil {
	public static Connection getConnection() {
		// DB 연결 가져오기
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@pukkuk.pp.ua:1521:xe", "system", "jeongsumin0701");
		}catch(Exception e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		//DB 연결 닫기,Connection과 PreparedStatement만 닫는다.
		if(pstmt!=null) {
			try {
				pstmt.close(); 
			}catch(SQLException e) {
				System.out.println("pstmt.close() 실패");
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
				
			}catch(SQLException e) {
				System.out.println("conn.close() 실패");
				e.printStackTrace();
			}
		}
		
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		// DB 연결 닫기, ResultSet까지 닫는다.
		if(rs!= null) {
			try {
				rs.close();
			}catch(SQLException e) {
				System.out.println("rs.close() 실패");
				e.printStackTrace();
			}
		}
		close(conn, pstmt);
	}
}
