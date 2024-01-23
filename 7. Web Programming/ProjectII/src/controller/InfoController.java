package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chartCommand.SeoulArrestChart;
import chartCommand.SeoulCrimelChart;
import infoCommand.GuGrade;

/**
 * Servlet implementation class InfoController
 */
@WebServlet("/info/*")
public class InfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			actionDo(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			actionDo(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void actionDo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		System.out.println("info컨트롤러 actionDo 실행*************");
		String uri = request.getRequestURI();
		System.out.println("uri: " + uri);
		String conPath = request.getContextPath();
		System.out.println("contextPath: " + conPath);
		String servPath = request.getServletPath();
		System.out.println("servletPath: " + servPath);
		String com = uri.substring(servPath.length() + conPath.length());
		System.out.println("com: " + com);
 
		if (com.equals("/callGuGrade.do")) {
			System.out.println("gg서비스 시작=*=*=*=*=*=*");
			GuGrade gg = new GuGrade();
			gg.execute(request, response);

		} 
	}
}