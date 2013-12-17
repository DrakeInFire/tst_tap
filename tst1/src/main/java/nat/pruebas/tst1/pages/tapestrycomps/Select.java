package nat.pruebas.tst1.pages.tapestrycomps;

import java.util.Arrays;
import java.util.List;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.BeforeRenderTemplate;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

import nat.pruebas.tst1.Data.CarMaker;

public class Select {
	
	@Inject 
	private Messages messages;
	
	@Property
	
	private CarMaker carMaker;
	
	@Property
	@Persist(PersistenceConstants.FLASH)
	private String carModel;
	
	@InjectComponent
	private Zone modelZone;
	
	@Property
	@Persist(PersistenceConstants.FLASH)
	private List<String> avalibleModels;
					     
	@InjectPage
	private Select select;
	
	public Object onValueChanged(CarMaker maker)
	{
		avalibleModels=findAvalibleModels(maker);
		
		return modelZone.getBody();
		
	}
	@Log
	public List<String>findAvalibleModels(final CarMaker maker)
	{
		switch(maker)
		{
		 case AUDI:
            return Arrays.asList("A4", "A6", "A8");
		case BMW:
            return Arrays.asList("3 Series", "5 Series", "7 Series");
         case MERCEDES:
            return Arrays.asList("C-Class", "E-Class", "S-Class");
         default:
            return Arrays.asList("none"); 
		}
	}
	@Log
	@BeforeRenderTemplate
	void fixselect()
	{
		if(avalibleModels==null)
		avalibleModels=Arrays.asList("none");
		
	}
	
	
	
	
	

}
