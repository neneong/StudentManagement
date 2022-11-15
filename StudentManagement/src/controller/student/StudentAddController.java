package controller.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeacherDAO;
import vo.TeacherVO;

/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/memberInsert")
public class StudentAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherDAO dao = new TeacherDAO();
		TeacherVO vo = new TeacherVO();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		vo.setTeacherId(request.getParameter("userId"));
		vo.setTeacherName(request.getParameter("userName"));
		
		String contextPath = request.getContextPath();
		
		int n = dao.insertTeacher(vo);
		
		if(n>0) {
			response.sendRedirect(contextPath + "/memberList");
			
		}else {
			response.sendRedirect(contextPath + "memberInsert.jsp");
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