package servletBase2.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/rate")
public class RateCalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static float USD_RATE = 1326.40f;
	private static float JPY_RATE = 8.98f;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command");
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");
		
		if(command != null && command.equals("calculate") ) {
			String result = cal(Float.parseFloat(won), operator);
	
			String data = "<html><head><title>환율계산기</title></head>";
			data += "<body><h2>"+operator+" 변환결과</h2>";
			data += "<h3>"+ result +"</h3>";
			data += "<a href='./rate'>환율계산기</a>";
			data += "</body></html>";
			out.print(data);
			
		} else {
			String data = "<html><head><title>환율계산기</title></head>";
			data += "<body><h2>환율계산기</h2>";
			data += "<form action='/servletBase2/rate' method='get'>";
			data += "원화 : <input type='text' name='won'>";
			data += "<select name='operator'>";
			data += "<option value='dollar'>달러</option>";
			data += "<option value='yen'>엔화</option>";
			data += "</select>";
			data += "<input type='hidden' name='command' value='calculate'>";
			data += "<input type='submit' value='변환'>";
			data += "</form></body></html>";
			out.print(data);
		}
	}
	
	private static String cal(float won, String operator) {
		String result = null;
		if(operator.equals("dollar")) {
			result = String.format("%.2f", won/USD_RATE)+" 달러";
		} else if (operator.equals("yen")) {
			result = String.format("%.2f", won/JPY_RATE)+" 엔";
		}
		return result;
	}

}
