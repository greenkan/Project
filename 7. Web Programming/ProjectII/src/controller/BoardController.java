package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardCommand.BCommand;
import boardCommand.BContentCommand;
import boardCommand.BDeleteCommand;
import boardCommand.BListCommand;
import boardCommand.BModifyCommand;
import boardCommand.BReplyCommand;
import boardCommand.BReplyViewCommand;
import boardCommand.BWriteCommand;

/**
 * Servlet implementation class BoardController
 */
@WebServlet({"/list.do","/write.do","/content_view.do"})
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("board doGet 들어옴");
		actionDo(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("board doPost 들어옴");
		actionDo(request, response); 
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("board actionDo 들어옴");
		
		request.setCharacterEncoding("UTF-8");
		
		String viewPage =null;
		BCommand command =null;
		
		String uri = request.getRequestURI();
		System.out.println("uri :" +uri);
		String conPath = request.getContextPath();
		System.out.println("conPath : "+conPath);
		String com = uri.substring(conPath.length());
//		String board = "/board";
//		String com = asdf.substring(board.length());
//		System.out.println(com);
		
		
		if(com.equals("/write_view.do")) {
			viewPage = "write_view.jsp";
		} else if(com.equals("/write.do")) {
			command = new BWriteCommand();
			command.execute(request, response);
			
			response.sendRedirect("list.do");
		} else if(com.equals("/list.do")){
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		} else if(com.equals("/content_view.do")){
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		} else if(com.equals("/modify.do")){
			command = new BModifyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/delete.do")){
			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/reply_view.do")){
			command = new BReplyViewCommand();
			command.execute(request, response);
			viewPage = "reply_view.jsp";
		} else if(com.equals("/reply.do")){
			command = new BReplyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/membersAll.do")){
			viewPage = "./board/membersAll.jsp";
		}
		
		if(viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
	}
}
