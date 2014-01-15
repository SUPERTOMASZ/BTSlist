package Data;

public class Duty 
{
	
	private Worker worker;
	private String Data;
	public Duty()
	{
		
	}
	public Duty(Worker worker,String data)
	{
		this.worker=worker;
		this.Data=data;
	}
	public Worker getWorker() {
		return worker;
	}
	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}

}
