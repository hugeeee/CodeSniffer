package Definitions;

import java.util.ArrayList;
import java.util.Vector;

/**
 * 
 * @author Computard
 * This class represents a class
 *
 */
public class ClassDefinition {
	
	private String className = "";
	private String parentName = "Object";
	private int classLength = 0;
	private int numberPrimitives = 0;
	private int numberComments = 0;
	private int classNestingDepth = 0;
	private int classScope = 0;
	private int methodIndex = -1; // Initialise -1 to make sure indexing is correct.
	private int numInts, numBooleans, numChars, numFloats, numDoubles, numBytes, numShorts, numLongs, numPrimitives;
	private int numLiteralStrings = 0;		// number of literal text strings in a text
	private int methodCount = 0;
	
	private Vector<VariableDefinition> classVariables = new Vector<VariableDefinition>();
	
	private ArrayList<MethodDefinition> classMethods = new ArrayList<MethodDefinition>();
	private Vector<String> methodsCalled = new Vector<String>();
	private Vector<ClassDefinition> interfaceNames = new Vector<ClassDefinition>();// A vector to store the interfaces
	
	/**
	 * constructs a class a new class
	 * @param name = name of the class.
	 */
	public ClassDefinition(String name){
		className = name;
	}
	//Getters
	public ArrayList<MethodDefinition> getClassMethods(){return classMethods;}
	public int getNumLiteralStrings() {return numLiteralStrings;}
	public int getClassNestingDepth() {return classNestingDepth;}
	public int getClassLength() {return classLength;}
	public int getNumberOfComments(){return numberComments;}
	public String getParentClassName(){return parentName;}
	public String getClassName(){return className;}
	public int getClassScope() {return classScope;}
	public Vector<String> getMethodsCalled() {return methodsCalled;}
	public Vector<ClassDefinition> getInterfaceNames(){return interfaceNames;}
	public int getMethodIndex() {return methodIndex;}
	public int getNumInts() {return numInts;}
	public int getNumBooleans() {return numBooleans;}
	public int getNumChars() {return numChars;}
	public int getNumFloats() {return numFloats;}
	public int getNumDoubles() {return numDoubles;}
	public int getNumBytes() {return numBytes;}
	public int getNumShorts() {return numShorts;}
	public int getNumLongs() {return numLongs;}
	public int getNumPrimitives() {return numPrimitives;}
	public int getMethodCount() {return methodCount;}

	//Setters
	public void setParentName(String name){parentName = name;}
	public void changeMaxClassDepth(int c){classNestingDepth = c;}	
	public void setClassScope(int classScope) {this.classScope = classScope;}
	
	//Methods
	public void incrementPrimitive(){numberPrimitives++;}
	public void incrementNumLiterals(){numLiteralStrings++;}
	public void incrementNumComments(){numberComments++;}
	public void incrementClassLength() {classLength++;}
	
	public void addVariable(VariableDefinition var){
		classVariables.add(var);
	}
	
	/**
	 * adds a method to the classes list of methods.
	 * @param method = method to add.
	 */
	public void addMethod(MethodDefinition method){
		methodIndex++; // Increment the index of methods. So you can extract the current method and manipulate.
		methodCount++;
		classMethods.add(method);
	}
	
	public void addInterface(ClassDefinition interFace){
		interfaceNames.add(interFace);
	}
	
	public void addMethodCalled(String method){
		methodsCalled.add(method);
	}
	
	//Incrementers for primitive variables.
	public void incrementNumInts(){numInts++;}
	public void incrementNumBools(){numBooleans++;}
	public void incrementNumChars(){numChars++;}
	public void incrementNumFloats(){numFloats++;}
	public void incrementNumDoubles(){numDoubles++;}
	public void incrementNumBytes(){numBytes++;}
	public void incrementNumShorts(){numShorts++;}
	public void incrementNumLongs(){numLongs++;}

	public String toString(){
		
		return "Class Name: "+getClassName()+"\n"+
			   "Length: "+getClassLength()+"\n"+
			   "Methods: "+getMethodIndex();
	}
}
