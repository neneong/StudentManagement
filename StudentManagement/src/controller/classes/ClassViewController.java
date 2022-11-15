package controller.classes;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassDAO;
import dao.StudentTagDAO;
import dao.TeacherTagDAO;
import vo.ClassVO;
import vo.StudentTagVO;
import vo.TeacherTagVO;

/**
 * Servlet implementation class ClassViewController
 */
@WebServlet("/ClassView")
public class ClassViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassDAO dao = new ClassDAO();
		TeacherTagDAO ttd = new TeacherTagDAO();
		StudentTagDAO std = new StudentTagDAO();
		ClassVO vo = new ClassVO();
		TeacherTagVO ttv = new TeacherTagVO();
		StudentTagVO stv = new StudentTagVO();
		
		
		String classId = request.getParameter("classId");
		dao.selectClass(classId);
		String className = vo.getClassName();
		String classdate = vo.getDate();
		
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
