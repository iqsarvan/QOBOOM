package visitor;

import syntaxtree.NodeToken;

public class TreePrinter extends DepthFirstVisitor{
	   public void visit(NodeToken n) { 
		if(n.tokenImage.equals(";"))
	  		System.out.print(n.tokenImage + "\n");
		else
			System.out.print(n.tokenImage + " ");
	   }
}
