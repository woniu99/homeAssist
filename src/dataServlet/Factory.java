package dataServlet;



public class Factory {

	public static DataService getDataServiceImplInstance(){
		
		
		return (DataService) new DataServiceImpl();
	}
}
 