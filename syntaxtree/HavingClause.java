//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> <HAVING>
 * f1 -> SearchCondition()
 */
public class HavingClause implements Node {
   public NodeToken f0;
   public SearchCondition f1;

   public HavingClause(NodeToken n0, SearchCondition n1) {
      f0 = n0;
      f1 = n1;
   }

   public HavingClause(SearchCondition n0) {
      f0 = new NodeToken("having");
      f1 = n0;
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

