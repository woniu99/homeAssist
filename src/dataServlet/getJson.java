package dataServlet;

import Data.HumiList;
import Data.TempList;
import Data.dataList;

import com.google.gson.Gson;

public class getJson {
	Gson gson = new Gson();
	dataList dl = new dataList();
	serchDataList sdl = new serchDataList();
	
	
	public String getHumiJson(){
		
		
		dl.setDataList(sdl.getHumi());
	    String jsonstr = gson.toJson(dl);
		System.out.println(jsonstr);
		return jsonstr;
	}
	public String getTempJson(){
		
		
		dl.setDataList(sdl.getTemp());
	    String jsonstr = gson.toJson(dl);
		System.out.println(jsonstr);
		return jsonstr;
	}
	
	
	
	
	
	
}

