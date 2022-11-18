package controller.classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassDAO;
/**
 * Servlet implementation class ClassDelete
 */
@WebServlet("/classDelete")
public class ClassDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //요청 캐릭터셋 설정.
		response.setContentType("text/html;charset=UTF-8"); // 응답 컨텐츠타입 설정.
		
		PrintWriter out = response.getWriter(); // out 정의.
		String ClassId = request.getParameter("classId"); // classId값을 받아온 classId값으로 넣기.
		String contextPath = request.getContextPath(); // 현재 서버 위치 가져오기.
		
		ClassDAO dao = new ClassDAO(); //dao 정의하기.
		int n = dao.deleteClass(ClassId); //n을 정의하고, dao의 deleteClass의 성공여부 저장.
		if(n<=0) { // 만약 실패했다면,
			out.println("<script>alert('클래스 삭제 실패');location.href='/classList'</script>"); // 클래스 삭제 실패 띄우고, classList로 이동.
		}else { //만약 성공했다면, 
			out.println("<script>alert('클래스 삭제 성공');location.href='/classList'</script>"); // 클래스 삭제 성공 띄우고, classList로 이동.
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
