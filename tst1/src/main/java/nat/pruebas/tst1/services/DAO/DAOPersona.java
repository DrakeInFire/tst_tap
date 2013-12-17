package nat.pruebas.tst1.services.DAO;

import nat.pruebas.tst1.Data.Persona;

import java.util.ArrayList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.EmbeddedObjectContainer;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class DAOPersona {
	
	private ObjectContainer DB;
	private boolean open;
	
	public void Open(){
		try{
			DB=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"BBDD.dat");
			System.out.println("[DB4O] Base de datos abierta");
			open=true;
		}
		catch(Exception e)
		{
			System.out.println("[DB4O]ERROR: No se pudo abrir la BDD");
		}
		
	}
	
	public void Close()
	{
		if(open)
		{
			try
			{
				DB.close();
				System.out.println("[DB4O] Base de datos cerrada");
			}
			catch(Exception e)
			{
				System.out.println("[DB4O]ERROR: No se pudo cerrar la BDD");
			}
		}
		else
		{
			System.out.println("[DB4O]ERROR: BDD no abierta");
		}
	}
		
	 public void Store (Persona persona){
		if(open)
		{
			try
		 	{
				DB.store(persona);
				System.out.println("[DB4O] Persona almacenada");
		 	}
			catch(Exception e)
		 	{
		 		System.out.println("[DB4O]ERROR: No se pudo almacenar la persona");
		 	}
		}
		else
		{
			System.out.println("[DB4O]ERROR: BDD no abierta");
		}
		 
	 }
	 public void Store(List<Persona> lista)
	 {
			if(open)
			{
				try
			 	{
					for(int i=0;i<lista.size();i++)
					{
						DB.store(lista.get(i));
						System.out.println("[DB4O]Stored: "+lista.get(i).getNombre()+ " "+lista.get(i).getApellido()+" "+lista.get(i).getDni());
					}
			 	}
				catch(Exception e)
			 	{
			 		System.out.println("[DB4O]ERROR: No se pudo almacenar todas las personas");
			 	}
			}
			else
			{
				System.out.println("[DB4O]ERROR: BDD no abierta");
			}
	 }
	 
	 public List<Persona> getAll()
	 {
		 if(open)
		 {
			 
			 try{
				 Query query=DB.query();
				 query.constrain(Persona.class);
				 ObjectSet resultado = query.execute();
				 return ObtenerLista(resultado);
			 }
			 catch(Exception e)
			 {
				 System.out.println("[DB4O] ERROR: No se pudieron obtener las personas");
				 return null;
			 }
		 }
		 else
		 {
			 System.out.println("[DB4O] ERROR:BDD no abierta");
			 return null;
		 }
		 
	 }
	 public Persona getByNameUnique(String name)
	 {
		 if(open)
		 {
			 
			 try{
				 Query query=DB.query();
				 query.constrain(Persona.class);
				 query.descend("nombre").constrain(name);
				 ObjectSet resultado = query.execute();
				 return ObtenerUnico(resultado);
			 }
			 catch(Exception e)
			 {
				 System.out.println("[DB4O] ERROR: No se pudieron obtener las personas");
				 return null;
			 }
		 }
		 else
		 {
			 System.out.println("[DB4O] ERROR:BDD no abierta");
			 return null;
		 }
		 
	 }
	 
	 
	private List<Persona> ObtenerLista(ObjectSet resultado){
		List<Persona> lista=new ArrayList<Persona>();
		while(resultado.hasNext())
		{
			lista.add((Persona)resultado.next());
		}
		return lista;
	}
	
	private Persona ObtenerUnico(ObjectSet resultado){
		
		if(resultado.hasNext())
		{
			return (Persona)resultado.next();
		}
		return null;
	}
	
	public Persona getByDni(String dni)
	{	
		if(open)
		{
			try
			{
				Query query=DB.query();
				query.constrain(Persona.class);
				query.descend("dni").constrain(dni);
				return ObtenerUnico(query.execute());
				
			}
			catch(Exception e)
			{
				System.out.println("[DB4O] ERROR: No se pudo recuperar elemento por dni");
				return null;
			}
			
		}
		else
		{
			System.out.println("[DB4O] ERROR: BDD no abierta");
			return null;
		}
	}
	public void deleteByDni(String dni)
	{
		if(open)
		{
			try
			{
				Query query =DB.query();
				query.constrain(Persona.class);
				query.descend("dni").constrain(dni);
				ObjectSet resultado=query.execute();
				
				if(resultado.hasNext())
				{
					Persona p=(Persona)resultado.next();
					DB.delete(p);
					System.out.println("[DB4O] Persona eliminada correctamente");
				}
				else
				{
					System.out.println("[DB4O] ERROR: la persona no existe en la BD");
				}
			}
			catch(Exception e)
			{
				System.out.println("[DB4O] ERROR: No se pudo eliminar la persona");
			}
		}
	}
	public void deleteAll()
	{
		if(open)
		{
			try
			{
				Query query =DB.query();
				query.constrain(Persona.class);
				ObjectSet resultado=query.execute();
				
				while(resultado.hasNext())
				{
					Persona p=(Persona)resultado.next();
					DB.delete(p);
					System.out.println("[DB4O] Persona eliminada correctamente");
				}
				
			}
			catch(Exception e)
			{
				System.out.println("[DB4O] ERROR: No se pudo eliminar la persona");
			}
		}
	}

}
