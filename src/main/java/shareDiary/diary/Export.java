package shareDiary.diary;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Redirect;

import shareDiary.util.Util;

/**
 * Servlet implementation class Export
 */
@WebServlet("/Export")
public class Export extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Export() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//sql에서 파일로 내보냅니다.
		Connection con = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT dDate, dTitle, dFeel, dWeather, dContent FROM diary WHERE id= ?  INTO OUTFILE ? fields terminated by '\n';";
		HttpSession session = request.getSession();
		String  id = (String) session.getAttribute("id");

		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			id = id+".txt";
			String outroute = "/home/tesius/export/"+id;
			pstmt.setString(2, outroute);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.closeAll(rs, pstmt, con);
			System.out.println(rs);
		}
		
		
		
		
		
		
		//내보낸 파일을 서버로 복사합니다.
		File sourceFile = new File("/home/tesius/export/"+id);
		File newFie = new File("var/lib/tomcat9/shareDiary/export/" + id +".txt");
		
		Files.copy(sourceFile.toPath(), newFie.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
		
		
		
		//복사한 파일의 링크를 생성합니다. 
		String exportTarget = "./export/"+id ;

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String data = "<html>";
		data += "<body>";
		data+= "\r\n"
				+ "<div id=\"banner\"><c:import url=\"banner.jsp\"/></div>\r\n"
				+ "\r\n"
				+ "<div id=\"article\">\r\n"
				+ "\r\n"
				+ "<div id=\"menu\"><c:import url=\"menu.jsp\"/></div>\r\n"
				+ "<div id = \"cotentbox\">";
		data += "<a href= '" + exportTarget	+"' download>일기장 보관하기</a>";
		data += "<a href='1.239.16.47:8080/shareDiary/diaryView'>목록으로 돌아가기</a> </div></div>";
		data += "</body>";
		data += "</html>";
		out.print(data);
		
		
		
	}

}
