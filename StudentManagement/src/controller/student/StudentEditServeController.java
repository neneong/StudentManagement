package controller.student;
// 학생의 정보 수정을 하기 위한 정보를 보내주는 컨트롤러.
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import vo.StudentVO;

/**
 * Servlet implementation class StudentEditServeController
 */
@WebServlet("/StudentEditServe")
public class StudentEditServeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentEditServeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentDAO dao = new StudentDAO();
		StudentVO vo = new StudentVO();
		
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		vo = dao.selectStudent(userId);
		
		
		request.setAttribute("student", vo);
		request.getRequestDispatcher("/student/studentEdit.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
