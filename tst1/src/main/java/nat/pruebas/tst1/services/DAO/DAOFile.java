package nat.pruebas.tst1.services.DAO;

import java.io.*;
import java.util.List;
import java.util.LinkedList;

import nat.pruebas.tst1.Data.Persona;


public class DAOFile {
	
	private File file=null;
	private FileReader fr=null;
	private BufferedReader br=null;
	
	public List<Persona> getUserFromFile(String path) {

		List<Persona> lista=new LinkedList<Persona>();
		try{
			file=new File(path);
			fr=new FileReader(file);
			br=new BufferedReader(fr);
			
			String linea;
			
			while((linea=br.readLine())!=null)
			{
				if(linea.equals(""))
				{
					break;
				}
				System.out.println(linea);
				String sub[] =linea.split("\t");
				Persona p=new Persona();
				int i=0;
				for(String temp:sub)
				{
					if(i==0)
					{
						p.setNombre(temp);
					}
					if(i==1)
					{
						p.setApellido(temp);
					}
					if(i==2)
					{
						p.setDni(temp);
					}
					i++;
					
					
				}
				lista.add(p);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(fr!=null){fr.close();}
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
			}
		}
		return lista;
	}


}
