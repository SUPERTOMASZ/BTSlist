package station;

import com.example.btsmaintenancesystem.R;
import com.example.btsmaintenancesystem.R.drawable;

public class Station
{
	private String stationNum;
	private String netWorksNum;
	private String PTCNum;
	private String PTKNum;
	private String Owner;
	private String stationName;
	private String PTCName;
	private String PTKName;
	private String region;
	private String area;
	private String topListy; //?!
	private String deletedData;
	private String street;
	private String streetNo;
	private String zip_Code;
	private String city;
	private String community="gmina";
	private String district="powiat";
	private String province="wojewodztwo";
	private String ulicaInaczej; // ?!
	private String type;
	private String candidat;
	private String cordX;
	private String cordY;
	private String height;
	private String building_height;
	private String Zagiel; // ?!
	private String accessDescribe;
	private String stationDescribe;
	private String PlusNum;
	private String PlayNum;
	private String powerPlantNum;
	private String updatedTime;
	private int ImageId;
	public Station()
	{
	}
	public String getStationNum() {
		return stationNum;
	}
	public void setStationNum(String stationNum) {
		this.stationNum = stationNum;
	}
	public String getNetWorksNum() {
		return netWorksNum;
	}
	public void setNetWorksNum(String netWorksNum) {
		this.netWorksNum = netWorksNum;
	}
	public String getPTCNum() {
		return PTCNum;
	}
	public void setPTCNum(String pTCNum) {
		PTCNum = pTCNum;
	}
	public String getPTKNum() {
		return PTKNum;
	}
	public void setPTKNum(String pTKNum) {
		PTKNum = pTKNum;
	}
	public String getOwner() {
		return Owner;
	}
	public void setOwner(String owner) {
		Owner = owner;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getPTCName() {
		return PTCName;
	}
	public void setPTCName(String pTCName) {
		PTCName = pTCName;
	}
	public String getPTKName() {
		return PTKName;
	}
	public void setPTKName(String pTKName) {
		PTKName = pTKName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTopListy() {
		return topListy;
	}
	public void setTopListy(String topListy) {
		this.topListy = topListy;
	}
	public String getDeletedData() {
		return deletedData;
	}
	public void setDeletedData(String deletedData) {
		this.deletedData = deletedData;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}
	public String getZip_Code() {
		return zip_Code;
	}
	public void setZip_Code(String zip_Code) {
		this.zip_Code = zip_Code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCommunity() {
		return community;
	}
	public void setCommunity(String community) {
		this.community = community;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getUlicaInaczej() {
		return ulicaInaczej;
	}
	public void setUlicaInaczej(String ulicaInaczej) {
		this.ulicaInaczej = ulicaInaczej;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
		setImageId(type);
	}
	
	public String getCandidat() {
		return candidat;
	}
	public void setCandidat(String candidat) {
		this.candidat = candidat;
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
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getBuilding_height() {
		return building_height;
	}
	public void setBuilding_height(String building_height) {
		this.building_height = building_height;
	}
	public String getZagiel() {
		return Zagiel;
	}
	public void setZagiel(String zagiel) {
		Zagiel = zagiel;
	}
	public String getAccessDescribe() {
		return accessDescribe;
	}
	public void setAccessDescribe(String accessDescribe) {
		this.accessDescribe = accessDescribe;
	}
	public String getStationDescribe() {
		return stationDescribe;
	}
	public void setStationDescribe(String stationDescribe) {
		this.stationDescribe = stationDescribe;
	}
	public String getPlusNum() {
		return PlusNum;
	}
	public void setPlusNum(String plusNum) {
		PlusNum = plusNum;
	}
	public String getPlayNum() {
		return PlayNum;
	}
	public void setPlayNum(String playNum) {
		PlayNum = playNum;
	}
	public int getImageId() {
		return ImageId;
	}
	public void setImageId(int imageId) {
		ImageId = imageId;
	}
	public void setImageId(String input) {
		if(input.contains("budynek"))
			this.ImageId=R.drawable.indoorico;
		else if(input.contains("kosciol"))
			this.ImageId=R.drawable.sacrumico;
		else if(input.contains("maszt"))
			this.ImageId=R.drawable.towerico;
		else if(input.contains("wieza")||input.contains("tower"))
			this.ImageId=R.drawable.tower2ico;
		else if(input.contains("slup"))
			this.ImageId=R.drawable.pilarico;
		else if(input.contains("komin"))
			this.ImageId=R.drawable.kominico;
		else
			this.ImageId=R.drawable.anyico;
		
	}
	public String getPowerPlantNum() {
		return powerPlantNum;
	}
	public void setPowerPlantNum(String powerPlantNum) {
		this.powerPlantNum = powerPlantNum;
	}
	public String getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	

}
