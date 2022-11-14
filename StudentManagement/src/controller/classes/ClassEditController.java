package controller.classes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassDAO;
import dao.TeacherDAO;
import vo.ClassVO;
import vo.TeacherVO;

/**
 * Servlet implementation class ClassEditController
 */
@WebServlet("/classEdit")
public class ClassEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassDAO dao = new ClassDAO();
		ClassVO vo = new ClassVO();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		vo.setClassId(request.getParameter("classId"));
		vo.setClassName(request.getParameter("className"));
		
		String contextPath = request.getContextPath();
		
		int n = dao.insertClass(vo);
		
		if(n>0) {
			response.sendRedirect(contextPath + "/memberList");
			
		}else {
			response.sendRedirect(contextPath + "memberInsert.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
