package nat.pruebas.tst1.services.DAO;

import java.util.List;



public interface  DAOPI <T>{
	
	public void Open();
	
	public void Close();
		
	 public void Store (T t);
	 
	public List<T> getAll();


	//public T getBy(String field,String value);

	


}
