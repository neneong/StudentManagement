package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.AttendVO;
import vo.ClassVO;
import vo.StudentTagVO;
import vo.StudentVO;

public class AttendDAO {
	public ArrayList<AttendVO> selectAttendByList(ArrayList<StudentTagVO> array){
		ArrayList<AttendVO> memberList = new ArrayList <AttendVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AttendVO member = null;
		
		conn = JdbcUtil.getConnection();
		
		try {
			for(StudentTagVO el:array) {
				pstmt = conn.prepareStatement("select * from attend where studentid=?");
				pstmt.setInt(1, el.getStudentId());
				System.out.println(el.getStudentId());
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					member = new AttendVO();
					member.setStudentId(rs.getInt("studentid"));
					member.setClassId(rs.getString("classid"));
					member.setDate(rs.getString("dates"));
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
	
	public ArrayList<StudentVO> selectAttend(){
		ArrayList<StudentVO> memberList = new ArrayList <StudentVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentVO member = null;
		
		conn = JdbcUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement("select * from attend order by studentid");
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
	
	public int getAttend(String id, String pw) {		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentVO member = null;
		int n = 0;
		conn = JdbcUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement("select * from attend where studentid=?");
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
	
	public int insertAttend(StudentVO vo) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into attend values(student_seq.nextval,?,?)";
		
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
	
//	public int updateAttend(StudentVO vo) {
//		int n = 0;
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		String sql = "update attend set studentname=? where studentid=?";
//		
//		conn = JdbcUtil.getConnection();
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, vo.getStudentName());
//			pstmt.setInt(2, vo.getStudentId());
//			n = pstmt.executeUpdate();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			JdbcUtil.close(conn, pstmt);
//		}
//		return n;
//	}
//	
//	public int deleteAttend(String userId) {
//		int n = 0;
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		String sql = "delete from attend where studentid=?";
//		
//		conn = JdbcUtil.getConnection();
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, userId);
//			n = pstmt.executeUpdate();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			JdbcUtil.close(conn, pstmt);
//		}
//		return n;
//	}
}
