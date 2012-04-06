package smells;

import java.util.ArrayList;

import Utils.Configurations;

import Definitions.ClassDefinition;

/**
 * 
 * @author Computard
 * This class smells your project for a lazy class.
 *
 */

public class LazyClass {


	private ArrayList<ClassDefinition> classList = null;

	
	public LazyClass(ArrayList<ClassDefinition> temp) {
		classList = temp; 
		longClassLength();
	}
	
	public void longClassLength(){
		
		for(int i=0; i<classList.size(); i++){
			
			if(classList.get(i).getClassLength() < Configurations.getLazyClassMinLength() || classList.get(i).getMethodCount() < Configurations.getLazyMinMethodCount()){
				codeCritic.Report.addToLazyClasses(classList.get(i)); 
			}
		}
	}
}
