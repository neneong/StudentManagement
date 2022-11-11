package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.TeacherVO;

public class TeacherDAO {
	public ArrayList<TeacherVO> selectMember(){
		ArrayList<TeacherVO> memberList = new ArrayList <TeacherVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TeacherVO member = null;
		
		conn = JdbcUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement("select teacherid, teachername from teacher order by teacherid");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new TeacherVO();
				member.setTeacherId(rs.getString("userid"));
				member.setTeacherName(rs.getString("username"));
				memberList.add(member);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return memberList;
	}
	
	public int getTeacher(String id, String pw) {		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TeacherVO member = null;
		int n = 0;
		conn = JdbcUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement("select * from teacher where teacherid=? and teacherpwd=?");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new TeacherVO();
				member.setTeacherId(rs.getString("teacherid"));
				member.setTeacherPwd(rs.getString("teacherpwd"));
				member.setTeacherName(rs.getString("teachername"));
				n=1;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return n;
	}
	
	public int insertTeacher(TeacherVO vo) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into teacher values(?,?,?)";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTeacherId());
			pstmt.setString(2, vo.getTeacherPwd());
			pstmt.setString(3, vo.getTeacherName());
			n = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
	
	public int updateTeacher(TeacherVO vo) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update teacher set username=? where userid=?";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTeacherId());
			pstmt.setString(2, vo.getTeacherName());
			n = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
	
	public int deleteTeacher(String userId) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from teacher where userid=?";
		
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
