package codeCritic;

import java.util.ArrayList;
import smells.Bloater;
import smells.DeepNesting;
import smells.ExcessiveCommenting;
import smells.GodClass;
import smells.LazyClass;
import Definitions.ClassDefinition;

/**
 * 
 * @author Computard
 * This class is the detector class. It determines which smells will be detected.
 *
 */
public class Detector {

	CriticalTextAnalyzer analyzedFiles; //  Going to get the browserTextfield.
	ArrayList<ClassDefinition> classesCaught = null;
	Report report = new Report();
	
	public void setCTA(CriticalTextAnalyzer cta){
		analyzedFiles = cta;
		classesCaught = analyzedFiles.getListOfClasses();
		
	}
	
	/**
	 * This method sets the smells to detect.
	 * 
	 * @param bloat = search for bloater smell
	 * @param deepNesting = search for deep nesting
	 * @param excessiveCommenting = search for excessive commenting
	 */
	public void detectSmells(boolean bloat, boolean deepNesting, boolean excessiveCommenting, boolean lazy, boolean god){

		if(bloat){
			System.out.println("BLOATER IS CHECKED AND BUILDING THE REPORT.");
			Bloater smellBloaters = new Bloater(classesCaught);
			smellBloaters.longClassLength();
			smellBloaters.longMethodLength();
			report.buildBloaterReport();
		}
		if(deepNesting){
			System.out.println("DEEPNESTING CHECKED AND BUILDING REPORT");
			DeepNesting smellDepth = new DeepNesting(classesCaught);
			smellDepth.deepClass();
			smellDepth.deepMethods();
			report.buildDeepNesting();
			// build nesting report
		}
		if (excessiveCommenting){
			ExcessiveCommenting excessComm = new ExcessiveCommenting(classesCaught);
			excessComm.excessiveCommentingClass();
			excessComm.excessiveCommentingMethod();
			report.buildExcessiveCommentingReport();
		}
		if(lazy){
			LazyClass lazyClass = new LazyClass(classesCaught);
			lazyClass.longClassLength();
			report.buildLazyReport();
		}
		if(god){
			GodClass godClass = new GodClass(classesCaught);
			godClass.godClassDetection();
			report.buildGodClassReport();
		}
	}
	
	/**
	 * Outputs the report of smells detected.
	 */
	public void outputReport(){
		report.generateCodeSnifferReport();
	}
	
	public void clearSmells(){
		report.clearDetectedSmells();
	}
}
