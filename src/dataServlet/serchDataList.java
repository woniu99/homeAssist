package dataServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Data.Humi;
import Data.Temp;
import Data.data;

public class serchDataList {

	private  DbforMySql db;
	private  Connection  conn = null;
   
    private   Temp t = new Temp();
    private List<data> dataList;
   
    
    private  ResultSet rs =null;
    private  PreparedStatement ps = null;
	public serchDataList(){
		
		db = new DbforMySql();
		conn = db.getConnectionInstance();		
	}
	public void setRs(){
		
		String sql = "select * from humidata order by id desc";
		
		try {
			ps = conn.prepareStatement(sql);
			rs= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	public void setRs1(){
		
		String sql = "select * from tempdata order by id desc";
		
		try {
			ps = conn.prepareStatement(sql);
			rs= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
    
	public List<data> getTemp(){
		setRs1();
		dataList = new ArrayList<data>();
    	try {
			while(rs.next()){
				data d = new data();
				d.setDate(rs.getString("date"));
				d.setData(rs.getString("temp"));
		        dataList.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataList;
	}
	public List<data> getHumi(){
		setRs();
		dataList = new ArrayList<data>();
    	try {
			while(rs.next()){
				data d = new data();
				d.setDate(rs.getString("date"));
				d.setData(rs.getString("humi"));
		        dataList.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataList;
	}

	
	
}
