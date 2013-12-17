package nat.pruebas.tst1.Data;

import java.util.List;

import org.apache.tapestry5.tree.TreeModelAdapter;

public class StuffTreemodelAdapter implements TreeModelAdapter<Stuff> {
	
	public boolean isLeaf(Stuff stuff){
		return !hasChildren(stuff);
	}
	
	public boolean hasChildren(Stuff stuff){
		return stuff.children !=null && !stuff.children.isEmpty();
	}

	public List<Stuff> getChildren(Stuff stuff) 
	{
		return stuff.children;
	}

	public String getLabel(Stuff stuff) {
		return stuff.name;		
	}

}
