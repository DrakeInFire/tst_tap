package nat.pruebas.tst1.pages.GTT;

import nat.pruebas.tst1.Data.Persona;
import nat.pruebas.tst1.services.DAO.DAOPersona;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;

public class DetailPerson {
	
	@Property
	private Persona person;
	
	private DAOPersona dao;
	
	@InjectPage
	private ShowPersons show;
	
	DetailPerson(){
		dao=new DAOPersona();
	}
	void onActivate(String personDni)
	{
		try
		{
			dao.Open();
			person=dao.getByDni(personDni);
		}
		catch(Exception e)
		{	
			System.out.println("ERROR: onActivate");
		}
		finally
		{	
			dao.Close();
		}
	}
	Object onActionFromDelete(String dni)
	{
		try
		{
			dao.Open();
			dao.deleteByDni(dni);
			
		}
		catch(Exception e)
		{	
			System.out.println("ERROR: onActionFromDelete");
		}
		finally
		{	
			dao.Close();
		}
		return show;
		
	}
}
