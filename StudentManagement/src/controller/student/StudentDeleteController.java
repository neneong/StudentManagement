package controller.student;
// 학생을 제거하는 컨트롤러.
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import dao.TeacherDAO;
import vo.StudentVO;
import vo.TeacherVO;

/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/studentDelete")
public class StudentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		StudentVO vo = new StudentVO();
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String studentId = request.getParameter("userId");
		
		String contextPath = request.getContextPath();
		
		int n = dao.deleteStudent(studentId);
		
		if(n>0) {
			out.print("<script>alert('학생 삭제 완');</script>");
			response.sendRedirect(contextPath + "/studentList");
			
		}else {
            out.print("<script>alert('올바르지 않은 접근입니다.');</script>");
			response.sendRedirect(contextPath + "/studentList");
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
