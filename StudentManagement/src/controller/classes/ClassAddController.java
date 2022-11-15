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
 * Servlet implementation class ClassAddController
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
		
		ClassDAO dao = new ClassDAO();
		ClassVO vo = new ClassVO();
		TeacherTagDAO ttd = new TeacherTagDAO();
		TeacherTagVO ttv = new TeacherTagVO();
		
		
		
		vo.setClassName(request.getParameter("className"));
		vo.setClassId(request.getParameter("classId"));
		String teacherId = session.getAttribute("id").toString();
		if(request.getParameter("classPw") != null) {
			vo.setClassPw(request.getParameter("classPw"));
		}else {
			vo.setClassPw("");
		}
		
		ttv.setClassId(teacherId);
		ttv.setTeacherId(teacherId);
		
		int n = dao.insertClass(vo);
		n+= ttd.insertClassTag(ttv);
		if(n<=0) {
			out.println("<script>alert('클래스 생성 실패');</script>");
		}else {
			out.println("<script>alert('클래스 생성 성공');</script>");
		}
		response.sendRedirect(contextPath+"classList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
