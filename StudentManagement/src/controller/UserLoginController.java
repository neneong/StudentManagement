package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dao.TeacherDAO;

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet("/userLogin")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginController() {
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
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession(true);
		TeacherDAO dao = new TeacherDAO();
		int n = dao.getTeacher(userId, userPwd);
		if(n<=0) {
			out.println("<script>alert('로그인에 실패했습니다.');history.back();</script>");
		}else {
			session.setAttribute("id", "userId");
			response.sendRedirect("/classList");
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
