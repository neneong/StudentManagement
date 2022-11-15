package controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TeacherDAO;
import vo.TeacherVO;

/**
 * Servlet implementation class userChangePassword
 */
@WebServlet("/changePassword")
public class userChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userChangePasswordController() {
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
		HttpSession session = request.getSession(true);
		String userId = session.getAttribute("id").toString();
		System.out.println(userId);
		String userPwd = request.getParameter("defaultPw");
		System.out.println(userPwd);
		TeacherDAO dao = new TeacherDAO();
		int n = dao.loginTeacher(userId, userPwd);
		System.out.println(n);
		if(n<=0) {
			out.println("<script>alert('비밀번호 변경에 실패하였습니다.\\n기존 비밀번호가 일치하지 않습니다.');history.back();</script>");
		}else {
			TeacherVO vo = new TeacherVO();
			String newPwd = request.getParameter("newPw").toString();
			System.out.println(newPwd);
			vo.setTeacherPwd(newPwd);
			vo.setTeacherId(userId);
			int k = dao.updateTeacherPwd(vo);
			System.out.println(k);
			if(k<=0) {
				out.print("<script>alert('비밀번호 변경에 실패하였습니다.');history.back();</script>");
			}else {
				out.print("<script>alert('비밀번호 변경에 성공하였습니다.');location.href='/classList';</script>");
			}
			
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
