package smells;

import java.util.ArrayList;

import Definitions.ClassDefinition;
import Definitions.MethodDefinition;
import Utils.Configurations;

/**
 * 
 * @author Computard
 * This class tests your project for deepnesting
 *
 */
public class DeepNesting {
	
	//private ArrayList <ClassDefinition> classList = CriticalTextAnalyzer.classes;
	private ArrayList<ClassDefinition> classList = null;
	
	//--------------------Constructor-----------------------//
	public DeepNesting(ArrayList<ClassDefinition> temp) {
		classList = temp;
	}

	//----------------------Methods-------------------------//
	/**
	 * Goes through every class and look for long methods.
	 */
	public void deepClass(){
		for(int i=0; i<classList.size(); i++){
			//System.out.println("THE MAX CLASS LENGTH IS: " + Configurations.getMaxClassCommentingRatio());
			if (classList.get(i).getClassLength() > Configurations.getMaxClassNesting()){ // compares the length of the class to the length specified in the configuration file.
				codeCritic.Report.addToDeepNestedClasses(classList.get(i));  // sends the bad class to the report
				
				System.out.println("ADDING "+ classList.get(i).getClassName());
			}
		}
	}

	/**
	 * Goes though all the methods in all the classes and seachs for long ones.
	 */
	public void deepMethods(){
		for(int i=0; i<classList.size(); i++){
			ArrayList <MethodDefinition> methodList = classList.get(i).getClassMethods();
			for(int j=0; j<methodList.size(); j++){
				if(methodList.get(j).getMethodLength() > Configurations.getMaxMethodNesting()){ //// compares the length of the method to the length specified in the configuration file.
					codeCritic.Report.addToDeepNestedMethods(methodList.get(j));  // sends the bad method to the report
				}
			}
		}
	}

}
