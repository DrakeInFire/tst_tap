package nat.pruebas.tst1.pages.tapestrycomps;



import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
//CHECKBOX
public class Comp1 {
	
	@Property
	@Persist
	private boolean show;
	
	
	
	public String getMensaje(){
		/*
		if(show==true)
		{
			return("Casilla marcada");
		}
		else
		{
			return ("Casilla vacia");
		}*/
		return show ? "Casilla marcada" : "Casilla vacia";
	}

}
