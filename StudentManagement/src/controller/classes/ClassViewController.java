package controller.classes;

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

/**
 * 클래스 목록 classView.jsp로 넘겨주기. 
 */
@WebServlet("/classView")
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
		ClassDAO dao = new ClassDAO(); //classDAO 선언.
		TeacherTagDAO ttd = new TeacherTagDAO(); //TeacherTagDAO 선언.
		StudentTagDAO std = new StudentTagDAO(); // StudentTagDAO 선언.
		StudentDAO sd = new StudentDAO(); // StudentDAO 선언.
		
		ClassVO vo = new ClassVO(); // ClassVO 선언.
		TeacherTagVO ttv = new TeacherTagVO(); // TeacherTagVO 선언.
		StudentTagVO stv = new StudentTagVO(); // StduentTagVO 선언.
		ArrayList<StudentTagVO> array = new ArrayList<StudentTagVO>(); //StudentTagVO 형식의 ArrayList array 를 선언.
		
		ArrayList<StudentVO> list = new ArrayList<StudentVO>(); //StudentVO 형식의 ArrayList list 를 선언.
		
		String classId = request.getParameter("classId"); // classId 변수값을 선언하고, classId값을 받아와서 넣기.
		array = std.selectClassById(classId); //array에 std의 selectclassbyid의 결과값 넣기.
		
		
		dao.selectClass(classId); // selectClass 실행하기.
		String className = vo.getClassName(); // className 변수에 vo의 className 값 가져와서 넣기.
		String classDate = vo.getDate(); // classDate 변수에 vo의 Date값 가져와서 넣기.
		list = sd.selectMemberByList(array); //list에 sd의 selectMemberByList결과값 가져와서 넣기.
		
		
		request.setCharacterEncoding("UTF-8"); //요청 캐릭터셋 설정.
		response.setContentType("text/html;charset=UTF-8"); // 응답 컨텐츠타입 설정.
		
		request.setAttribute("classId", classId); // classId에 classId변수값 넣기.
		request.setAttribute("className", className); // className에 className 변수값 넣기.
		request.setAttribute("classDate", classDate); // classDate에 classDate 변수값 넣기.
		request.setAttribute("studentList", list); // studentList에 list 변수값 넣기.
		
		
		
		
		request.getRequestDispatcher("/class/classView.jsp").forward(request, response); //classView.jsp로 이동시키기.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
