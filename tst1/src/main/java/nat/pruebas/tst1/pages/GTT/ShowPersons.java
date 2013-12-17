package nat.pruebas.tst1.pages.GTT;

import nat.pruebas.tst1.services.DAO.*;
import nat.pruebas.tst1.Data.*;

import java.util.List;

import org.apache.tapestry5.annotations.Property;



public class ShowPersons {
	

	private Persona person;
	
	@Property
	private int rowIndex =0;
	
	private DAOPersona dao;
	
	ShowPersons(){
		dao=new DAOPersona();
	}
	public List<Persona> getPersons()
	{
		List<Persona> list = null;
		
		try 
		{
			dao.Open();
			list=dao.getAll();
		}
		catch(Exception e)
		{
			System.out.println("Error getPersons");
		}
		finally{
			dao.Close();
			
		}
		return list;
	}


	public Persona getPerson() {
		return person;
	}


	public void setPerson(Persona person) {
		rowIndex++;
		this.person = person;
	}
	
	public void onActionFromDelete(String dni)
	{
		
		try{
			dao.Open();
			dao.deleteByDni(dni);
		}
		catch(Exception e)
		{
			System.out.println("Error fromDelete");
		}
		finally
		{
			dao.Close();
		}
		
	}
	
	public void onActionFromDeleteall(){
		
		try{
			dao.Open();
			dao.deleteAll();
		}
		catch(Exception e)
		{
			System.out.println("Error fromDelete");
		}
		finally
		{
			dao.Close();
		}
		
	}

}
