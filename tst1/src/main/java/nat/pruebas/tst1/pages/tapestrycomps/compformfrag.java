package nat.pruebas.tst1.pages.tapestrycomps;

import nat.pruebas.tst1.Data.Persona;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;

import nat.pruebas.tst1.pages.Index;;

public class compformfrag {
	
	@Property
	@Persist
	private Persona p1;
	
	@Property
	@Persist
	private Persona p2;
	
	@Property
	@Persist
	private boolean show1;
	
	@Property
	@Persist
	private boolean show2;
	
	@InjectPage
	private Index index;
	@InjectPage
	private comformfragend comp;
	
	@SetupRender
	void initializePage()
	{
		if(show1==false)
		{
			if(show2==false)
				show1=true;
		}
		
	}
	
	
	Object onSuccessFromPersons(){
		if(show1)
		{
			if(show2==false)
			{
				System.out.println("show1");
				show1=false;
				show2=true;
				return null;
			}
		}
		if(show2)
		{
			if(show1==false)
			{
				System.out.println("show2");
				show1=true;
				return null;
			}
		}
		if(show1)
		{
			if(show2)
			{
				System.out.println("falses");
				show1=false;
				show2=false;
			}
		}
		comp.setUp(p1, p2);
		return comp;
	}

}
