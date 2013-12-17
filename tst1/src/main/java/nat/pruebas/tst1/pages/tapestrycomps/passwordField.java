package nat.pruebas.tst1.pages.tapestrycomps;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class passwordField {
	
   @Property
   @Persist(PersistenceConstants.FLASH)
   private String passwordValue;
   
   
	
}
