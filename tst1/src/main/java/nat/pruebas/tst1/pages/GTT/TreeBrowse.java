package nat.pruebas.tst1.pages.GTT;

import nat.pruebas.tst1.Data.Stuff;
import nat.pruebas.tst1.Data.StuffTreemodelAdapter;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.corelib.components.Tree;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.tree.DefaultTreeModel;
import org.apache.tapestry5.tree.TreeModel;

import nat.pruebas.tst1.pages.Index;

public class TreeBrowse {
	
	private TreeModel<Stuff> stuffModel;
	
	@InjectComponent
	private Tree tree;
	
	@Inject
	private ComponentResources componentResources;
	
	private boolean refresh=false;
	
	void onClearExpansions(){
		tree.clearExpansions();
	}
	
	public TreeModel<Stuff> getStuffModel()
	{
		if(stuffModel==null)
		{
			ValueEncoder<Stuff> stuffEncoder =new ValueEncoder<Stuff>()
			{				
				public String toClient(Stuff stuff){
					return stuff.uuid;
				}
				
				public Stuff toValue(String uuid){
					return Stuff.ROOT.searchSubTree(uuid);
				}
			};
			stuffModel = new DefaultTreeModel<Stuff>(stuffEncoder,new StuffTreemodelAdapter(),Stuff.ROOT.children);
		}
		return stuffModel;
	}
	
	Object onHome(){
		componentResources.discardPersistentFieldChanges();
		return Index.class;
	}
	Object onRefresh(){
		refresh=true;
		System.out.println("onRefresh");
		return TreeBrowse.class;
		
	}
	void cleanupRender(){
		if(!refresh)
		{
			componentResources.discardPersistentFieldChanges();
		}
		System.out.println("cleanupRender");
	}

}
