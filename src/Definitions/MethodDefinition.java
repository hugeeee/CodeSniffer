package Definitions;

import java.util.Vector;


/**
 * @author Computard
 * 
 * This class represents a method as an object. The toString() method has been overridden to provide 
 * more information about the method in question. This comes in very useful for making the report.
 */
public class MethodDefinition {

	private String belongsToClassName = "";

	private String methodName = "";
	private String returnType = "";
	private String methodPrivacy = "";
	private int methodLength = 0;
	private int methodNestingDepth = 0;
	private int methodScope = 0;
	private int methodCommenting = 0;
	
	private Vector<VariableDefinition> variables = new Vector<VariableDefinition>();
	public Vector<VariableDefinition> getVariables(){return variables;}
	
	
	// Getters
	public String getMethodPrivacy(){return methodPrivacy;};
	public String getMethodName(){return methodName;}
	public String getReturnType(){return returnType;}
	public int getMethodLength(){return methodLength;}
	public int getMethodNestingDepth() {return methodNestingDepth;}
	public String getBelongsToClassName() {return belongsToClassName;}
	public int getMethodScope() {return methodScope;}
	
	// Setters
	public void setMethodName(String name){methodName = name;}	
	public void setMethodPrivacy(String p){methodPrivacy = p;}	
	public void setReturnType(String type){returnType = type;}
	public void setBelongsToClassName(String belongsToClassName) {this.belongsToClassName = belongsToClassName;}
	public void setMethodScope(int methodScope) {this.methodScope = methodScope;}

	
	public void increaseMethodLength(){methodLength++;}
	
	public void increaseMaxMethodNesting(int x){// This is to count the nesting depth of a method.
		methodNestingDepth = x;
	}
	
	
	public String toString(){
		
		return "Class Name: " + getBelongsToClassName()+ "\n"+
		   "This method has a Length: " + getMethodLength();
		
	}

	public void incrementMethodCommenting() {
		this.methodCommenting++;
	}

	public int getMethodCommenting() {
		return methodCommenting;
	}

}
