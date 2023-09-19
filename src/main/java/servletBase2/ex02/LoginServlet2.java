package servletBase2.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 서버에서 웹 브라우저로 데이터를 전송(응답)할 때는 어떤 종류로 전송했는지 웹 브라우저에 알려줘야 처리 속도가 빠름
		PrintWriter out = response.getWriter();
		String id = request.getParameter("user_id");
		String pwd = request.getParameter("user_pwd");
		String data = "<html>";
		data += "<body>";
		data += "<h2>"+id+"님 환영합니다</h2>";
		data += "</body>";
		data += "</html>";
		out.print(data);
	}

}

