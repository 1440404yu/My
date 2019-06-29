package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.factory.ServiceFactory;
import com.model.Users;
import com.service.UsersService;

/**
 * 登录控制器
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersService usersService = ServiceFactory.getUsersServiceInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password =request.getParameter("password");
		Users currentUser = this.usersService.findBy(username, password);
		if (currentUser == null) {
			request.setAttribute("error", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("currentUser", currentUser);
			response.sendRedirect("BookServlet?method=list");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
