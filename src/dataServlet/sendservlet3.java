package dataServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.dataForjsp;

import com.google.gson.Gson;

public class sendservlet3 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public sendservlet3() {
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

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String flag = request.getParameter("flag").trim();
		if(flag.equals("temp")){
			
			//out.print(sd.getTemp().getTemp());
			
			
			serchData sd1  = new serchData();
			List<String> aa = sd1.getHumiList();
			System.out.println(aa.size());
			dataForjsp dfj = new dataForjsp();
			dfj.setDataList(aa);
			Gson gson = new Gson();
			String jsonstr = gson.toJson(dfj);
			out.print(jsonstr);
			
			
			
			
			
		}
		else
			if(flag.equals("humi"))
		{
			//out.println(sd.getHumi().getHumi());
				serchData sd1  = new serchData();
				List<String> aa = sd1.getTempList();
				System.out.println(aa.size());
				dataForjsp dfj = new dataForjsp();
				dfj.setDataList(aa);
				Gson gson = new Gson();
				String jsonstr = gson.toJson(dfj);
				out.print(jsonstr);
			
		}
			else{
				out.print("fail");
			}
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
