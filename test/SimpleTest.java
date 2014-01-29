package test;

import java.util.Vector;

import parser.*;
import syntaxtree.*;
import visitor.*;

public class SimpleTest {
   public static void main(String [] args) {
      try {
         Node root = new SQLParser(System.in).SqlScript();
         System.out.println("Program parsed successfully");
         
         SqlScript s = (SqlScript)root;
         Vector<Node> n= s.f0.nodes;
         System.out.println(n.size());
         
         root.accept(new TreePrinter());
         System.out.println();
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
} 



