package Myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataServlet.saveMima;
import dataServlet.serchMima;

public class servletzxx extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public servletzxx() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String flag = request.getParameter("flag");
	    System.out.println(flag+"-----------------------");

		if(flag.equals("login")){
			
			String password = request.getParameter("password");
			System.out.println(password+"             ");
	        serchMima sm = new serchMima(); 
			List<String> mimaList = sm.getMima();
			int i = 1;
			System.out.println(mimaList.size());
			for (String string : mimaList) {
				
				if(string.equals(password)){
					//out.print("success");
					response.sendRedirect("http://localhost:8080/Test/show.jsp");
					break;
				}
				else{
					i++;
				}
				
			}
			
			if(i>mimaList.size()){
			out.print("fail");
			}
		}else
			if(flag.equals("set"))
			
		{   
		    String password = request.getParameter("password");
		    System.out.println(password+"             ");
		    saveMima sm = new saveMima();
		    if(sm.saveps(password)){
		    	//out.print("success");
		    	
		    	response.sendRedirect("http://localhost:8080/Test/show.jsp");
		    	
		    }
			
			
		}
		
		
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
