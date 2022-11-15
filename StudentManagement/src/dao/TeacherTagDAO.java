package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.StudentTagVO;
import vo.TeacherTagVO;

public class TeacherTagDAO {
	public String selectClassById(String classId){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String teacher="";
		
		conn = JdbcUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement("select userid from teacherTag where classid=?");
			pstmt.setString(1, classId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				teacher = rs.getString("userid");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return teacher;
	}
	
	public int insertClassTag(TeacherTagVO vo) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into teacherTag(userId, classId) values(?,?)";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTeacherId());
			pstmt.setString(2, vo.getClassId());
			n = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
	
//	public int updateClass(TeacherTagVO vo) {
//		int n = 0;
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		String sql = "update teacherTag set classId=? where userId=?";
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
		String sql = "delete from teacherTag where userId=? AND classId=?";
		
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
