package espresso;

import java.util.Vector;
import syntaxtree.*;
import visitor.*;

public class SqlStatementVector extends NodeList{
	int size;
	Vector<SqlStatement> sqlStatmentVector;
	public SqlStatementVector() { 
		super();
	}
	public SqlStatementVector(NodeList nL) {
		size = nL.nodes.capacity();
		sqlStatmentVector = VectorCast(nL.nodes);
	}
	Vector<SqlStatement> VectorCast(Vector<Node> nV) {
		Vector<SqlStatement> retV = null;
		for(int i=0; i<nV.capacity(); i++)
			retV.add((SqlStatement) nV.get(i));
		return retV; 
	}
}