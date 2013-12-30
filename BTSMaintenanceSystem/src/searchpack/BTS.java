package searchpack;

import com.example.btsmaintenancesystem.R;
import com.example.btsmaintenancesystem.R.drawable;

public class BTS
{
	
	private String city;
	private String street;
	private String cordX;
	private String cordY;
	private String PTCname;
	private String PTKname;
	private int type;
	public BTS()
	{
	}
	public BTS(String city,String street,String cordX,String cordY,
			String PTCname,String PTKname)
	{
		this.city=city;
		this.street=street;
		this.cordX=cordX;
		this.cordY=cordY;
		this.PTCname=PTCname;
		this.PTKname=PTKname;
		this.type=R.drawable.towerico1;
	
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCordX() {
		return cordX;
	}
	public void setCordX(String cordX) {
		this.cordX = cordX;
	}
	public String getCordY() {
		return cordY;
	}
	public void setCordY(String cordY) {
		this.cordY = cordY;
	}
	public String getPTCname() {
		return PTCname;
	}
	public void setPTCname(String pTCname) {
		PTCname = pTCname;
	}
	public String getPTKname() {
		return PTKname;
	}
	public void setPTKname(String pTKname) {
		PTKname = pTKname;
	}
	@Override
	public String toString() {
		return city ;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	

}
