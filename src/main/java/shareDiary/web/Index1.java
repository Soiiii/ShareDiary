package shareDiary.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shareDiary.dao.LogDAO;
import shareDiary.diary.DiaryDAO;
import shareDiary.util.Util;


@WebServlet("/index1")
public class Index1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1;  //기본 페이지 1페이지로 설정
		
		ArrayList<HashMap<String, Object>> openDiaryList = null;
		try {
			openDiaryList = DiaryDAO.getInstance().openDiaryList(page-1, 3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		//log남기기
		HashMap<String, Object> log = new HashMap<String, Object>();
		log.put("ip", Util.getIP(request));
		log.put("id", request.getParameter("id"));
		log.put("target", "index");
		log.put("etc", request.getHeader("user-agent"));
		LogDAO.getInstance().insertLog(log);
		

		RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
		request.setAttribute("openDiaryList", openDiaryList);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
