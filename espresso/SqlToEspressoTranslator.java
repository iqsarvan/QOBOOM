package espresso;

import syntaxtree.*;
import visitor.*;

public class SqlToEspressoTranslator<R,A> extends GJDepthFirst<R, A>{
		SqlStatementVector sqlStmtVector;

	   /**
	    * f0 -> ( SqlStatement() )+
	    * f1 -> <EOF>
	    */
	   public R visit(SqlScript n, A argu) {
	      R _ret=null;
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      
	      sqlStmtVector = new SqlStatementVector(n.f0);
	      return _ret;
	   }
	   
	   /**
	    * f0 -> <WHERE>
	    * f1 -> SearchCondition()
	    */
	   public R visit(WhereClause n, A argu) {
	      R _ret=null;
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      return _ret;
	   }
}
