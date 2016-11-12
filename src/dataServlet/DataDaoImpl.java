package dataServlet;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Data.Humi;
import Data.Temp;
import Data.myData;

public class DataDaoImpl implements DataDao {

	private  DbforMySql db;
	private  Connection  conn = null;
	private  PreparedStatement ps = null;
	private  ResultSet rs;	
	
public DataDaoImpl(){
		
		db = new DbforMySql();
		conn = db.getConnectionInstance();
	}


	@Override
	public boolean Savedata(myData data) {
		// TODO Auto-generated method stub	
		boolean flag = false;
		String sql = "insert into mydata(temp,humi,time) values(?,?,?)";
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement(sql);
			//ps.setString(1,"1");
			ps.setString(1,data.getTemp());
			ps.setString(2,data.getHumi());
			ps.setString(1, time);
						int i = ps.executeUpdate();
			 if(1 == i){
				 flag = true;
		 }		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return flag;
	}


	@Override
	public boolean Savedata(Temp t) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "insert into tempData(date,temp) values(?,?)";
//		java.util.Date date = new java.util.Date();
//		Date date2 = new Date(date.getTime());
//		Date date = new Date();
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String time = format.format(date);
		
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,t.getDate());
			ps.setString(2,t.getTemp());
			
	      int i = ps.executeUpdate();
			 if(1 == i){
				 flag = true;
		 }		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return flag;
	}
	@Override
	public boolean Savedata(Humi h) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "insert into humiData(date,humi) values(?,?)";
//		java.util.Date date = new java.util.Date();
//		Date date2 = new Date(date.getTime());
//		Date date = new Date();
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String time = format.format(date);
		
		
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, h.getDate());
            ps.setString(2,h.getHumi());
			
	      int i = ps.executeUpdate();
			 if(1 == i){
				 flag = true;
		 }		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return flag;
	}

	
	
	
}
	
	

	
	

