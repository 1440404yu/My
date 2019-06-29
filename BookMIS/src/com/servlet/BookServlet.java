package com.servlet;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commons.util.Pager;
import com.commons.util.StringUtil;
import com.factory.ServiceFactory;
import com.model.Book;
import com.model.BookQuery;
import com.model.Company;
import com.service.BookService;






/**
 * 图书管理控制器
 */
@WebServlet("/BookServlet")
public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = ServiceFactory.getBookServiceInstance();

	/**
	 * 查询图书列表
	 * 
	 * @param request
	 * @param response
	 */
//	protected void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		List<Map<String, Object>> lists = this.bookService.findAllBook();
//		request.getSession().setAttribute("bookList", lists);
//		this.forward("/main.jsp");
//		System.out.println(lists);
//		
//	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		this.initData(request, response);
		String strPageNo = request.getParameter("pageNo");
		int pageNo = 1;
		if (!StringUtil.nil(strPageNo)) {
			pageNo = Integer.parseInt(strPageNo);
		}
		String strPageSize = request.getParameter("pageSize");
		int pageSize = 5;
		if (!StringUtil.nil(strPageSize)) {
			pageSize = Integer.parseInt(strPageSize);
		}
		Pager pager = new Pager();
		pager.setPageNo(pageNo);
		pager.setPageSize(pageSize);		
		BookQuery query = this.getParameterForBean(BookQuery.class);
		List<Map<String, Object>> lists = this.bookService.findAllBook(query, pager);
		request.getSession().setAttribute("bookList", lists);
		request.getSession().setAttribute("pager", pager);
		this.forward("/main.jsp");		
	}
	/**
	 * 新增图书请求
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	protected void add(HttpServletRequest request, HttpServletResponse response) throws Exception {   
      Book newBook=this.getParameterForBean(Book.class);
       if(this.bookService.addBook(newBook)) {
    	   this.forward("/add_result.jsp");
       }else {
    	   request.setAttribute("error", "系统异常，操作失败!");
			this.forward("/badd.jsp");
		}
	}
	/**
	 * 跳转至add.jsp
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	protected void goAdd(HttpServletRequest request, HttpServletResponse response) throws Exception {
     	this.initData(request, response);
		this.forward("/badd.jsp");
	}
	private void initData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		@SuppressWarnings("unchecked")
		List<Company> companyList = (List<Company>) request.getSession().getAttribute("companyList");
		System.out.println(companyList);
		if (companyList == null) {
			companyList = this.bookService.findCName();
			request.getSession().setAttribute("companyList", companyList);
		}		
	}	
	/**
	 * 跳转至modify.jsp
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	protected void goModify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String bid = request.getParameter("bid");
		Book currBook = this.bookService.findBookByBid(bid);
		request.getSession().setAttribute("currBook", currBook);
		this.initData(request, response);
		this.forward("/modify.jsp");
	}
	/**
	 * 处理更新图书信息请求
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	protected void modify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Book currBook = this.getParameterForBean(Book.class);
		if (this.bookService.modifyBook(currBook)) {
			this.forward("/modify_success.jsp");
		} else {
			request.setAttribute("error", "系统异常，操作失败!");
			this.forward("/modify.jsp");
		}
	}

	/**
	 * 处理删除图书请求
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	protected void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String bid = request.getParameter("bid");
		if (this.bookService.removeBook(bid)) {
			request.setAttribute("message", "删除成功!");
		} else {
			request.setAttribute("message", "系统异常，删除失败!");
		}
		this.forward("/remove_success.jsp");
	}
	/**
	 * 处理查询请求
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	protected void find(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BookQuery query = this.getParameterForBean(BookQuery.class);
		String reset = request.getParameter("reset");
		if (reset != null) {
			request.getSession().removeAttribute("query");
			query = null;
			
		} else {
			request.getSession().setAttribute("query", query);
		}
		Pager pager = new Pager();
		pager.setPageNo(1);
		pager.setPageSize(5);
		List<Map<String, Object>> lists = this.bookService.findAllBook(query, pager);
		request.getSession().setAttribute("bookList", lists);
		request.getSession().setAttribute("pager", pager);
		this.forward("/main.jsp");
	}
		
}
