package duty;

public class Duty
{
	
	private String workerName;
	private String workerSurname;
	private String date;
	public Duty()
	{
		
	}
	public Duty(String name, String surname,String date)
	{
		this.workerName=name;
		this.workerSurname=surname;
		this.date=date;
		
	}
	public String getWorkerName() {
		return workerName;
	}
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
	public String getWorkerSurname() {
		return workerSurname;
	}
	public void setWorkerSurname(String workerSurname) {
		this.workerSurname = workerSurname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
