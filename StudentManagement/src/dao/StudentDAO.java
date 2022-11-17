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
import vo.TeacherVO;

public class StudentDAO {
	public StudentVO selectStudent(int studentId){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentVO students = new StudentVO();
		
		conn = JdbcUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement("select * from student where studentid=?");
			pstmt.setInt(1, studentId);
			System.out.println(studentId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String studentName = rs.getString("studentName");
				String studentBirth = rs.getString("birth");
				System.out.println(studentName);
				students.setStudentId(studentId);
				students.setStudentName(studentName);
				students.setStudentBirth(studentBirth);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return students;
	}
	
	public ArrayList<StudentVO> selectMemberByList(ArrayList<StudentTagVO> array){
		ArrayList<StudentVO> memberList = new ArrayList <StudentVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentVO member = null;
		
		conn = JdbcUtil.getConnection();
		
		try {
			for(StudentTagVO el:array) {
				pstmt = conn.prepareStatement("select * from student where studentid=?");
				pstmt.setInt(1, el.getStudentId());
				System.out.println(el.getStudentId());
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					member = new StudentVO();
					member.setStudentId(rs.getInt("studentid"));
					member.setStudentName(rs.getString("studentname"));
					member.setStudentBirth(rs.getString("birth"));
					memberList.add(member);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return memberList;
	}
	
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
				member.setStudentId(rs.getInt("studentid"));
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
				member.setStudentId(rs.getInt("studentid"));
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
		String sql = "insert into student values(student_seq.nextval,?,?)";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getStudentName());
			pstmt.setString(2, vo.getStudentBirth());
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
		String sql = "update student set studentname=?, birth=? where studentid=?";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getStudentName());
			pstmt.setString(2, vo.getStudentBirth());
			pstmt.setInt(3, vo.getStudentId());
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
