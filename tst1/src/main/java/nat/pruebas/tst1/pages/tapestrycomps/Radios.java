package nat.pruebas.tst1.pages.tapestrycomps;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class Radios {

	@Property
	@Persist
	private String RadioGroupValue;
	
	@Property
	@Persist(PersistenceConstants.FLASH)
	private String Radio1;
	
	@Property
	@Persist(PersistenceConstants.FLASH)
	private String Radio2;
	
	@Property
	@Persist(PersistenceConstants.FLASH)
	private String Radio3;
	
	
	
	
}
