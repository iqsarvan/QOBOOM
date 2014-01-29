//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> <BETWEEN>
 * f1 -> OperandExpression()
 * f2 -> <AND>
 * f3 -> OperandExpression()
 */
public class BetweenTest implements Node {
   public NodeToken f0;
   public OperandExpression f1;
   public NodeToken f2;
   public OperandExpression f3;

   public BetweenTest(NodeToken n0, OperandExpression n1, NodeToken n2, OperandExpression n3) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
   }

   public BetweenTest(OperandExpression n0, OperandExpression n1) {
      f0 = new NodeToken("between");
      f1 = n0;
      f2 = new NodeToken("and");
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
