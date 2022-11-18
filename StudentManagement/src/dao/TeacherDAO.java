package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.TeacherVO;

public class TeacherDAO {
	//선생님을 리스트 형태로 반환하는 함수.
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
	
	//선생님 로그인하는 함수.
	public int loginTeacher(String id, String pw) {		
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
	
	//선생님 정보 가져오는 함수.
	public int getTeacher(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int n = 0;
		conn = JdbcUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement("select * from teacher where teacherid=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();	
			if(rs.next()) {
				n=1;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return n;
	}

	//선생님 정보를 삽입하는 함수.
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
	
	// 선생님 정보 업데이트하는 함수.
	public int updateTeacher(TeacherVO vo) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update teacher set teachername=? where teacherid=?";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTeacherName());
			pstmt.setString(2, vo.getTeacherId());
			n = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
	
	//선생님 비밀번호 업데이트하는 함수.
	public int updateTeacherPwd(TeacherVO vo) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update teacher set teacherpwd=? where teacherid=?";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTeacherPwd());
			pstmt.setString(2, vo.getTeacherId());
			n = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
	
	//선생님 삭제하는 함수.
	public int deleteTeacher(String userId) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from teacher where teacherid=?";
		
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
