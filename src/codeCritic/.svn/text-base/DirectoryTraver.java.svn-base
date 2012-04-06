package codeCritic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DirectoryTraver {

	private ArrayList<CriticalTextAnalyzer> textAnalyzers;
	
	public DirectoryTraver(File myFile){
		textAnalyzers = new ArrayList<CriticalTextAnalyzer>();
		traverseFile(myFile);
	}
	
	public ArrayList<CriticalTextAnalyzer> getTextAnalyzers() {return textAnalyzers;}
	
	private void traverseFile(File file){
		if (file.isDirectory()){
			File[] filesInDirectory = file.listFiles();
			
			for (File tempFile :  filesInDirectory){
				traverseFile(tempFile);
			}
		}
		else{
			CriticalTextAnalyzer textAnalyzer;
			try {
				textAnalyzer = new CriticalTextAnalyzer(file.getPath());
				textAnalyzers.add(textAnalyzer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
}
