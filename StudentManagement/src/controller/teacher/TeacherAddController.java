package controller.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClassDAO;
import dao.TeacherDAO;
import dao.TeacherTagDAO;
import vo.ClassVO;
import vo.TeacherTagVO;
import vo.TeacherVO;

/**
 * Servlet implementation class TeacherAddController
 */
@WebServlet("/teacherAdd")
public class TeacherAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession(true);
		
		TeacherDAO dao = new TeacherDAO();
		TeacherVO vo = new TeacherVO();
		TeacherTagDAO ttd = new TeacherTagDAO();
		TeacherTagVO ttv = new TeacherTagVO();
		
		
		
		vo.setTeacherName(request.getParameter("teacherName"));
		vo.setTeacherId(request.getParameter("teacherId"));
		vo.setTeacherPwd(request.getParameter("teacherPw"));
		
		
		int n = dao.insertTeacher(vo);
		if(n<=0) {
			out.println("<script>alert('선생님 계정 생성 실패');location.href='/classList'</script>");
		}else {
			out.println("<script>alert('선생님 계정 생성 성공');location.href='/classList'</script>");
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
