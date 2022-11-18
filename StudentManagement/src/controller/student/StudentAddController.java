package controller.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import dao.TeacherDAO;
import vo.StudentVO;
import vo.TeacherVO;
// 학생 추가 컨트롤러.
/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/studentAdd")
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
		PrintWriter out = response.getWriter();
		StudentDAO dao = new StudentDAO(); // StudentDAO 선언하기.
		StudentVO vo = new StudentVO(); // StudentVO 선언하기.
		
		request.setCharacterEncoding("UTF-8"); //요청 캐릭터셋 설정.
		response.setContentType("text/html;charset=UTF-8"); // 응답 컨텐츠타입 설정.
		
		vo.setStudentName(request.getParameter("studentName")); //studentName에 studentName값 넣어주기.
		vo.setStudentBirth(request.getParameter("studentBirth")); // studentBirth에 studentBirth값 넣어주기.
		
		String contextPath = request.getContextPath(); // 서버 경오 가져오기.
		
		int n = dao.insertStudent(vo); //n을 선언하고, dao의 insertStudent의 결과값 넣기.
		
		if(n<=1) { //만약 둘중에 하나라도 실패하였다면, 
			out.println("<script>alert('학생 생성 실패');</script>"); //학생 생성 실패 메세지 보내기.
		}else {// 성공하였다면,
			out.println("<script>alert('학생 생성 성공');</script>"); //학생 생성 성공 메세지 보내기.
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
