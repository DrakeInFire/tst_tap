package nat.pruebas.tst1.pages.tapestrycomps;

import java.util.Date;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class CompDate {
	@Property
	@Persist(PersistenceConstants.FLASH)
    private Date dateValue;
	@Property
	private String dateInFormatStr = "dd/MM/yyyy";
	@Property
	private String datetimeOutFormatStr = "yyyy-MM-dd HH:mm:ss z";
}
