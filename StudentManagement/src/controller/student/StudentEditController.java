package controller.student;
// 학생 정보 수정하는 컨트롤러.
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import vo.StudentVO;

/**
 * Servlet implementation class studentEditServlet
 */
@WebServlet("/studentEdit")
public class StudentEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentEditController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		StudentDAO dao = new StudentDAO();
		StudentVO vo = new StudentVO();

		Integer userId = Integer.parseInt(request.getParameter("studentId"));
		String studentBirth = request.getParameter("studentBirth");
		String studentName = request.getParameter("studentName");
		
		vo.setStudentBirth(studentBirth);
		vo.setStudentId(userId);
		vo.setStudentName(studentName);
		
		
		
		int n = dao.updateStudent(vo);
		if(n<=0) {
			System.out.println("입력 실패");
			out.print("<script>alert('학생 인적사항 업데이트 실패');history.back();</script>");
		}else {
			System.out.println("입력 성공");
			out.print("<script>alert('학생 인적사항 업데이트 성공');location.href='/classList';</script>");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
