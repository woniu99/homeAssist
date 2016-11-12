package dataServlet;

import Data.Humi;
import Data.Temp;
import Data.myData;

public class DataServiceImpl implements DataService{

	private DataDao dataDao = null;
	
	
	public DataServiceImpl(){
		
		dataDao = new DataDaoImpl();
	}
	
	@Override
	public boolean SaveData(myData data) {
		// TODO Auto-generated method stub
		return dataDao.Savedata(data);
	}

	@Override
	public boolean Savedata(Temp t) {
		// TODO Auto-generated method stub
		return dataDao.Savedata(t);
	}

	@Override
	public boolean Savedata(Humi h) {
		// TODO Auto-generated method stub
		return dataDao.Savedata(h);
	}
	
	

}
