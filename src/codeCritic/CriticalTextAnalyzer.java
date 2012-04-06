package codeCritic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import Utils.Configurations;
import Definitions.ClassDefinition;
import Definitions.MethodDefinition;
import Definitions.VariableDefinition;

/**
 * 
 * @author Computard
 * This class reads in a file or directory of java and text files and adds classes
 * to a list along with their methods and variables.
 *
 */
public class CriticalTextAnalyzer {

	private static final String[] variableArray = {"int", "boolean", "char", "float", "double", "byte", "short", "long"};
	private Vector<String> PRIMITIVES = new Vector<String>(Arrays.asList(variableArray));	// convert the primitive array to a vector
	private int numAlphaNumeric   = 0;		// number of alphanumeric tokens in a text
	private int nestedParentheses = 0;		// depth of () nesting at any one time
	private int nestedCurlyBracklets = 0;
	private final String delims = " \\\t\n,;{}[]().-<>&^:%$@!-+/*~=";	// delimiters for splitting lines into tokens
	private boolean inString = false, inComment = false, inParamList = false;	// flags for current state 
	private String currentVarType = null;// in a variable declaration, the current variable type
	private int fileLength = 0;
	private boolean inClass = false;
	private boolean emptyLine = false;
	private boolean inMethod = false;
	private boolean simpleComment = false;

	// Made this public and static to see if I can get it working with the bloater smell. Jamie
	public static ArrayList <ClassDefinition> classes = new ArrayList<ClassDefinition>();

	private ArrayList<VariableDefinition> paramVars = new ArrayList<VariableDefinition>();
	private ArrayList<VariableDefinition> localVariables = new ArrayList<VariableDefinition>();

	private int currentClassIndex = -1;    //


	//-----------------------------------------Constructor-----------------------------------------//
	public CriticalTextAnalyzer(String file) throws IOException {
		File fileName = new File(file);
		traverseDirectory(fileName);
	}

	//-------------------------------------Getters and Setters--------------------------------------//
	public int getNumAlphaNumericTokens(){return numAlphaNumeric;}
	public int getNumberOfClasses(){return classes.size();}
	public int getFileLength(){return fileLength;}
	public ArrayList<VariableDefinition> getLocalVars(){return localVariables;}
	public ArrayList<VariableDefinition> getParamVars(){return paramVars;}
	public ArrayList<ClassDefinition> getListOfClasses(){return classes;}

	//----------------------------------Private Methods----------------------------------//
	private void traverseDirectory(File file) throws IOException{

		if (file.isDirectory()) {
			File [] filesInDirecory = file.listFiles();
			for (int i = 0; i < filesInDirecory.length; i++) {
				traverseDirectory(filesInDirecory[i]);
			}
		}else{processFile(file);}
	}

	/**
	 * Private method to process the file.
	 * @throws IOException 
	 */
	private void processFile(File file) throws IOException {
		String check = file.getCanonicalPath();
		if(check.endsWith(".txt") || check.endsWith(".java")){
		try {
			File fileName = file;
			Scanner fileScanner = new Scanner(fileName);
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				// This is where I hopefully count lines in a class. Might need to check if in comment too.
				simpleComment = false;
				processLine(line);
				if(inClass && !lineIsEmpty(line) && !inComment && !simpleComment){
					classes.get(currentClassIndex).incrementClassLength();
					//System.out.println("THIS IS THE ONE INCREMENTING:"+line);
				}
				if(inClass && inMethod && !lineIsEmpty(line) && !inComment && !simpleComment){
					int index = classes.get(currentClassIndex).getMethodIndex();
					classes.get(currentClassIndex).getClassMethods().get(index).increaseMethodLength();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		}
	}


	/**
	 *  Processing of tokens inline.
	 * @param line
	 */
	private void processLine(String line){
		String current = null, prev1 = null, prev2 = null, prev3 = null, next = null;
		StringTokenizer splitter = new StringTokenizer(line, delims, true);		

		while (splitter.hasMoreTokens()){
			next = splitter.nextToken();
			if (Character.isWhitespace(next.charAt(0))){ // Skip over spaces
				continue;
			}
			prev3   = prev2;
			prev2   = prev1;
			prev1   = current;
			current = next;

			if ("(".equals(current) && !inString && !inComment){
				nestedParentheses++;
			}
			
			if (!inComment && !inString){   // If you are not in a string or comment carry out checks
				processVariableDeclaration(current, prev1, prev2, prev3); 
				processClassDeclaration(current, prev1, prev2, prev3);
				processMethodDeclaration(prev3, prev2, prev1, current);
			}
			processNesting(current); // process the nesting needs to happen after a class is created.
			if (inComment){
				if(inClass){
					classes.get(currentClassIndex).incrementNumComments(); // increment the comments for the class
				}
				else if(inMethod){
					classes.get(currentClassIndex).getClassMethods().get(classes.get(currentClassIndex).getMethodIndex()).incrementMethodCommenting();
				}
			}	

			// If you come across ; set current variable type to null 
			if (";".equals(current) && !inComment && !inString){ 
				currentVarType = null;
			}

			// Simple comments
			if ((!inComment && "/".equals(prev1) && "/".equals(current) && (inClass || inMethod))){
				//int i = classes.indexOf(tempClass);
				simpleComment = true;
				classes.get(currentClassIndex).incrementNumComments(); // increment the comments for the class
				if(inClass && inMethod){
					classes.get(currentClassIndex).getClassMethods().get(classes.get(currentClassIndex).getMethodIndex()).incrementMethodCommenting();
				}
				return;
			}
			else{
				// Complex comments
				if (!inComment && !inString && "/".equals(prev1) && "*".equals(current)){
					inComment = true;
				}
				else{
					if (inComment && !inString && "*".equals(prev1) && "/".equals(current)){
						inComment = false;
					}
					else{
						// String check
						if (!inString && !inComment && "\"".equals(current) && !"\\".equals(prev1) && !"'".equals(prev1)){
							classes.get(currentClassIndex).incrementNumLiterals();
							inString = true;
							//System.out.println("String <"+ numLiteralStrings + ">  in " + line);
						}
						else{
							if (inString && !inComment && "\"".equals(current) && !"\\".equals(prev1)){
								inString = false;

							}
							else{
								processToken(current);
							}
						}
					}
				}
			}	
			if (")".equals(current) && !inString && !inComment && nestedParentheses > 0){
				nestedParentheses--;
			}
		}
	}


	/**
	 * This method checks if you have come across a method. If so it adds to the vector of methods.
	 * @param prev3
	 * @param prev2
	 * @param prev1
	 * @param current
	 */
	private void processMethodDeclaration(String prev3, String prev2, String prev1, String current){
		if(nestedCurlyBracklets >  0){
			if(("(".equals(current) && isAlphanumericToken(prev1)) && (classes.contains(prev2) ||
					PRIMITIVES.contains(prev2) || "void".equals(prev2)) && ("private".equals(prev3) ||
							"public".equals(prev3) || "protected".equals(prev3) || "static".equals(prev3))){
				MethodDefinition temp = new MethodDefinition();
				temp.setMethodName(prev1);
				temp.setReturnType(prev2);

				if("static".equals(prev3)){
					prev3 = "public";
				}
				inMethod = true;
				temp.setMethodPrivacy(prev3);
				temp.setBelongsToClassName(classes.get(currentClassIndex).getClassName());
				classes.get(currentClassIndex).addMethod(temp);
				int x = classes.get(currentClassIndex).getMethodIndex();
				classes.get(currentClassIndex).getClassMethods().get(x).setMethodScope(nestedCurlyBracklets-1); // Should probably be subtracting by class scope to be more accurate.
			}

		}
	}

	/**
	 * Process potential class.
	 * @param current
	 * @param prev1
	 * @param prev2
	 * @param prev3
	 */
	private void processClassDeclaration(String current, String prev1, String prev2, String prev3){
		/*
		 * If you come across class and extends create a class definition and add
		 * to the list. Update that classes name and parent class.
		 */
		if ("extends".equals(prev1) && "class".equals(prev3)){
			

			ClassDefinition temp = new ClassDefinition(prev2);
			temp.setParentName(current);
			if(classNotDefined(prev2)){
				inClass = true; // You are in a class now.
				currentClassIndex++;
				classes.add(temp);
				classes.get(currentClassIndex).setClassScope(nestedCurlyBracklets);
				System.out.println("CLASS HAS BEEN ADDED");

			}

		}

		/*
		 * If you come across class and implements update your list accordingly.
		 * Set the interface and class name.
		 */
		if ("implements".equals(prev1) && "class".equals(prev3) && isAlphanumericToken(prev2)){
			
			ClassDefinition temp = new ClassDefinition(prev2);
			ClassDefinition temp2 = new ClassDefinition(current);
			temp2.setParentName(prev2);
			temp.addInterface(temp2);
			if(classNotDefined(prev2)){
				inClass = true; // You are in a class now
				currentClassIndex++;
				classes.add(temp);
				classes.get(currentClassIndex).setClassScope(nestedCurlyBracklets);
			}
		}

		/*
		 * Make a simple class and add it to the list.
		 */
		if ("class".equals(prev2) && isAlphanumericToken(prev1)&& "{".equals(current)){
			
			ClassDefinition temp = new ClassDefinition(prev1);
			if(classNotDefined(prev1)){
				inClass = true; // You are in a class now.
				currentClassIndex++;
				classes.add(temp);
				classes.get(currentClassIndex).setClassScope(nestedCurlyBracklets);

			}
		}
	}

	/**
	 * Process potential variables.
	 * @param after
	 * @param varname
	 * @param before
	 * @param beforeThat
	 */
	private void processVariableDeclaration(String after, String varname, String before, String beforeThat){
		if (varname == null) return;

		if (currentVarType == null){// no variable declaration yet

			if (!isAlphanumericToken(before)){return;}

			if ("(".equals(beforeThat) && nestedParentheses <= 1){
				inParamList = true;
			}
			if (isPrimitiveType(before)){
				currentVarType = before;  // OK, we've got one
			}else{
				return;						// nope, this isn't it
			}
		}
		else{
			if (inParamList && isPrimitiveType(before)){
				currentVarType = before;
			}else{
				if (!",".equals(before) || nestedParentheses != 0){		// declarations are connected by commas
					return;
				}
			}
		}

		if (!isAlphanumericToken(varname)){ return;}  // not a variable

		if (")".equals(after)){ // in a parameter list?
			if (inParamList){
				inParamList = false; // now we close the list
			}
			else{
				return;				// we weren't in a parameter list
			}
			reportVariable(varname, currentVarType, true, false);

			currentVarType = null;
		}

		if (",".equals(after) && nestedParentheses == 0){ // OK, we've got a variable defined without a value
			reportVariable(varname, currentVarType, inParamList, false);
		}
		if ("=".equals(after) && nestedParentheses <= 1){ // OK, we've got a variable about to receive a value
			reportVariable(varname, currentVarType, inParamList, true);
		}
		if (";".equals(after) && nestedParentheses == 0 && !inParamList){ // OK, we've got a variable (the last one)
			reportVariable(varname, currentVarType, false, false);
		}
	}

	/**
	 * Report the discovery of a variable
	 * @param varname
	 * @param type
	 * @param isParam
	 * @param hasValue
	 */
	private void reportVariable(String varname, String type, boolean isParam, boolean hasValue){
		//catches parameter variables
		if(inClass){
			if(nestedCurlyBracklets >= 1 && isParam && !hasValue && (isPrimitiveType(type)||"String".equals(type))
					&& isAlphanumericToken(varname)){
				VariableDefinition temp = new VariableDefinition();
				temp.setVariableName(varname);
				temp.setVariableType(type);
				temp.setParam(isParam);
				temp.setPrimitive(isPrimitiveType(type));
				paramVars.add(temp);
			}
			// catches global variables
			if (!isParam && nestedCurlyBracklets > 0 && nestedCurlyBracklets < 2){

				VariableDefinition temp = new VariableDefinition();
				temp.setVariableName(varname);
				temp.setVariableType(type);
				temp.setParam(isParam);
				temp.setPrimitive(isPrimitiveType(type));
				classes.get(currentClassIndex).addVariable(temp);

			}

			// catches local variables
			if (nestedCurlyBracklets >= 2 && !isParam){
				VariableDefinition temp = new VariableDefinition();
				temp.setVariableName(varname);
				temp.setVariableType(type);
				temp.setParam(isParam);
				temp.setPrimitive(isPrimitiveType(type));
				localVariables.add(temp); // TODO: put into class list of variables.
			}
			// increments the number if primitive variables in each class
			if ("int".equals(type)) classes.get(currentClassIndex).incrementNumInts();
			if ("boolean".equals(type)) classes.get(currentClassIndex).incrementNumBools();
			if ("char".equals(type)) classes.get(currentClassIndex).incrementNumChars();
			if ("float".equals(type)) classes.get(currentClassIndex).incrementNumFloats();
			if ("double".equals(type)) classes.get(currentClassIndex).incrementNumDoubles();
			if ("byte".equals(type)) classes.get(currentClassIndex).incrementNumBytes();
			if ("short".equals(type)) classes.get(currentClassIndex).incrementNumShorts();
			if ("long".equals(type)) classes.get(currentClassIndex).incrementNumLongs();
			classes.get(currentClassIndex).incrementPrimitive();
		}
	}

	/**
	 * Checks a token 
	 * @param current
	 */
	private void processToken(String current){
		if (!inString && !inComment && isAlphanumericToken(current)){
			numAlphaNumeric++;				
		}				
	}

	/**
	 * Check if the token is part of the primitive variable array.
	 * @param token
	 * @return
	 */
	private boolean isPrimitiveType(String token){
		if (token == null) return false;

		if(PRIMITIVES.contains(token)){
			return true;
		}
		return false;
	}

	/**
	 * Determines if the current token is alphanumeric
	 * @param token
	 * @return
	 */
	private boolean isAlphanumericToken(String token){
		if (token == null || token.length() == 0) 
			return false;

		if (!Character.isLetter(token.charAt(0)) && token.charAt(0) != '_')
			return false;

		if (token.charAt(0) == '_' && token.length() == 1)
			return false;

		for (int i = 1; i < token.length(); i++){
			if (!Character.isLetter(token.charAt(i)) 
					&& !Character.isDigit(token.charAt(i)) 
					&& token.charAt(i) != '_')
				return false;
		}

		return true;
	}

	/**Checks if a line is empty
	 * @param line
	 * @return
	 */
	private boolean lineIsEmpty(String line){
		line = line.replace("\t", "").trim();
		if (line == null||"".equals(line)) {
			return true;
		}
		return false;
	}

	/**
	 *  this method processes the nesting of a file. Makes processLine smaller in size.
	 * @param current
	 */
	private void processNesting(String current){
		if ("{".equals(current) && !inString && !inComment && !simpleComment){
			nestedCurlyBracklets++;
			if(classes.get(currentClassIndex)!= null && inClass){
				if(nestedCurlyBracklets > classes.get(currentClassIndex).getClassNestingDepth()){
					classes.get(currentClassIndex).changeMaxClassDepth(nestedCurlyBracklets);// This is increment nesting of a class. Relies on escape from class being correct.
				}

			}
			int x = classes.get(currentClassIndex).getMethodIndex(); // get the current method index from your current class

			if(inMethod){
				// if the current nesting of a method is greater than the previous, update it.
				if (nestedCurlyBracklets - 1 > classes.get(currentClassIndex).getClassMethods().get(x).getMethodNestingDepth()){
					classes.get(currentClassIndex).getClassMethods().get(x).increaseMaxMethodNesting(nestedCurlyBracklets - 1);
				}
			}
		}
			if ("}".equals(current) && !inString && !inComment && nestedCurlyBracklets > 0 && !simpleComment){
				nestedCurlyBracklets--;
				
				int x = classes.get(currentClassIndex).getMethodIndex(); // get the current method index from your current class
				if(classes.get(currentClassIndex).getClassScope() >= nestedCurlyBracklets){
					inClass = false;
					

				}

				if(inMethod && classes.get(currentClassIndex).getClassMethods().get(x).getMethodScope() >= nestedCurlyBracklets){
					inMethod = false;
				}

			}
			
	}
	// prevents currently defined classes being added again
	public boolean classNotDefined(String className){
		if(currentClassIndex == -1){return true;}

		for(ClassDefinition temp :classes){
			if (temp.getClassName().equals(className)){
				return false;
			}
		}

		return true;
	}

	public boolean methodNotDefined(String methodName){
		if(classes.get(currentClassIndex).getMethodIndex() == -1 && currentClassIndex == -1){return true;}

		for(MethodDefinition temp :classes.get(currentClassIndex).getClassMethods()){
			if(temp.getMethodName().equals(methodName)){
				return false;
			}
		}

		return true;
	}

}