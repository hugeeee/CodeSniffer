package smells;

import java.util.ArrayList;

import Definitions.ClassDefinition;
import Definitions.MethodDefinition;
import Utils.Configurations;

/**
 * 
 * @author Computard
 * This class checks your project for excessive commenting.
 *
 */
public class ExcessiveCommenting {

	//private ArrayList <ClassDefinition> classList = CriticalTextAnalyzer.classes;
	private ArrayList<ClassDefinition> classList = null;

	//--------------------Constructor-----------------------//
	public ExcessiveCommenting (ArrayList<ClassDefinition> temp) {
		classList = temp;
	}

	//----------------------Methods-------------------------//
	/**
	 * Goes through every class and look for excessive commenting.
	 */
	public void excessiveCommentingClass(){
		for(int i=0; i<classList.size(); i++){
			if (classList.get(i).getClassLength() > 10 && classList.get(i).getNumberOfComments() != 0){
				float classRatio = (float)(classList.get(i).getClassLength() / classList.get(i).getNumberOfComments());
				System.out.println("ratio"+ classRatio);
				System.out.println("setting" + Configurations.getMaxClassCommentingRatio());
				if (classRatio > Configurations.getMaxClassCommentingRatio()){ // compares the length of the class to the length specified in the configuration file.
					codeCritic.Report.addToCommentedClasses(classList.get(i));
					System.out.println("ratio"+ classRatio);
				}
			}
		}
	}

	/**
	 * Goes though all the methods in all the classes and seachs for long excessive commenting.
	 */
	public void excessiveCommentingMethod(){
		for(int i=0; i<classList.size(); i++){
			ArrayList <MethodDefinition> methodList = classList.get(i).getClassMethods();
			for(int j=0; j<methodList.size(); j++){
				if(methodList.get(j).getMethodLength() != 0 && methodList.get(j).getMethodCommenting() != 0){
						float methodRatio = (float)(methodList.get(j).getMethodLength() / methodList.get(j).getMethodCommenting());
						if(methodRatio > Configurations.getMaxMethodCommentingRatio()){ //// compares the length of the method to the length specified in the configuration file.
							codeCritic.Report.addToCommentedMethods(methodList.get(j));
						}
					}
				
			}
		}
	}
}
