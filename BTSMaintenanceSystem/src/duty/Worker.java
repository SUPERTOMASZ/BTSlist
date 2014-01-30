package duty;

import java.io.Serializable;

public class Worker implements Serializable
{
	private String name;
	private String surname;
	private int ID;
	public Worker()
	{
		
	}
	public Worker(String name,String surname)
	{
		this.name=name;
		this.surname=surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+" "+surname;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

}
