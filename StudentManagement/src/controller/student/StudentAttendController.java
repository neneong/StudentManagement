package controller.student;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassDAO;
import dao.StudentDAO;
import dao.StudentTagDAO;
import dao.TeacherTagDAO;
import vo.ClassVO;
import vo.StudentTagVO;
import vo.StudentVO;
import vo.TeacherTagVO;
// 교실에 학생이 출석했는지에 관한 리스트를 보내주는 컨트롤러.
/**
 * Servlet implementation class studentAttendController
 */
@WebServlet("/studentAttend")
public class StudentAttendController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAttendController() {
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
		StudentDAO sd = new StudentDAO();
		
		ClassVO vo = new ClassVO();
		TeacherTagVO ttv = new TeacherTagVO();
		StudentTagVO stv = new StudentTagVO();
		ArrayList<StudentTagVO> array = new ArrayList<StudentTagVO>();
		
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
		
		String classId = request.getParameter("classId");
		array = std.selectClassById(classId);
		
		
		dao.selectClass(classId);
		String className = vo.getClassName();
		String classDate = vo.getDate();
		list = sd.selectMemberByList(array); 
		
		
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("classId", classId);
		request.setAttribute("className", className);
		request.setAttribute("classDate", classDate);
		request.setAttribute("studentList", list);
		
		
		
		response.setContentType("text/html;charset=UTF-8");
		
		request.getRequestDispatcher("/attend/addAttend.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
