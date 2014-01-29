//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> <CAST>
 * f1 -> <L_PAREN>
 * f2 -> Argument()
 * f3 -> <AS>
 * f4 -> Type()
 * f5 -> <R_PAREN>
 */
public class CastCall implements Node {
   public NodeToken f0;
   public NodeToken f1;
   public Argument f2;
   public NodeToken f3;
   public Type f4;
   public NodeToken f5;

   public CastCall(NodeToken n0, NodeToken n1, Argument n2, NodeToken n3, Type n4, NodeToken n5) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
      f5 = n5;
   }

   public CastCall(Argument n0, Type n1) {
      f0 = new NodeToken("cast");
      f1 = new NodeToken("(");
      f2 = n0;
      f3 = new NodeToken("as");
      f4 = n1;
      f5 = new NodeToken(")");
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
