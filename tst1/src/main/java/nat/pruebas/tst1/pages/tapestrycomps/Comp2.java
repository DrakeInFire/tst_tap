package nat.pruebas.tst1.pages.tapestrycomps;

import java.util.List;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.internal.services.StringValueEncoder;

import nat.pruebas.tst1.Data.SpecialHandling;
import nat.pruebas.tst1.pages.Index;

public class Comp2 {
	
@Property
private final StringValueEncoder stringValueEncoder=new StringValueEncoder();

@Property
@Persist(PersistenceConstants.FLASH)
private List<String> checklistSelectedValues;

@Property
private final String[] STATIONERY = {"Pens","Pencils","Paper"};  

@InjectPage
private Index index;


    @Log
    public Object onSuccess()
    {
    	return index;
    }
    
    
}
