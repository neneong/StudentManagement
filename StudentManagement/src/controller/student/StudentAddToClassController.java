package controller.student;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import vo.StudentVO;
// 학생을 교실에 추가하기 위한 리스트를 보내주는 컨트롤러.
/**
 * Servlet implementation class StudentAddToClassController
 */
@WebServlet("/studentAddToClass")
public class StudentAddToClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAddToClassController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classId = request.getParameter("classId");
		StudentDAO dao = new StudentDAO();
		ArrayList<StudentVO> memberList = dao.selectMember();
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		request.setAttribute("studentList", memberList);
		request.setAttribute("classId", classId);
		response.setContentType("text/html;charset=UTF-8");
		
		request.getRequestDispatcher("/student/studentAddToClass.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
