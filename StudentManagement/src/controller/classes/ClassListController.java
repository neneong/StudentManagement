package controller.classes;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassDAO;
import dao.TeacherDAO;
import vo.ClassVO;
import vo.TeacherVO;

/**
 * Servlet implementation class ClassListController
 */
@WebServlet("/classList")
public class ClassListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClassDAO dao = new ClassDAO(); // ClassDAO 정의.
		ArrayList<ClassVO> classList = new ArrayList<>(); //ClassVO 형식의 ArrayList classList 를 선언.
		
		String year = ""; // year 변수 선언.
		year = request.getParameter("year"); // year 값을 받아와서 year 변수에 넣기.
		
		if(year != null) { // 만약 year 변수가 비어있지 않다면,
			classList = dao.selectClassByYear(year); // classList는 classDAO의 selectClassByYear함수를 year값을 넣어서 실행.
		}else { // 만약 비어있다면,
			classList = dao.selectClasses(); //classList는 ClassDAO의 selectClasses함수 실행.
		}
		
		request.setCharacterEncoding("UTF-8"); //요청 캐릭터셋 설정.
		response.setContentType("text/html;charset=UTF-8"); // 응답 컨텐츠타입 설정.
		request.setAttribute("classes", classList); //classes에 classList 변수값 넣기.
		request.setAttribute("year", year); // year에 year변수 값 넣기.
		request.getRequestDispatcher("/class/classList.jsp").forward(request, response); //classList로 넘기기.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
