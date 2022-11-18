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
		ClassDAO dao = new ClassDAO(); //ClassDAO 선언.
		StudentDAO sd = new StudentDAO();// StudentDAO 선언.
		AttendDAO ad = new AttendDAO(); // AttendDAO 선언.
		
		ClassVO cv = new ClassVO(); // ClassVO 선언.
		StudentVO sv = new StudentVO(); // StudentVO 선언.
		AttendVO vo = new AttendVO(); // AttendVO 선언.
		
		TeacherTagVO ttv = new TeacherTagVO(); //TeacherTagVO 선언.
		StudentTagVO stv = new StudentTagVO(); // StudentTagVO 선언.
		ArrayList<AttendVO> list = new ArrayList<AttendVO>(); //AttendVO 형식의 ArrayList list 를 선언.
		
		String classId = request.getParameter("classId"); //classId에 classId 보낸 값 받아오기.
		int userId = Integer.parseInt(request.getParameter("userId")); // userId 변수에 userId값 받아온것 int로 변환해서 넣기.
		
		list = ad.selectAttend(userId, classId); //list에 AttendDAO의 selectAttend의 결과값을 넣는다.
		sv = sd.selectStudent(userId); // sv에 StudentVO의 selectStudent의 결과값을 넣는다.
		dao.selectClass(classId); // ClassDAO의 selectClass를 classId를 넣어서 실행한다.
		
		
		request.setCharacterEncoding("UTF-8"); //요청 캐릭터셋 설정.
		response.setContentType("text/html;charset=UTF-8"); // 응답 컨텐츠타입 설정.
		
		
		request.setAttribute("classId", classId); //classId에 classId변수 값 넣기.
		request.setAttribute("className", cv.getClassName()); // className에 cv의 className값 넣기.
		request.setAttribute("classDate", cv.getDate()); // classDate에 cv의 Date값 넣기.
		request.setAttribute("attendList", list); //attendList에 list값 넣기.
		request.setAttribute("studentName", sv.getStudentName()); // studentName에 sv의 StudentName값 넣기.
		
		
		request.getRequestDispatcher("/attend/attendList.jsp").forward(request, response); //attendList로 넘기기.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
