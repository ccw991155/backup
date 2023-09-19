package servletBase2.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input")
public class CourseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("user_id");
		String name = req.getParameter("user_name");
		System.out.println("아이디 : "+id+"\n비밀번호 : "+name);
		
		String[] sub = req.getParameterValues("subject");
		if(sub == null) {
			System.out.println("수강신청 과목이 없습니다.");
		} else {
			System.out.print("신청과목 : ");
			for(String s : sub) {
				System.out.print(s+" ");
			}
		}
	}

}
