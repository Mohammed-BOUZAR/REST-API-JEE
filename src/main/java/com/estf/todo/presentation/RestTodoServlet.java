package com.estf.todo.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estf.todo.beans.Todo;
import com.estf.todo.business.DefaultServices;

/**
 * Servlet implementation class TodoServlet
 */
@WebServlet("/todos/*")
public class RestTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] path = request.getRequestURI().split("/");
		if (path.length == 4) {
			if (path[3] != null) {
				System.out.println("id: " + path[3]);
			}
		} else if (path.length > 4) {
			System.out.println("404 Page Not Found");
			request.getRequestDispatcher("/WEB-INF/NotFound.jsp").forward(request, response);
		} else {
			System.out.println("root:" + path[2]);
			response.sendRedirect("todos");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("do Post: ");
		Todo todo = (Todo) request.getAttribute("todo");
		if(DefaultServices.getInstance().addTodo(todo) != null)
			response.sendRedirect("todos");
		doGet(request, response);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

}
