package nat.pruebas.tst1.pages.Login;

import org.apache.tapestry5.annotations.SessionState;

import nat.pruebas.tst1.Data.*;

public class PrivateZone {
	@SessionState
	Sesion sesion;
	
	
	public String getLog(){
		if(sesion.isLoged())
		{
			return "Estas Logeado";
		}
		else
		{
			return "No estas logeado";
		}
	}
	
	Object onActivate()
	{
		if(sesion.isLoged())
		{
			System.out.println("si");
			return null;
		}
		else
		{
			System.out.println("no");
			return Log.class;
		}
	}
	
	void onActionFromLogout(){
		sesion.setLoged(false);
	}

}
