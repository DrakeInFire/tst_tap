package nat.pruebas.tst1.pages.Login;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;

import nat.pruebas.tst1.Data.Persona;
import nat.pruebas.tst1.Data.Sesion;
import nat.pruebas.tst1.services.DAO.DAOFile;
import nat.pruebas.tst1.services.DAO.DAOPersona;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

public class ViewUsersFile {

	@SessionState
	private Sesion sesion;
	
	//Implementados getter y setter
	private Persona newuser;
	private DAOPersona daop;
	private DAOFile daof;
	
	@Property
	String avalible;
	@Property
	boolean anexable;
	
	@Persist
	private List<Persona> listado;
	
	@Persist
	private Map<String,String> mapa;
	
	private String path=System.getProperty("user.home")+System.getProperty("file.separator")+
			"serverfiles"+System.getProperty("file.separator")+"users.txt";
	
	ViewUsersFile(){
		daop=new DAOPersona();
		daof=new DAOFile();
	}
	
	
	public List<Persona> getNewusers()
	{	
		//System.out.println("HOLA");
		if(listado==null)
		{
			mapa=new HashMap<String,String>();
			listado=daof.getUserFromFile(path);
			for(int i=0;i<listado.size();i++)
			{
				Persona p=null;
				try{
					daop.Open();
					p=daop.getByDni(listado.get(i).getDni());
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					daop.Close();
				}
				if(p==null)
				{
					
					mapa.put(listado.get(i).getDni(), "Yes");
				}
				else
				{
					mapa.put(listado.get(i).getDni(), "No");
				}
			}
		}
		else
		{
			System.out.println("Sin DAO");
		}
		return listado;
	}
	
	public void setNewuser(Persona newuser)
	{
		avalible=mapa.get(newuser.getDni());
		anexable=mapa.get(newuser.getDni()).equals("Yes");
		this.newuser=newuser;
	}
	public Persona getNewuser()
	{
		return newuser;
	}
	void onActionFromAddall()
	{
		for(int i=0;i<listado.size();i++)
		{
			//Obtenemos para cada dni de la lista restante, si esta
			//ya añadido a la base de datos o no, valor que esta almacenado
			//en el mapa (Yes=nombre disponible, No=no disponible)
			if(mapa.get(listado.get(i).getDni()).equals("No"))
			{
				removerow(listado.get(i).getDni());
			}
		}
		try
		{
			daop.Open();
			daop.Store(listado);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			daop.Close();
		}

		File file=new File(path);
		if(file.delete())
		{
			sesion.setUploadedFileUsers(false);
		}
		listado=null;
		mapa=null;
	}
	void onActionFromRemoverow(String dni)
	{
		removerow(dni);
	}
	
	void onActionFromAddrow(String dni)
	{
		Persona p=null;
		for(int i=0;i<listado.size();i++)
		{
			if(listado.get(i).getDni().equals(dni))
			{
				p=listado.get(i);
				break;
			}
		}
		if(p!=null)
		{
			try
			{
				daop.Open();
				daop.Store(p);
				removerow(dni);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				daop.Close();
			}
		}
		
	}
	
	
	void onActionFromRemovefile()
	{
		File file=new File(path);
		if(file.delete())
		{
			sesion.setUploadedFileUsers(false);
		}
		listado=null;
		mapa=null;
	}
	void onActionFromReload()
	{
		mapa=new HashMap<String,String>();
		listado=daof.getUserFromFile(path);
		for(int i=0;i<listado.size();i++)
		{
			Persona p=null;
			try{
				daop.Open();
				p=daop.getByDni(listado.get(i).getDni());
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				daop.Close();
			}
			if(p==null)
			{
				
				mapa.put(listado.get(i).getDni(), "Yes");
			}
			else
			{
				mapa.put(listado.get(i).getDni(), "No");
			}
		}
	}
	
	Object onActivate()
	{
		
		if(sesion.isLoged())
		{
			if(sesion.isUploadedFileUsers())
			{
				return null;
			}
			else
			{
				return Setbyfile.class;
			}
		}
		else
		{
			return Log.class;
		}
		
		
	}
	void removerow(String dni){
		
		System.out.println(dni);
		for(int i=0;i<listado.size();i++)
		{
			if(listado.get(i).getDni().equals(dni))
			{
				listado.remove(i);
			}
		}
		
	}
	

}
