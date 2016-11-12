package dataServlet;

import Data.Humi;
import Data.Temp;
import Data.myData;

public interface DataDao {

	public boolean Savedata(myData data);
	public boolean Savedata(Temp t);
	public boolean Savedata(Humi h);
}
