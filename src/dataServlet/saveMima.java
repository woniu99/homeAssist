package dataServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class saveMima {
	private  DbforMySql db;
	private  Connection  conn = null;
	private  PreparedStatement ps = null;
	private  ResultSet rs;	
	
	public saveMima(){
		db = new DbforMySql();
		conn = db.getConnectionInstance();
	}
	public boolean saveps(String mima){
		boolean flag = false;
		String sql = "insert into password(mima) values(?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,mima);
			
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
