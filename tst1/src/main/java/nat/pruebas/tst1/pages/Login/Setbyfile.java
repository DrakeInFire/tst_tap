package nat.pruebas.tst1.pages.Login;

import org.apache.tapestry5.annotations.SessionState;

import nat.pruebas.tst1.Data.Sesion;

import java.io.File;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.upload.services.UploadedFile;

public class Setbyfile {
	
	
	@SessionState
	Sesion sesion;
	@Property
	private UploadedFile file;
	
	Object onSuccess()
	{
		String path=System.getProperty("user.home")+System.getProperty("file.separator")+
				"serverfiles"+System.getProperty("file.separator")+"users.txt";
		File copied=new File(path);
		file.write(copied);
		sesion.setUploadedFileUsers(true);
		return ViewUsersFile.class;
	}
	
	Object onActivate()
	{
		if(sesion.isLoged())
		{
			if(sesion.isUploadedFileUsers())
			{
				return ViewUsersFile.class;
			}
			return null;
		}
		else
		{
			return Log.class;
		}
	}

}
