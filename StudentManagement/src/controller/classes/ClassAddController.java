package controller.classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClassDAO;
import dao.TeacherTagDAO;
import vo.ClassVO;
import vo.TeacherTagVO;

/**
 * ClassAddController
 * 클래스 생성 역할을 한다.
 */
@WebServlet("/classAdd")
public class ClassAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession(true);
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		ClassDAO dao = new ClassDAO(); // dao 선언.
		ClassVO vo = new ClassVO(); // vo 선언.
		TeacherTagDAO ttd = new TeacherTagDAO(); //ttd 선언.
		TeacherTagVO ttv = new TeacherTagVO(); //ttv 선언.
		
		String classId = request.getParameter("classId");
		String className = request.getParameter("className");
		
		vo.setClassName(className); //className을 className값 받아와서 저장.
		vo.setClassId(classId); //classId을 classId값 받아와서 저장.
		String teacherId = session.getAttribute("id").toString(); //teacherId에 id값을 받아와서 저장.
		
		if(request.getParameter("classPw") != null) { //classPw값이 비어있지않다면,
			vo.setClassPw(request.getParameter("classPw")); //vo에 classPw를 classPw값을 받아와서 저장.
		}else { // 아니라면,
			vo.setClassPw(""); // vo에 classPw에 값을 넣지 않기.
		}
		
		ttv.setClassId(classId); // ttv의 classId에 classId변수값 대입.
		ttv.setTeacherId(teacherId); // ttv의 teacherId에 teacherId 변수값 대입.
		
		int n = dao.insertClass(vo);//클래스를 추가하고, 성공여부를 n이라는 변수로 받아오기.
		n+= ttd.insertClassTag(ttv); // n이라는 변수에 클래스태그 추가 여부를 추가하기.
		if(n<=1) { //만약 둘중에 하나라도 실패하였다면, 
			out.println("<script>alert('클래스 생성 실패');</script>"); //클래스 생성 실패 메세지 보내기.
		}else {// 성공하였다면,
			out.println("<script>alert('클래스 생성 성공');</script>"); //클래스 생성 성공 메세지 보내기.
		}
		response.sendRedirect(contextPath+"classList"); //classList로 리다이렉트하기.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
