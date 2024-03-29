//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class GJVoidDepthFirst<A> implements GJVoidVisitor<A> {
   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public void visit(NodeList n, A argu) {
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
   }

   public void visit(NodeListOptional n, A argu) {
      if ( n.present() ) {
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,argu);
            _count++;
         }
      }
   }

   public void visit(NodeOptional n, A argu) {
      if ( n.present() )
         n.node.accept(this,argu);
   }

   public void visit(NodeSequence n, A argu) {
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
   }

   public void visit(NodeToken n, A argu) {}

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> ( SqlStatement() )+
    * f1 -> <EOF>
    */
   public void visit(SqlScript n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> SqlOperator()
    * f1 -> <SEMICOLON>
    */
   public void visit(SqlStatement n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> Query()
    */
   public void visit(SqlOperator n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <SELECT>
    * f1 -> [ <ALL> | <DISTINCT> ]
    * f2 -> ( <ASTERISK> | SelectList() )
    * f3 -> [ FromList() [ WhereClause() ] [ GroupByClause() ] [ OrderByClause() ] [ LimitClause() ] ]
    */
   public void visit(Query n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
   }

   /**
    * f0 -> SelectExpression()
    * f1 -> ( <COMMA> SelectExpression() )*
    */
   public void visit(SelectList n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> ( RelationName() <PERIOD> <ASTERISK> | SchemaName() <PERIOD> RelationName() <PERIOD> <ASTERISK> | ValueExpression() [ [ <AS> ] Alias() ] )
    */
   public void visit(SelectExpression n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <FROM>
    * f1 -> FromListExpression()
    * f2 -> ( <COMMA> FromListExpression() )*
    */
   public void visit(FromList n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> Relation()
    * f1 -> ( JoinClause() )*
    */
   public void visit(FromListExpression n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> SingleRelation()
    *       | NamedSubquery()
    */
   public void visit(Relation n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> Subquery()
    * f1 -> [ [ <AS> ] Alias() ]
    */
   public void visit(NamedSubquery n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> <L_PAREN>
    * f1 -> Query()
    * f2 -> <R_PAREN>
    */
   public void visit(Subquery n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> RelationSpec()
    * f1 -> [ [ <AS> ] Alias() ]
    */
   public void visit(SingleRelation n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> [ SchemaName() <PERIOD> ]
    * f1 -> RelationName()
    */
   public void visit(RelationSpec n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public void visit(SchemaName n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public void visit(RelationName n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> InnerJoinSpec() OnClause()
    *       | OuterJoinSpec() OnClause()
    *       | CrossJoinSpec()
    */
   public void visit(JoinClause n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> [ <INNER> ]
    * f1 -> <JOIN>
    * f2 -> FromListExpression()
    */
   public void visit(InnerJoinSpec n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> ( <LEFT> | <RIGHT> )
    * f1 -> [ <OUTER> ]
    * f2 -> <JOIN>
    * f3 -> FromListExpression()
    */
   public void visit(OuterJoinSpec n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
   }

   /**
    * f0 -> <CROSS>
    * f1 -> <JOIN>
    * f2 -> FromListExpression()
    */
   public void visit(CrossJoinSpec n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> <ON>
    * f1 -> SearchCondition()
    */
   public void visit(OnClause n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> <WHERE>
    * f1 -> SearchCondition()
    */
   public void visit(WhereClause n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> <HAVING>
    * f1 -> SearchCondition()
    */
   public void visit(HavingClause n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> <GROUP>
    * f1 -> <BY>
    * f2 -> GroupByList()
    */
   public void visit(GroupByClause n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> GroupByExpression()
    * f1 -> ( <COMMA> GroupByExpression() )*
    */
   public void visit(GroupByList n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> ValueExpression()
    */
   public void visit(GroupByExpression n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <ORDER>
    * f1 -> <BY>
    * f2 -> OrderByList()
    */
   public void visit(OrderByClause n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> OrderByExpression()
    * f1 -> ( <COMMA> OrderByExpression() )*
    */
   public void visit(OrderByList n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> ValueExpression()
    * f1 -> [ <ASC> | <DESC> ]
    */
   public void visit(OrderByExpression n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> <LIMIT>
    * f1 -> LimitOffset()
    * f2 -> [ <COMMA> LimitCount() ]
    */
   public void visit(LimitClause n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> ValueExpression()
    */
   public void visit(LimitOffset n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> ValueExpression()
    */
   public void visit(LimitCount n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> BinaryOperator()
    *       | ParenthesizedExpression()
    */
   public void visit(ValueExpression n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> OperandExpression()
    * f1 -> ( ArithmeticalOperator() | EqualityTest() | LogicalTest() | NullTest() | BetweenTest() )*
    */
   public void visit(BinaryOperator n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> ( <PLUS> | <MINUS> | <ASTERISK> | <SLASH> | <PERCENT> | <DIV> | <MOD> )
    * f1 -> OperandExpression()
    */
   public void visit(ArithmeticalOperator n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> ( <LT> | <GT> | <EQ> | <LTE> | <GTE> | <NE> )
    * f1 -> OperandExpression()
    */
   public void visit(EqualityTest n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> ( <LIKE> | <AND> | <OR> | <XOR> )
    * f1 -> OperandExpression()
    */
   public void visit(LogicalTest n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> <IS>
    * f1 -> [ <NOT> ]
    * f2 -> <NULL>
    */
   public void visit(NullTest n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> <BETWEEN>
    * f1 -> OperandExpression()
    * f2 -> <AND>
    * f3 -> OperandExpression()
    */
   public void visit(BetweenTest n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
   }

   /**
    * f0 -> <L_PAREN>
    * f1 -> ValueExpression()
    * f2 -> <R_PAREN>
    */
   public void visit(ParenthesizedExpression n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> UnaryOperator()
    *       | UnaryOperand()
    */
   public void visit(OperandExpression n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> ( <EXCLAMATION> | <NOT> | <TILDE> | <MINUS> )
    * f1 -> OperandExpression()
    */
   public void visit(UnaryOperator n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> FunctionCall()
    *       | Subquery()
    *       | Literal()
    *       | ColumnExpression()
    */
   public void visit(UnaryOperand n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> OrdinaryFunctionCall()
    *       | AggregateFunctionCall()
    *       | BuiltInFunctionCall()
    */
   public void visit(FunctionCall n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> FunctionName()
    * f1 -> <L_PAREN>
    * f2 -> ArgList()
    * f3 -> <R_PAREN>
    */
   public void visit(OrdinaryFunctionCall n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public void visit(FunctionName n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> Argument()
    * f1 -> ( <COMMA> Argument() )*
    */
   public void visit(ArgList n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> ( <MIN> | <MAX> | <COUNT> | <AVG> | <SUM> | <AGGREGATE> FunctionName() )
    * f1 -> <L_PAREN>
    * f2 -> [ <ALL> | <DISTINCT> ]
    * f3 -> ( <ASTERISK> | Argument() )
    * f4 -> <R_PAREN>
    */
   public void visit(AggregateFunctionCall n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
   }

   /**
    * f0 -> CastCall()
    *       | ConvertCall()
    *       | ExistsCall()
    *       | InCall()
    *       | CaseCall()
    */
   public void visit(BuiltInFunctionCall n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <CAST>
    * f1 -> <L_PAREN>
    * f2 -> Argument()
    * f3 -> <AS>
    * f4 -> Type()
    * f5 -> <R_PAREN>
    */
   public void visit(CastCall n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
   }

   /**
    * f0 -> <CONVERT>
    * f1 -> <L_PAREN>
    * f2 -> Argument()
    * f3 -> <R_PAREN>
    * f4 -> <USING>
    * f5 -> EncodingName()
    */
   public void visit(ConvertCall n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
   }

   /**
    * f0 -> <EXISTS>
    * f1 -> Subquery()
    */
   public void visit(ExistsCall n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> <IN>
    * f1 -> ( Subquery() | <L_PAREN> ArgList() <R_PAREN> )
    */
   public void visit(InCall n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> <CASE>
    * f1 -> ( SimpleCaseExpression() | SearchedCaseExpression() )
    * f2 -> <END>
    */
   public void visit(CaseCall n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> ValueExpression()
    * f1 -> SearchedCaseExpression()
    */
   public void visit(SimpleCaseExpression n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> WhenClauses()
    * f1 -> <ELSE>
    * f2 -> DefaultExpression()
    */
   public void visit(SearchedCaseExpression n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> ( WhenClause() )+
    */
   public void visit(WhenClauses n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <WHEN>
    * f1 -> WhenTest()
    * f2 -> <THEN>
    * f3 -> WhenOptionExpression()
    */
   public void visit(WhenClause n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
   }

   /**
    * f0 -> ValueExpression()
    */
   public void visit(WhenTest n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> ValueExpression()
    */
   public void visit(WhenOptionExpression n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> ValueExpression()
    */
   public void visit(DefaultExpression n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public void visit(EncodingName n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> ValueExpression()
    */
   public void visit(Argument n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> FullyQualifiedColumnName()
    *       | QualifiedColumnName()
    *       | UnqualifiedColumnName()
    */
   public void visit(ColumnExpression n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> SchemaName()
    * f1 -> <PERIOD>
    * f2 -> RelationName()
    * f3 -> <PERIOD>
    * f4 -> ColumnName()
    */
   public void visit(FullyQualifiedColumnName n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
   }

   /**
    * f0 -> RelationNameOrAlias()
    * f1 -> <PERIOD>
    * f2 -> ColumnName()
    */
   public void visit(QualifiedColumnName n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public void visit(RelationNameOrAlias n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> ColumnName()
    */
   public void visit(UnqualifiedColumnName n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public void visit(ColumnName n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public void visit(Alias n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> ValueExpression()
    */
   public void visit(SearchCondition n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> NumericOrStringLiteral()
    *       | BooleanLiteral()
    *       | NullLiteral()
    */
   public void visit(Literal n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <INTEGER_LITERAL>
    *       | <FLOATING_POINT_LITERAL>
    *       | <STRING_LITERAL>
    */
   public void visit(NumericOrStringLiteral n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <TRUE>
    *       | <FALSE>
    */
   public void visit(BooleanLiteral n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <NULL>
    */
   public void visit(NullLiteral n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> NumericType()
    *       | StringType()
    *       | BooleanType()
    *       | DatetimeType()
    */
   public void visit(Type n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <TINYINT>
    *       | <SMALLINT>
    *       | <INT>
    *       | <INTEGER>
    *       | <BIGINT>
    */
   public void visit(NumericType n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <CHAR>
    *       | <VARCHAR>
    */
   public void visit(StringType n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <BOOLEAN>
    */
   public void visit(BooleanType n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <DATE>
    *       | <TIME>
    *       | <DATETIME>
    */
   public void visit(DatetimeType n, A argu) {
      n.f0.accept(this, argu);
   }

}
