package nat.pruebas.tst1.components;

import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.annotations.Parameter;

public class Count {

	@Parameter(value="1")
	private int start;
	
	@Parameter(required = true)
	private int end;
	
	@Parameter
	private int result;
	
	@SetupRender
	void initializeValues(){
		result=start;
	}
	
	@AfterRender
	boolean next(){
		int newResult =result+1;
		
		if(newResult <=end)
		{
			result=newResult;
			return false;
		}
		return true;
	}
}

