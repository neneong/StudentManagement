package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.StudentVO;
import vo.TeacherVO;

public class StudentDAO {
	public ArrayList<StudentVO> selectMember(){
		ArrayList<StudentVO> memberList = new ArrayList <StudentVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentVO member = null;
		
		conn = JdbcUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement("select studentid, studentname, birth from student order by studentid");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new StudentVO();
				member.setStudentId(rs.getString("studentid"));
				member.setStudentName(rs.getString("studentname"));
				member.setStudentBirth(rs.getString("birth"));
				memberList.add(member);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return memberList;
	}
	
	public int getStudent(String id, String pw) {		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentVO member = null;
		int n = 0;
		conn = JdbcUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement("select * from student where studentid=?");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new StudentVO();
				member.setStudentId(rs.getString("studentid"));
				member.setStudentName(rs.getString("studentname"));
				member.setStudentBirth(rs.getString("birth"));
				n=1;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return n;
	}
	
	public int insertStudent(StudentVO vo) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into student values(?,?,?)";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getStudentId());
			pstmt.setString(2, vo.getStudentName());
			pstmt.setString(3, vo.getStudentBirth());
			n = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
	
	public int updateStudent(StudentVO vo) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update student set studentname=? where studentid=?";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getStudentName());
			pstmt.setString(2, vo.getStudentId());
			n = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
	
	public int deleteStudent(String userId) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from student where studentid=?";
		
		conn = JdbcUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			n = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
}
