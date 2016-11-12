package dataServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.Humi;
import Data.Temp;
import Data.myData;

public class dataservlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public dataservlet() {
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
		//String temp = request.getParameter("temp").trim();
		//System.out.println(temp);
		doPost(request, response);
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
		
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String flag = request.getParameter("flag").trim();
		if(flag.equals("temp")){
			
			String temp = request.getParameter("value").trim();  //温度
			myData data = new myData();
			Temp t = new Temp();
			t.setDate(time);
			t.setTemp(temp);
			System.out.println(temp+"----");
			Factory.getDataServiceImplInstance().Savedata(t);
			
		}else
			if(flag.equals("humi"))
			
 		{ 
				String humi = request.getParameter("value").trim();  //温度
				myData data = new myData();
				Humi h = new Humi();
				h.setDate(time);
				h.setHumi(humi);
				System.out.println(humi+"----");
				Factory.getDataServiceImplInstance().Savedata(h);
				
				
				

		}
		
//		  Date date = new Date();//获得系统时间.
//          String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//将时间格式转换成符合Timestamp要求
//          PrintWriter out = response.getWriter();
//	       out.println("sucess"+date);
		
		
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
