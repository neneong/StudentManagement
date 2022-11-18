package controller.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttendDAO;
import dao.StudentDAO;
import dao.StudentTagDAO;
import vo.AttendVO;
import vo.StudentTagVO;
import vo.StudentVO;
// 학생을 교실에 추가하는 컨트롤러.
/**
 * Servlet implementation class StudentAddOnClassController
 */
@WebServlet("/studentAddOnClass")
public class StudentAddOnClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAddOnClassController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 클래스에 학생을 등록하는 코
		String[] attendStudents = request.getParameterValues("attend");
		StudentTagVO vo = new StudentTagVO();
		StudentTagDAO dao = new StudentTagDAO();
		String classId = request.getParameter("classId");
		for(int i = 0; i<=attendStudents.length-1; i++) {
			vo.setStudentId(Integer.parseInt(attendStudents[i]));
			vo.setClassId(classId);
			int n = dao.insertClassTag(vo);
			if(n<=0) {
				System.out.println("입력 실패");
				out.print("<script>alert('학생 등록 실패');history.back();</script>");
			}else {
				System.out.println("입력 성공");
				out.print("<script>alert('학생 등록 성공');location.href='/classView?classId="+classId+"';</script>");
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
