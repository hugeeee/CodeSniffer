package codeCritic;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.Vector;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import Definitions.*;

/**
 * 
 * @author Computard
 * This class builds the reports for code smells detected.
 *
 */
public class Report {
	Desktop desktop = null;

	// bloated
	private static Vector<MethodDefinition> bloatedMethods = new Vector<MethodDefinition>();
	private static Vector<ClassDefinition> bloatedClasses = new Vector<ClassDefinition>();
	
	// excessivelyComment
	private static Vector<MethodDefinition> excessivelyCommentedMethods = new Vector<MethodDefinition>();
	private static Vector<ClassDefinition> excessivelyCommentedClasses = new Vector<ClassDefinition>();

	// nested
	private static Vector<MethodDefinition> deepNestedMethods = new Vector<MethodDefinition>();
	private static Vector<ClassDefinition> deepNestedClasses = new Vector<ClassDefinition>();
	
	private static Vector<ClassDefinition> godClasses = new Vector<ClassDefinition>();
	// first entry is a god. second is the next hardest working class.
	
	//lazy
	private static Vector<ClassDefinition> lazyClasses = new Vector<ClassDefinition>();
	
	// initial reports for smells
	private String reportTitle = "CODESNIFFER REPORT";
	private String bloaterReport = "";
	private String excessiveCommentingReport = "";
	private String deepNestingReport = "";
	private String lazyReport = "";
	private String godClassReport = "";

	// Fonts
	Font header = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLDITALIC);

	/**
	 * This adds to this lists of smelly lazy classes
	 * @param def = the class to add to lazy class
	 */
	public static void addToLazyClasses(ClassDefinition def){
		lazyClasses.add(def);
	}
	/**
	 * This adds to the list of bloated methods
	 * @param def = the method to add to bloated methods list
	 */
	public static void addToBloatedMethods(MethodDefinition def){
		bloatedMethods.add(def);
	}
	/**
	 * adds bloated class detected to list of bloated classes
	 * @param def = bloated class detected
	 */
	public static void addToBloatedClasses(ClassDefinition def){
		bloatedClasses.add(def);
	}
	/**
	 * adds excessively commented methods detected to smelly list
	 * @param def = excessively commented method
	 */
	public static void addToCommentedMethods(MethodDefinition def){
		excessivelyCommentedMethods.add(def);
	}
	/**
	 * adds excessively commented class detected to smelly list
	 * @param def = detected smelly class
	 */
	public static void addToCommentedClasses(ClassDefinition def){
		excessivelyCommentedClasses.add(def);
	}
	/**
	 * adds deep nested class to detected smelly list
	 * @param def = detected deep nested class
	 */
	public static void addToDeepNestedClasses(ClassDefinition def){
		deepNestedClasses.add(def);
	}
	/**
	 * adds deep nested method to detected smelly list
	 * @param def = detected deep nested method
	 */
	public static void addToDeepNestedMethods(MethodDefinition def){
		deepNestedMethods.add(def);
	}
	/**
	 * adds to the God class
	 * @param c = God class that has been detected
	 */
	public static void addGodClass(ClassDefinition c){
		godClasses.add(c);
	}

	/**
	 * build the bloater report
	 */
	public void buildBloaterReport(){

		bloaterReport += "BLOATERS\n";
		
		if(bloatedClasses.size() == 0 && bloatedMethods.size() == 0){
			bloaterReport += "\nNo bloated code smells were detected.\n";
		}else{
			bloaterReport += "\nDESCRIPTION: A bloater code smell is detected when a either a class or method has" +
			"\n become too big it becomes difficult to handle. " +
			"It also includes a method or class constructor that takes too many parameters.\n";
		
		bloaterReport += "\nBLOATED CLASSES:	\n";

		if(bloatedClasses.size() != 0){
			for(ClassDefinition temp :bloatedClasses){
				bloaterReport += "The class " + temp.getClassName() + " is a bloated class. It has " +
				temp.getClassLength()+" lines.\n";
			}	
		}else{bloaterReport += "There are no bloated classes.\n";}

		bloaterReport += "\nBLOATED METHODS:";

		if(bloatedMethods.size() != 0){
			for(MethodDefinition tempMethodDefinition :bloatedMethods){
				bloaterReport += "In the class " + tempMethodDefinition.getBelongsToClassName() +
				" there is a SMELLY method called: " + tempMethodDefinition.getMethodName() +
				", it has " + tempMethodDefinition.getMethodLength() + " lines. \n";
			}
		}else{bloaterReport += "\nThere are no bloated methods in this project.\n";}
		
		bloaterReport += "\n RECOMMENDATION TO IMPROVE: You may need to consider refactoring these reported classes and "
			+"methods to make them more manageable and Object Orientated." +
			" Try finding a part of the code that is used very often and seperating into its own method or class.\n" +
			"\n\n---------------------------------------------------------------------\n\n";
		}

	}
	
	/**
	 * Lazy class report builder.
	 */
	public void buildLazyReport(){
		lazyReport += "\nLAZY CLASSES\n";
		
		if(lazyClasses.size() != 0){
			for(ClassDefinition temp :lazyClasses){
				lazyReport += "The class " + temp.getClassName() + " is a Lazy Class.\n";
			}	
		}else{lazyReport += "There are no lazy classes in this project.\n";}

		lazyReport += "\n RECOMMENDATION TO IMPROVE: The class is very short with very few methods which could be put into another class to make the project simpler."
			+"\n\n---------------------------------------------------------------------\n\n";
	}

	/**
	 * This method builds a report for reported deep nested classes and methods.
	 */
	public void buildDeepNesting(){
		deepNestingReport += "\nDEEP NESTING\n";
		
		if(deepNestedClasses.size() == 0 && deepNestedMethods.size() == 0){
			deepNestingReport += "\nNo bloated code smells were detected.\n";
		}else{
			deepNestingReport += "\nDESCRIPTION: Deep nesting is when there are too many nested loops in a class or method. " +
					"This is a sign of duplicate code\n";
		}
		
		deepNestingReport += "\nDEEP NESTED CLASSES:";
		
		if(deepNestedClasses.size() != 0){
			for(ClassDefinition temp :deepNestedClasses){
				deepNestingReport += "The class " + temp.getClassName() + " has deep nesting. It has" +
						" a nesting level of" + temp.getClassNestingDepth() +".\n";
			}	
		}else{deepNestingReport += "There are no deep nested classes in this project.\n";}

		deepNestingReport += "\nDEEP NESTED METHODS:";

		if(deepNestedClasses.size() != 0){
			for(MethodDefinition tempMethodDefinition :deepNestedMethods){
				deepNestingReport += "In the class " + tempMethodDefinition.getBelongsToClassName() +
				" there is a DEEP NESTED method called: " + tempMethodDefinition.getMethodName()+"." +
					" It has a nesting level of "+tempMethodDefinition.getMethodNestingDepth() +".\n";
			}
		}else{deepNestingReport += "\nThere are no methods in this project that are deep nested.\n";}
		deepNestingReport += "\n RECOMMENDATION TO IMPROVE: You may need to consider refactoring making methods of nested code their own method."
			+"\n\n---------------------------------------------------------------------\n\n";
	}
	
	/**
	 * This builds the report on excessively commented methods and classes.
	 */
	public void buildExcessiveCommentingReport(){
		excessiveCommentingReport += "EXCESSIVELY COMMENTED\n";
		
		if(excessivelyCommentedClasses.size() == 0 && excessivelyCommentedMethods.size() == 0){
			excessiveCommentingReport += "\nNo excessive commenting code smells were detected.\n";
		}else{
			excessiveCommentingReport += "\nDESCRIPTION: An excessively commented class is when there is a " +
					"bad ratio of comments to lines of code.\n";
		}
		
		excessiveCommentingReport += "\nEXCESSIVELY COMMENTED CLASSES:	\n";
		
		if(excessivelyCommentedClasses.size() != 0){
			for(ClassDefinition temp :excessivelyCommentedClasses){
				excessiveCommentingReport += "The class " + temp.getClassName() + " is excessively commented.\n";
			}	
		}else{excessiveCommentingReport += "There are no excessively commented classes.\n";}

		excessiveCommentingReport += "\nEXCESSIVELY COMMENTED METHODS:";

		if(excessivelyCommentedMethods.size() != 0){
			for(MethodDefinition tempMethodDefinition :excessivelyCommentedMethods){
				excessiveCommentingReport += "In the class " + tempMethodDefinition.getBelongsToClassName() +
				" there is a EXCESSIVELY COMMENTED method called: " + tempMethodDefinition.getMethodName() + ".\n";
			}
		}else{excessiveCommentingReport += "\nThere are no EXCESSIVELY COMMENTED methods in this project.\n";}
		excessiveCommentingReport += "\n RECOMMENDATION TO IMPROVE: You may need to consider using less comments."
			+"\n\n---------------------------------------------------------------------\n\n";
	}
	
	/**
	 * This method builds the report for the God class.
	 */
	public void buildGodClassReport(){
		godClassReport += "GOD CLASS REPORT\n";
		godClassReport += "A GOD CLASS is a class that has a disproportiionate amount of work to any other class in the project. \n";
		if(godClasses.size() == 0){
			godClassReport += "\nThere is no God class in this project. \n";
		}else{godClassReport += "\nThere was a God class detected in this project. It is the " +
				godClasses.get(0).getClassName() + " class. It had a disproportionate amount of work to" +
						" other classes in the project. The closest class " + godClasses.get(1).getClassName()
						+" had " + (float)(godClasses.get(0).getClassMethods().size()/godClasses.get(1).getClassMethods().size())
						+ " the amount of work the God class had.\n\n" +
								"SUGGESTION: A suggestion to improve would be to spread the work around within classes."+
								"\n\n---------------------------------------------------------------------\n\n";}
	}

	/**
	 * This method builds a pdf report of all the detected smells and opens the pdf.
	 */
	public void generateCodeSnifferReport(){
		try{
			System.out.println("IN WRITING THE REPORT NOW.");

			File tempFile = File.createTempFile("CodeSnifferReport", ".pdf");
			OutputStream file = new FileOutputStream(tempFile);
			Document document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			Image logo = Image.getInstance("computardlogo.jpg");
			document.add(logo);
			logo.setAlignment(Element.ALIGN_CENTER);
			logo.scaleAbsolute(100, 40);
			//Use addParagraph to fill the contents of the report.
			Paragraph head = new Paragraph(reportTitle, header);
			addEmptyLine(head, 2);
			head.setAlignment(Element.ALIGN_CENTER);
			document.add(head);
			addEmptyLine(head, 2);

			// in your instance you will need to create the build report. So if the boolean says report bloater you can call the method and generate report.
			Paragraph bloatedSmellParagraph = new Paragraph(bloaterReport);
			Paragraph deepNestingParagraph = new Paragraph(deepNestingReport);
			Paragraph lazyParagraph = new Paragraph(lazyReport);
			Paragraph excessiveCommentPara = new Paragraph(excessiveCommentingReport);
			Paragraph godClassParagraph = new Paragraph(godClassReport);
			
			// builds pdf contents.
			document.add(bloatedSmellParagraph);
	//		Paragraph seperate = new Paragraph(seperator);
			document.add(deepNestingParagraph);
			document.add(excessiveCommentPara);
			document.add(lazyParagraph);
			document.add(godClassParagraph);
			// carry on from here building report.

			document.close();
			file.close();
			
			if(Desktop.isDesktopSupported()){
				desktop = Desktop.getDesktop();
			}
			if(desktop.isSupported(Desktop.Action.OPEN)){
				String path = tempFile.getPath();
				desktop.open(new File(path));
			}
			System.out.println("Done");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * It is possible to build a HTML version of the report on your project. However we decided against
	 * this feature.
	 */
	public void generateHTMLReport(){
		try{
			File htmlFile = File.createTempFile("HTML", ".html");

			BufferedWriter htmlOut = new BufferedWriter(new FileWriter(htmlFile));

			String htmlString = "";

			htmlString +=  "<html>\n";

			htmlString +=  "<head>\n";
			htmlString +=  "<title> COMPUTARD </title>\n";
			htmlString +=  "</head>\n";
			htmlString +=  "<body>\n";
			
			htmlString += bloaterReport;
			htmlString += deepNestingReport;
			htmlString += excessiveCommentingReport;
			
			htmlString += "</body>\n";
			htmlString += "</html>\n";
			System.out.println(htmlString);
			htmlOut.write(htmlString);
			htmlOut.close();
			
			Desktop desktop = null;
			
			if (desktop.isDesktopSupported()){
				desktop = Desktop.getDesktop();
			}
			
			if(desktop.isSupported(Desktop.Action.BROWSE)){
				//String tempHtml = htmlOut.toString();
				desktop.open(htmlFile);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
	
	public void clearDetectedSmells(){
		bloatedClasses.clear();
		bloatedMethods.clear();
		godClasses.clear();
		excessivelyCommentedClasses.clear();
		excessivelyCommentedMethods.clear();
		lazyClasses.clear();
		deepNestedClasses.clear();
		deepNestedMethods.clear();
	}

}