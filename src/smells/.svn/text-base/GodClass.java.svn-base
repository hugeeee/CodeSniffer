package smells;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Definitions.ClassDefinition;
import Definitions.MethodDefinition;
import Utils.Configurations;

/**
 * 
 * @author Computard
 * This class smells projects for the presence of a God class.
 *
 */
public class GodClass {

	private ArrayList<ClassDefinition> classList = null;

	// --------------------Constructor-----------------------//
	public GodClass(ArrayList<ClassDefinition> temp) {
		classList = temp;
	}

	// ----------------------Methods-------------------------//
	/**
	 * Goes through every class for one with a disproportionate amount of work.
	 */
	public void godClassDetection() {
		if (classList.size() > 1) {
			Collections.sort(classList, new Comparator<ClassDefinition>() {
				@Override
				public int compare(ClassDefinition o1, ClassDefinition o2) {
					  if (o1.getClassMethods().size() < o2.getClassMethods().size()){
				            return -1;
					  }
				        else if (o1.getClassMethods().size() == o2.getClassMethods().size()){
				            return 0;
				        }
				        else{
				            return 1;
				        }
				}
				
			});
			int diffWork = classList.get(0).getClassMethods().size()/classList.get(1).getClassMethods().size();
			if ((float)diffWork > (float)Configurations.getGodWorkAmount() && diffWork != 0){
				codeCritic.Report.addGodClass(classList.get(0));
				codeCritic.Report.addGodClass(classList.get(1));
			}
		}
	}
}
