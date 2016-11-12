package dataServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Data.Humi;
import Data.Temp;

public class serchData {

	private  DbforMySql db;
	private  Connection  conn = null;
    private   Humi h = new Humi();
    private   Temp t = new Temp();
    private  ResultSet rs =null;
    private  PreparedStatement ps = null;
   
	public serchData(){
		
		db = new DbforMySql();
		conn = db.getConnectionInstance();		
	}
	public void setRs(){
		
		String sql = "select * from humidata ";
		
		try {
			ps = conn.prepareStatement(sql);
			rs= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	public void setRs1(){
		
		String sql = "select * from tempdata ";
		
		try {
			ps = conn.prepareStatement(sql);
			rs= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
    public  Humi getHumi(){
    	setRs();
    	try {
			while(rs.next()){
				
				h.setDate(rs.getString("date"));
				h.setHumi(rs.getString("humi"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return h;
    } 
    
    public  List<String> getHumiList(){
    	setRs();
    	 List<String> a = new ArrayList();
    	try {
			while(rs.next()){
			
				a.add(rs.getString("humi"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return a;
    } 
	public Temp getTemp(){
		setRs1();
    	try {
			while(rs.next()){
				
				t.setDate(rs.getString("date"));
				t.setTemp(rs.getString("temp"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	  public  List<String> getTempList(){
	    	setRs1();
	   	 List<String> a = new ArrayList();
	    	try {
				while(rs.next()){
				
					a.add(rs.getString("temp"));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return a;
	    } 
	
}
