package duty;

import java.io.Serializable;

public class Duty implements Serializable
{
	private int id;
	private Worker worker;
	private String Data;
	public Duty()
	{
		
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
}
