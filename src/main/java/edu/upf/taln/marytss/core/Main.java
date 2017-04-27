package edu.upf.taln.marytss.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.upf.taln.utils.conll.ConllText;

public class Main {

	public static void doGeneration(String conllStr, String outputAudioPath, String outputJsonPath) {
		
		Txt2Wav mary = null;
		try {
			String lang = "tr";
			
			ConllText conll = new ConllText(conllStr);
			
			mary = new Txt2Wav(lang, conll, outputAudioPath);
			
			//System.out.println("El conllStr : " + conllStr);
			//System.out.println("El conll : " + conll);
			
			GenerationInfo info = mary.generate(conll, outputAudioPath);
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String jsonStr = gson.toJson(info, info.getClass());
		    System.out.println(jsonStr);
		    
		    FileUtils.writeStringToFile(new File(outputJsonPath), jsonStr, "UTF-8");

		} catch (Exception e) {
			e.printStackTrace();
		    System.out.println("ERROR: " + e.getMessage());
		    System.out.println("Exiting...");
		}

	}
	
	public static void main(String[] args) throws IOException {
		//
		// from here 

        if (args.length == 2) {
        		String path = args[0];
                File inFile = new File(path);
                
                if (inFile.exists()) {
                	
                	FileInputStream fisTargetFile = new FileInputStream(inFile);

                	String conll = IOUtils.toString(fisTargetFile, "UTF-8");
                    doGeneration(conll,
                				inFile.getAbsolutePath() + ".wav",
                				inFile.getAbsolutePath() + ".json");
                } else {
                	System.out.println("File " + inFile + " not found!");
                }

        } else {
        	usage();
        }
	}
	
    static void usage(){
		System.out.println("LipSync - Java TTS program using the MaryTTS API for generation of lipsync information.");
		System.out.println("This tool loads a language, then generates 2 outputs:");
		System.out.println("  - the generated audio as a .wav file.");
		System.out.println("  - the lipsync info as a .json file.");
		System.out.println("Usage: lipsync.jar <input.conll>");
		System.exit(0);
    }
}
