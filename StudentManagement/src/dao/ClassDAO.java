package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.ClassVO;

public class ClassDAO {
	public ArrayList<ClassVO> selectClass(){
		ArrayList<ClassVO> classList = new ArrayList <ClassVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ClassVO classes = null;
		
		conn = JdbcUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement("select classid, classname, classinfo, dates from class order by classid");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				classes = new ClassVO();
				classes.setClassId(rs.getString("classid"));
				classes.setClassName(rs.getString("classname"));
				classes.setClassInfo(rs.getString("classinfo"));
				classes.setClassInfo(rs.getString("dates"));
				classList.add(classes);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return classList;
	}
	
	public ArrayList<ClassVO> selectClassByYear(String year){
		ArrayList<ClassVO> classList = new ArrayList <ClassVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ClassVO classes = null;
		
		conn = JdbcUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement("select classid, classname, classinfo, dates from class where dates LIKE '?%' order by classid");
			pstmt.setString(1, year);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				classes = new ClassVO();
				classes.setClassId(rs.getString("classid"));
				classes.setClassName(rs.getString("classname"));
				classes.setClassInfo(rs.getString("classinfo"));
				classes.setClassInfo(rs.getString("dates"));
				classList.add(classes);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return classList;
	}
	
	public int insertClass(ClassVO vo) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into class(classId, className, classInfo, studentId) values(?,?,?,?)";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getClassId());
			pstmt.setString(2, vo.getClassName());
			pstmt.setString(3, vo.getClassInfo());
			pstmt.setString(4, vo.getDate());
			n = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
	
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