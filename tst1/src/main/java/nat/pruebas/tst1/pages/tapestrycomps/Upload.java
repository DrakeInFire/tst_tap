package nat.pruebas.tst1.pages.tapestrycomps;

import java.io.File;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.upload.services.UploadedFile;
public class Upload {
	
	@Property
	private  UploadedFile file;
	
	public void onSuccess()
	{
		File copied=new File("/home/mario/Documents/"+ file.getFileName());
		file.write(copied);
		
	}

}
