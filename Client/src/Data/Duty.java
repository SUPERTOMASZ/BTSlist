package Data;

import java.io.IOException;
import java.io.Serializable;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

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
/*
	@Override
	public String toString() {
		return id+" "+worker.toString()+" "+Data;
	}
	@JsonIgnore
	public String getAsJSON() {
	    ObjectMapper mapper = new ObjectMapper();
	    try {
			return mapper.writeValueAsString(this) ;
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    return null;
	}*/
	
}
