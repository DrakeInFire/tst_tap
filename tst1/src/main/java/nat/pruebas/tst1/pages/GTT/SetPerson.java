package nat.pruebas.tst1.pages.GTT;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import nat.pruebas.tst1.Data.Persona;
import nat.pruebas.tst1.services.DAO.*;

public class SetPerson {
	
	@Property
	private Persona person;
	
	
	private DAOPersona dao;
	
	void onSuccess()
	{
		dao=new DAOPersona ();
		try{
			dao.Open();
			dao.Store(person);
		}
		catch(Exception e)
		{
			System.out.println("ERROR en SetPerson");
		}
		finally
		{
			dao.Close();
		}
		
	}
}
