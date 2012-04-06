package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Computard
 * This is a config class that sets all the variables that the user has an option to change.
 * This class loads those setting from a properties file and writes them to it too.
 */

public class Configurations {

	public static Properties config;

	// Bloater smell
	private static String classBloaterMaxKey = "BLOATER_MAX_LINE_CLASS";
	private static int maxBloaterClassLength = 0;	
	private static String methodBloaterMaxKey = "BLOATER_MAX_LINE_METHOD"; // I might make this static to access it in config GUI
	private static int maxBloaterMethodLength = 0;

	// Lazy smell
	private static String classLazyMinKey = "LAZY_MIN_CLASS_SIZE";
	private static int minLazyClassLength = 0;	
	private static String methodLazyMaxKey = "LAZY_MIN_METHODS"; // I might make this static to access it in config GUI
	private static int minLazyMethods = 0;
	
	// Excessive Commenting smell
	private static String classMaxCommentingKey = "MAX_COMMENTING_CLASS_RATIO";
	private static float maxClassCommentingRatio = 0;
	private static String methodMaxCommentingKey = "MAX_COMMENTING_METHOD_RATIO";
	private static float maxMethodCommentingRatio = 0;
	
	// nesting smell
	private static String classMaxNestingKey = "MAX_NESTING_CLASS";
	private static int maxClassNesting = 0;	
	private static String methodMaxNestingKey = "MAX_NESTING_METHOD"; // I might make this static to access it in config GUI
	private static int maxMethodNesting = 0;
	
	// God smell
	private static String godWorkKey = "GOD_WORK";
	private static int godWorkAmount = 0;

	private static final String file = "config_file.properties";	// This is set. This is the only config file read.

	//constructor
	public Configurations(){
		Configurations.loadConfigFile();
		Configurations.setupConfigs();
	}

	//getters
	public static int getBloaterMaxClassLength(){return maxBloaterClassLength;}
	public static int getBloaterMaxMethodLength() {return maxBloaterMethodLength;}
	public static int getLazyClassMinLength(){return minLazyClassLength;}
	public static int getLazyMinMethodCount(){return minLazyMethods;}
	public static int getMaxClassNesting(){return maxClassNesting;}
	public static int getMaxMethodNesting(){return maxMethodNesting;}
	public static float getMaxMethodCommentingRatio() {return maxMethodCommentingRatio;}
	public static int getGodWorkAmount() {return godWorkAmount;}
	public static float getMaxClassCommentingRatio() {return maxClassCommentingRatio;}
	
	//setters
	public static void setBloaterMaxMethodLength(int length){
		maxBloaterMethodLength = length;
	}
	public static void setBloaterMaxClassLength(int length){
		maxBloaterClassLength = length;
	}
	public static void setMaxClassCommentingRatio(float max) {
		maxClassCommentingRatio = max;
	}
	public static void setMaxMethodCommentingRatio(float max) {
		maxMethodCommentingRatio = max;
	}
	public static void setNestingLevelClass(int nesting) {
		maxClassNesting = nesting;
	}
	public static void setNestingLevelMethod(int nesting) {
		maxMethodNesting = nesting;
	}
	public static void setGodWorkAmount(int god) {
		godWorkAmount = god;
	}
	public static void setMinLazyClassLength(int min) {
		minLazyClassLength = min;
	}
	public static void setMinLazyMethods(int min) {
		minLazyMethods = min;
	}
	


	//methods
	private static void loadConfigFile(){
		config = new Properties();

		try{
			config.load(new FileInputStream(file));
		}catch(IOException ex){
			ex.printStackTrace();
			return;
		}
	}

	public static void saveConfig(){
		config.setProperty(classBloaterMaxKey, Integer.toString(maxBloaterClassLength));
		config.setProperty(methodBloaterMaxKey, Integer.toString(maxBloaterMethodLength));
		config.setProperty(classMaxCommentingKey, Float.toString(maxClassCommentingRatio));
		config.setProperty(methodMaxCommentingKey, Float.toString(maxMethodCommentingRatio));
		config.setProperty(classMaxNestingKey, Integer.toString(maxClassNesting));
		config.setProperty(methodMaxNestingKey, Integer.toString(maxMethodNesting));
		config.setProperty(godWorkKey, Integer.toString(godWorkAmount));
		config.setProperty(classLazyMinKey,Integer.toString(minLazyClassLength));
		config.setProperty(methodLazyMaxKey,Integer.toString(minLazyMethods));

		try {
			config.store(new FileOutputStream("config_file.properties"), null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	private static void setupConfigs(){
		// Set all the code smell variables here from the property file.
		maxBloaterClassLength = Integer.parseInt(config.getProperty(classBloaterMaxKey));
		maxBloaterMethodLength = Integer.parseInt(config.getProperty(methodBloaterMaxKey));
		maxClassCommentingRatio = Float.parseFloat(config.getProperty(classMaxCommentingKey));
		maxMethodCommentingRatio = Float.parseFloat(config.getProperty(methodMaxCommentingKey));
		maxClassNesting = Integer.parseInt(config.getProperty(classMaxNestingKey));
		maxMethodNesting = Integer.parseInt(config.getProperty(methodMaxNestingKey));
		godWorkAmount = Integer.parseInt(config.getProperty(godWorkKey));
		minLazyClassLength = Integer.parseInt(config.getProperty(classLazyMinKey));
		minLazyMethods = Integer.parseInt(config.getProperty(methodLazyMaxKey));
	}


}
