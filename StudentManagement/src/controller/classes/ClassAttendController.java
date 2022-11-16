package controller.classes;

import java.io.IOException;
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
 * Servlet implementation class classAttend
 */
@WebServlet("/classAttend")
public class ClassAttendController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassAttendController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassDAO dao = new ClassDAO();
		StudentDAO sd = new StudentDAO();
		AttendDAO ad = new AttendDAO();
		
		ClassVO cv = new ClassVO();
		StudentVO sv = new StudentVO();
		AttendVO vo = new AttendVO();
		
		TeacherTagVO ttv = new TeacherTagVO();
		StudentTagVO stv = new StudentTagVO();
		ArrayList<AttendVO> list = new ArrayList<AttendVO>();
		
		String classId = request.getParameter("classId");
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		list = ad.selectAttend(userId, classId); 
		sv = sd.selectStudent(userId);
		dao.selectClass(classId);
		
		
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("classId", classId);
		request.setAttribute("className", cv.getClassName());
		request.setAttribute("classDate", cv.getDate());
		request.setAttribute("attendList", list);
		request.setAttribute("studentName", sv.getStudentName());
		
		
		response.setContentType("text/html;charset=UTF-8");
		
		request.getRequestDispatcher("/attendList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
