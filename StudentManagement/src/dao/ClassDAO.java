package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.ClassVO;

public class ClassDAO {
	// 클래스 정보 가져오는 함수.
	public void selectClass(String classid){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ClassVO classes = new ClassVO();
		
		conn = JdbcUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement("select classname, TO_CHAR(dates, 'YYYY-MM-DD') dates from class where classid=?");
			pstmt.setString(1, classid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				classes.setClassName(rs.getString("classname"));
				classes.setDate(rs.getString("dates"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return;
	}
	
	//클래스들을 리스트로 가져오는 함수.
	public ArrayList<ClassVO> selectClasses(){
		ArrayList<ClassVO> classList = new ArrayList <ClassVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ClassVO classes = null;
		
		conn = JdbcUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement("select classid, classname, TO_CHAR(dates, 'YYYY-MM-DD') dates from class order by classid");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				classes = new ClassVO();
				classes.setClassId(rs.getString("classid"));
				classes.setClassName(rs.getString("classname"));
				classes.setDate(rs.getString("dates"));
				classList.add(classes);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return classList;
	}
	
	//클래스를 연도별로 리스트로 가져오는 함수.
	public ArrayList<ClassVO> selectClassByYear(String year){
		ArrayList<ClassVO> classList = new ArrayList <ClassVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ClassVO classes = null;
		
		conn = JdbcUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement("select classid, classname, TO_CHAR(dates, 'YYYY-MM-DD') dates from class where TO_CHAR(dates, 'YYYY-MM-DD') LIKE ? order by classid");
			pstmt.setString(1, year + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				classes = new ClassVO();
				classes.setClassId(rs.getString("classid"));
				classes.setClassName(rs.getString("classname"));
				classes.setDate(rs.getString("dates"));
				classList.add(classes);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return classList;
	}
	
	//클래스를 추가하는 함수.
	public int insertClass(ClassVO vo) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into class(classId, classPw, className, dates) values(?,?,?,(SELECT SYSDATE FROM DUAL))";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getClassId());
			pstmt.setString(2, vo.getClassPw());
			pstmt.setString(3, vo.getClassName());
			n = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
	
	//클래스 정보를 업데이트 하는 함수.
	public int updateClass(ClassVO vo) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update class set className=? where classId=?";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getClassId());
			pstmt.setString(2, vo.getClassName());
			n = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
	
	//클래스를 제거하는 함수.
	public int deleteClass(String classId) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from class where classId=?";
		
		conn = JdbcUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, classId);
			n = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
}
