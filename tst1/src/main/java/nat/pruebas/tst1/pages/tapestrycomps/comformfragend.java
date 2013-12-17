package nat.pruebas.tst1.pages.tapestrycomps;

import java.util.ArrayList;
import java.util.List;

import nat.pruebas.tst1.Data.Persona;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class comformfragend {
	
	@Persist
	@Property
	private List<Persona> personas;
	
	void setUp(Persona p1,Persona p2){
		personas=new ArrayList<Persona>();
		personas.add(p1);
		personas.add(p2);
	}

}
