package nat.pruebas.tst1.pages.Login;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;

import nat.pruebas.tst1.Data.*;
import nat.pruebas.tst1.services.DAO.*;


public class Log {

	
	@Property
	private UserLogin login;
	
	private DAOPersona dao;
	@SessionState
	private Sesion sesion;

	public Log(){
		dao=new DAOPersona();
	}
	
	Object onSuccess()
	{
		Persona p=null;
		try{
			dao.Open();
			p=dao.getByNameUnique(login.getName());
		}
		catch(Exception e)
		{
			System.out.println("ERROR en SetPerson");
		}
		finally
		{
			dao.Close();
		}
		if(p!=null)
		{
			if(p.getDni().equals(login.getId()))
			{
				System.out.println("[LOGGIN] Correcto");
				sesion.setId(login.getId());
				sesion.setName(login.getName());
				sesion.setLoged(true);
				return PrivateZone.class;
			}
			else
			{
				System.out.println("[LOGGIN] ERROR: P.dni " + p.getDni()  );
				sesion.setLoged(false);
				return null;
			}
		}
		return null;
	}
	
	Object onActivate(){
		if(sesion.isLoged())
		{
			return PrivateZone.class;
		}
		else
		{
			return null;
		}
	}

}
