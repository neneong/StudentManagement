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
	public ArrayList<AttendVO> selectAttendByList(ArrayList<StudentTagVO> array) {
		ArrayList<AttendVO> memberList = new ArrayList<AttendVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AttendVO member = null;

		conn = JdbcUtil.getConnection();

		try {
			for (StudentTagVO el : array) {
				pstmt = conn.prepareStatement("select userid, classid, TO_CHAR(dates, 'YYYY-MM-DD') dates from attend where userid=? AND classid=?");
				pstmt.setInt(1, el.getStudentId());
				pstmt.setString(2, el.getClassId());
				rs = pstmt.executeQuery();

				if (rs.next()) {
					member = new AttendVO();
					member.setStudentId(rs.getInt("userid"));
					member.setClassId(rs.getString("classid"));
					member.setDate(rs.getString("dates"));
					memberList.add(member);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}

		return memberList;
	}

	public ArrayList<AttendVO> selectAttend(int studentId, String classId) {
		ArrayList<AttendVO> memberList = new ArrayList<AttendVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AttendVO member = null;

		conn = JdbcUtil.getConnection();

		try {

			pstmt = conn.prepareStatement("select userid, classid, TO_CHAR(dates, 'YYYY-MM-DD') dates from attend where userid=? AND classid=?");
			pstmt.setInt(1, studentId);
			pstmt.setString(2, classId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				member = new AttendVO();
				member.setStudentId(rs.getInt("userid"));
				member.setClassId(rs.getString("classid"));
				member.setDate(rs.getString("dates"));
				memberList.add(member);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}

		return memberList;
	}

	public int insertAttend(AttendVO vo) {
		int n = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into attend values(?,?,(SELECT SYSDATE FROM DUAL))";

		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getStudentId());
			pstmt.setString(2, vo.getClassId());
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}

	public int deleteAttend(AttendVO vo) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from attend where userid=? AND classid=? AND TO_CHAR(dates, 'YYYY-MM-DD')=?";
		
		conn = JdbcUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getStudentId());
			System.out.println(vo.getClassId());
			System.out.println(vo.getDate());
			System.out.println(vo.getStudentId());
			pstmt.setString(2, vo.getClassId());
			pstmt.setString(3, vo.getDate());
			n = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
}
