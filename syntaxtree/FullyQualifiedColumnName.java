//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> SchemaName()
 * f1 -> <PERIOD>
 * f2 -> RelationName()
 * f3 -> <PERIOD>
 * f4 -> ColumnName()
 */
public class FullyQualifiedColumnName implements Node {
   public SchemaName f0;
   public NodeToken f1;
   public RelationName f2;
   public NodeToken f3;
   public ColumnName f4;

   public FullyQualifiedColumnName(SchemaName n0, NodeToken n1, RelationName n2, NodeToken n3, ColumnName n4) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
   }

   public FullyQualifiedColumnName(SchemaName n0, RelationName n1, ColumnName n2) {
      f0 = n0;
      f1 = new NodeToken(".");
      f2 = n1;
      f3 = new NodeToken(".");
      f4 = n2;
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

