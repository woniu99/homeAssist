package dataServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Data.Humi;
import Data.Temp;

public class serchMima {

	private  DbforMySql db;
	private  Connection  conn = null;
    private  ResultSet rs =null;
    private  PreparedStatement ps = null;
    private List<String> mimaList;
    private List<Temp> tempList;
    private List<Humi> humiList;
    
	public serchMima(){
		
		db = new DbforMySql();
		conn = db.getConnectionInstance();		
	}
	public void setRs(){
		
		String sql = "select * from password";
		
		try {
			ps = conn.prepareStatement(sql);
			rs= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
	public List<String>  getMima(){
		setRs();
		mimaList = new ArrayList();
    	try {
			while(rs.next()){
				
				mimaList.add(rs.getString("mima"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mimaList;
	}
	public List<Temp>  getTemp(){
		tempList = new ArrayList<Temp>();
		setRs();
		try {
			while(rs.next()){
				Temp t= new Temp();
				t.setTemp(rs.getString("mima"));
				t.setDate(rs.getString("date"));
				tempList.add(t);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tempList;
	}
	
	
	
}
