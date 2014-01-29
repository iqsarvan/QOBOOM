//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> [ <INNER> ]
 * f1 -> <JOIN>
 * f2 -> FromListExpression()
 */
public class InnerJoinSpec implements Node {
   public NodeOptional f0;
   public NodeToken f1;
   public FromListExpression f2;

   public InnerJoinSpec(NodeOptional n0, NodeToken n1, FromListExpression n2) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
   }

   public InnerJoinSpec(NodeOptional n0, FromListExpression n1) {
      f0 = n0;
      f1 = new NodeToken("join");
      f2 = n1;
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

