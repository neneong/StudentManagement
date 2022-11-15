package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.ClassVO;
import vo.StudentTagVO;
import vo.StudentVO;

public class StudentTagDAO {	
	public ArrayList<StudentTagVO> selectClassById(String classId){
		ArrayList<StudentTagVO> studentList = new ArrayList <StudentTagVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentTagVO classes = null;
		
		conn = JdbcUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement("select userid from studentTag where classid=?");
			pstmt.setString(1, classId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				classes = new StudentTagVO();
				classes.setClassId(rs.getString("userid"));
				studentList.add(classes);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return studentList;
	}
	
	public int insertClassTag(StudentTagVO vo) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into studentTag(userId, classId) values(?,?)";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getStudentId());
			pstmt.setString(2, vo.getClassId());
			n = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
	
//	public int updateClass(StudentTagVO vo) {
//		int n = 0;
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		String sql = "update studentTag set classId=? where userId=?";
//		
//		conn = JdbcUtil.getConnection();
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, vo.getStudentId());
//			pstmt.setString(2, vo.getClassId());
//			n = pstmt.executeUpdate();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			JdbcUtil.close(conn, pstmt);
//		}
//		return n;
//	}
	
	public int deleteClass(String userId, String classId) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from studentTag where userId=? AND classId=?";
		
		conn = JdbcUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, classId);
			n = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
}
