package Data;

public class Humi {

 @Override
	public String toString() {
		return "Humi [humi=" + humi + ", date=" + date + "]";
	}
private String humi;
 private String date;

public String getHumi() {
	return humi;
}
public void setHumi(String humi) {
	this.humi = humi;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
 
 
}
