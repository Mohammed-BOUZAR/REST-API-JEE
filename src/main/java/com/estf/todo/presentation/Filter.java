package com.estf.todo.presentation;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import com.estf.todo.beans.Todo;
import com.google.gson.Gson;

/**
 * Servlet Filter implementation class Filter
 */
@WebFilter("/todos/*")
public class Filter extends HttpFilter implements javax.servlet.Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("filter");
		HttpServletRequest req = (HttpServletRequest) request;
		if (req.getMethod().toUpperCase().equals("POST") || req.getMethod().toUpperCase().equals("PUT")) {
			Gson gson = new Gson();
			Todo todo = gson.fromJson(request.getReader(), Todo.class);
			System.out.println(todo.getId() + " " + todo.getTitle() + " " + todo.getCompleted());
			request.setAttribute("todo", todo);
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
