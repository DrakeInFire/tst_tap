package nat.pruebas.tst1.services.DAO;

import java.util.ArrayList;
import java.util.List;

import nat.pruebas.tst1.Data.Persona;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public interface DAOPersonaInterface {
	
	public void Open();
	
	public void Close();
		
	 public void Store (Persona persona);
	 
	public List<Persona> getAll();
/*	
	private List<Persona> ObtenerLista(ObjectSet<Persona> resultado);
	
	private Persona ObtenerUnico(ObjectSet<Persona> resultado);
*/
	public Persona getByDni(String dni);

	


}
