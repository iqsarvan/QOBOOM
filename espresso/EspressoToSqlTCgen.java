package espresso;

import java.util.*;
import java.io.*;

public class EspressoToSqlTCgen {

	static String[] variables0, variables1;
	static String attr[] = { "K500K" , "K250K" , "K100K" ,"K40K" ,"K10K" ,"K1K" ,
			"K100",	"K25" ,	"K10" ,	"K5" ,	"K2" };
	static int attrCardinality[] = { 500000 , 250000 , 100000 , 40000 , 10000 , 1000 ,
			100,	25 ,	10 ,	5,	2};
	static String rawFilePath, minFilePath;
	
	public static void main(String arg[]) {
		try {
			if(arg.length != 2) {
				System.out.println("Usage : java EspressoToSQL <raw-espresso-file> <min-espresso-file>");
				return;
			}
			rawFilePath = arg[0]; minFilePath = arg[1];
			System.out.println("Processing " + rawFilePath + " .....");
			espressoToSQL(rawFilePath,true);
			espressoToSQL(minFilePath,false);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void espressoToSQL(String filePath, boolean generateRandom) throws FileNotFoundException{
		int noOfQueries, noOfVariables;
		Scanner scanner = new Scanner(new File("espresso/"+filePath));
		PrintWriter writer = new PrintWriter("sql/"+ filePath + ".sql");
		String tempStr = scanner.next();
		while(!tempStr.equals(".i")) 
			tempStr = scanner.next(); //skip blank spaces and new lines at the beginning
		
		noOfVariables = scanner.nextInt();  //no of variables
		if(generateRandom) {
			Random rand = new Random();
			variables0 = new String[noOfVariables];
			variables1 = new String[noOfVariables];
			for(int i=0; i<noOfVariables; i++) {
				int attrIdx = rand.nextInt(11);
				int rhs = rand.nextInt(attrCardinality[attrIdx]);
				variables0[i] = attr[attrIdx] + "<" + rhs; 
				variables1[i] = attr[attrIdx] + ">=" + rhs;
			}	
		}
		
		tempStr = scanner.next();	
		while(!tempStr.equals(".o")) 
			tempStr = scanner.next(); //skip blank spaces and new lines
		noOfQueries = scanner.nextInt();  //no of queries	
		
		tempStr = scanner.next();
		if(tempStr.equals(".p")) { scanner.next(); tempStr = scanner.next(); } //skip pla
		
		ArrayList<ArrayList<String> > outputBuilder = new ArrayList<ArrayList<String> >();
		for(int i=0; i<noOfQueries; i++)
			outputBuilder.add(new ArrayList<String>());
				
		while(!tempStr.equals(".e")) {
			if(tempStr.contains("|")) 
				appendSQLEquivalent(outputBuilder, tempStr.substring(0, tempStr.indexOf("|")),
						tempStr.substring(tempStr.indexOf("|")+1, tempStr.length()));
			else 
				appendSQLEquivalent(outputBuilder, tempStr, scanner.next());
			
			try { tempStr = scanner.next(); }
			catch(Exception e) { break;	}
		}
		for(int i=0; i<outputBuilder.size(); i++)
			printQuery(writer, outputBuilder.get(i));
		scanner.close();
		writer.close();
	}
	private static void appendSQLEquivalent(ArrayList<ArrayList<String> > outputBuilder, String inputStr, String outputStr) {
		for(int i=0; i<outputStr.length(); i++)
			if(outputStr.charAt(i) == '1') 
				outputBuilder.get(i).add(inputStr);
	}
	private static void printQuery(PrintWriter out,ArrayList<String> outputStr) {
		try {
			out.println("select count(*) from bench where (");
			for(int i=0; i<outputStr.size(); i++) {
				String binary = outputStr.get(i);
				out.print("(");
				for(int j=0; j<binary.length(); j++) {
					if(binary.charAt(j)=='1')
						out.print(variables1[j]+" and ");
					else if(binary.charAt(j)=='0')
						out.print(variables0[j]+" and ");
					else ;
				}
				out.print(" true) or\n");
			}
			out.print("false);\n");
		}
		catch(Exception e) { e.printStackTrace();}
	}
}
