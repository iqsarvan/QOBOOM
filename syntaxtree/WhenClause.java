//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> <WHEN>
 * f1 -> WhenTest()
 * f2 -> <THEN>
 * f3 -> WhenOptionExpression()
 */
public class WhenClause implements Node {
   public NodeToken f0;
   public WhenTest f1;
   public NodeToken f2;
   public WhenOptionExpression f3;

   public WhenClause(NodeToken n0, WhenTest n1, NodeToken n2, WhenOptionExpression n3) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
   }

   public WhenClause(WhenTest n0, WhenOptionExpression n1) {
      f0 = new NodeToken("when");
      f1 = n0;
      f2 = new NodeToken("then");
      f3 = n1;
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
