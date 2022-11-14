package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassDAO;
import vo.ClassVO;

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
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		ClassDAO dao = new ClassDAO();
		ClassVO vo = new ClassVO();
		
		vo.setClassName(request.getParameter("className"));
		vo.setClassId(request.getParameter("classId"));
		if(request.getParameter("classPw") != null) {
			vo.setClassPw(request.getParameter("classPw"));
		}else {
			vo.setClassPw("");
		}
		
		int n = dao.insertClass(vo);
		if(n<=0) {
			out.println("<script>alert('클래스 삭제 실패');</script>");
		}
		response.sendRedirect(contextPath+"memberList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
