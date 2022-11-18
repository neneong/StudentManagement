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
	
	//학생 태그를 가져오는 함수.
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
				int id = rs.getInt("userid");
				classes.setStudentId(id);
				studentList.add(classes);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return studentList;
	}
	
	//학생 태그를 추가하는 함수.
	public int insertClassTag(StudentTagVO vo) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into studentTag(userId, classId) values(?,?)";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getStudentId());
			pstmt.setString(2, vo.getClassId());
			n = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}

	//학생 태그를 삭제하는 함수.
	public int deleteClassTag(Integer userId, String classId) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from studentTag where userId=? AND classId=?";
		
		conn = JdbcUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
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
