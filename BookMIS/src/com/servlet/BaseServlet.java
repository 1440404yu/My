package com.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

/**
 * Servlet基类
 * 
 * @author dougang
 *
 */
@SuppressWarnings("all")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ThreadLocal<HttpServletRequest> threadRequest = new ThreadLocal<>();
	private ThreadLocal<HttpServletResponse> threadResponse = new ThreadLocal<>();

	static {
		ConvertUtils.register(new Converter() {
			@Override
			public Object convert(Class arg0, Object arg1) {
				String str = arg1.toString();
				Date date = null;
				try {
					date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return date;
			}
		}, Date.class);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 将当前线程中的request和response对象分别放入不同的ThreadLocal对象
		threadRequest.set(request);
		threadResponse.set(response);

		// 通过参数，获取方法名
		String methodName = request.getParameter("method");
		if (methodName != null) {
			// 当前Servlet子类类型(实际访问的是子类，而不是BaseServlet)
			Class<?> clazz = this.getClass();
			try {
				// 根据方法名称和参数类型获取对应的方法对象
				Method method = clazz.getDeclaredMethod(methodName,
						new Class[] { HttpServletRequest.class, HttpServletResponse.class });
				// 调用方法
				method.invoke(this, new Object[] { request, response });
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 清空当前线程中的ThreadLocal对象
		threadRequest.remove();
		threadResponse.remove();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 实现参数的自动封装
	 * 
	 * @param clazz
	 *            目标Bean的class对象
	 * @return 转换结果
	 */
	protected <T> T getParameterForBean(Class<T> clazz) {
		T obj = null;
		try {
			obj = clazz.newInstance();
			BeanUtils.populate(obj, threadRequest.get().getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * 实现请求转发操作
	 */
	protected void forward(String path) throws ServletException, IOException {
		threadRequest.get().getRequestDispatcher(path).forward(threadRequest.get(), threadResponse.get());
	}

	/**
	 * 实现重定向操作
	 */
	protected void redirect(String path) throws ServletException, IOException {
		threadResponse.get().sendRedirect(threadRequest.get().getContextPath() + path);
	}

}
