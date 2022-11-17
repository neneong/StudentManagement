package controller.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttendDAO;
import dao.ClassDAO;
import dao.StudentDAO;
import dao.StudentTagDAO;
import dao.TeacherTagDAO;
import vo.AttendVO;
import vo.ClassVO;
import vo.StudentTagVO;
import vo.StudentVO;
import vo.TeacherTagVO;

/**
 * Servlet implementation class StudentAttendEditController
 */
@WebServlet("/studentAttendDelete")
public class StudentAttendDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAttendDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		AttendDAO dao = new AttendDAO();
		AttendVO vo = new AttendVO();
		
		String classId = request.getParameter("classId");
		String date = request.getParameter("classDate");
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		
		vo.setClassId(classId);
		vo.setDate(date);
		vo.setStudentId(studentId);
		
		
		
		int n = dao.deleteAttend(vo);
		
		if(n<=0) {
			System.out.println("입력 실패");
			out.print("<script>alert('학생 출석 취소 실패');history.back();</script>");
		}else {
			System.out.println("입력 성공");
			out.print("<script>alert('학생 출석 취소 성공');location.href='/classView?classId="+classId+"';</script>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
