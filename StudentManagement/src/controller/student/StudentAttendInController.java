package controller.student;
// 학생의 출석체크를 하는 컨트롤러.
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttendDAO;
import vo.AttendVO;

/**
 * Servlet implementation class studentAttendInController
 */
@WebServlet("/studentAttendIn")
public class StudentAttendInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAttendInController() {
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
		String[] attendStudents = request.getParameterValues("attend");
		AttendVO vo = new AttendVO();
		AttendDAO dao = new AttendDAO();
		String classId = request.getParameter("classId");
		for(int i = 0; i<=attendStudents.length-1; i++) {
			vo.setStudentId(Integer.parseInt(attendStudents[i]));
			vo.setClassId(classId);
			int n = dao.insertAttend(vo);
			if(n<=0) {
				System.out.println("입력 실패");
				out.print("<script>alert('출석체크 실패');history.back();</script>");
			}else {
				System.out.println("입력 성공");
				out.print("<script>alert('출석체크 성공');location.href='/classView?classId="+classId+"';</script>");
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
