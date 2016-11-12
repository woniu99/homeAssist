package dataServlet;

import Data.Humi;
import Data.Temp;
import Data.myData;


public interface DataService {

	 public boolean SaveData(myData data);
	 public boolean Savedata(Temp t);
	 public boolean Savedata(Humi h);
}
