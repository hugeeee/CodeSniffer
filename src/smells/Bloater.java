package smells;

import java.util.ArrayList;
import Definitions.*;
import Utils.Configurations;


import codeCritic.*;

/**	@Computard
 *     This class checks for bloated class and methods.
 */

public class Bloater{

	
	//private ArrayList <ClassDefinition> classList = CriticalTextAnalyzer.classes;
	private ArrayList<ClassDefinition> classList = null;
	
	//--------------------Constructor-----------------------//
	public Bloater(ArrayList<ClassDefinition> temp) {
		classList = temp;
	}

	//----------------------Methods-------------------------//
	/**
	 * Goes through every class and look for long methods.
	 */
	public void longClassLength(){
		for(int i=0; i<classList.size(); i++){
			System.out.println("THE MAX CLASS LENGTH IS: " + Configurations.getBloaterMaxClassLength());
			if (classList.get(i).getClassLength() > Configurations.getBloaterMaxClassLength()){ // compares the length of the class to the length specified in the configuration file.
				codeCritic.Report.addToBloatedClasses(classList.get(i));  // sends the bad class to the report
				
				System.out.println("ADDING "+ classList.get(i).getClassName());
			}
		}
	}

	/**
	 * Goes though all the methods in all the classes and seachs for long ones.
	 */
	public void longMethodLength(){
		for(int i=0; i<classList.size(); i++){
			ArrayList <MethodDefinition> methodList = classList.get(i).getClassMethods();
			for(int j=0; j<methodList.size(); j++){
				if(methodList.get(j).getMethodLength() > Configurations.getBloaterMaxMethodLength()){ //// compares the length of the method to the length specified in the configuration file.
					codeCritic.Report.addToBloatedMethods(methodList.get(j));  // sends the bad method to the report
				}
			}
		}
	}
}

