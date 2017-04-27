package edu.upf.taln.marytss.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import marytts.LocalMaryInterface;
import marytts.exceptions.SynthesisException;

import marytts.datatypes.MaryData;
import marytts.datatypes.MaryDataType;
import marytts.datatypes.MaryXML;
import marytts.exceptions.MaryConfigurationException;




// MaryTTS uses a output option to choose the way the input text
// is processed. So, we ask for at the module to obtain a duration
// prediction of each phoneme that is processed.
// This option is 'REALISED_DURATIONS' which result is the input
// of this class

class SequenceExtractor{
	// Process the data in the callback. Here we convert inputText into
	// the word list and the phone mapping calls . The callback function
	// receives a maryLocalInterface object and the input text.
	// feature vectors and word list are extracted here

	static ArrayList<String> wordsnames = new ArrayList<String>();
	static ArrayList<Double> wordstarts = new ArrayList<Double>();
	static ArrayList<Double> wordsends = new ArrayList<Double>();

	static ArrayList<double[]> timestamps = new ArrayList<double[]>();
	public static float duration = 0;
	
	public static void Callback(LocalMaryInterface mary, String inText) throws SynthesisException, MaryConfigurationException {


		PhoneticMapper pm = new PhoneticMapper();		
		
		// First process the transcription information and print it
		// Process the transcription buffer items and print information. 
		//
		String resTemp="";
		String[] words;
		String[] timeBites = null;
		double prevEnds = 0.0;
		double ends = 0.0;
		String name = "";

		mary.setOutputType("REALISED_DURATIONS");
		resTemp = mary.generateText(inText);
		//System.out.println("Long: " + res.length() + "\n");
		//System.out.println("Long: " + resTemp.length() + "\n" + resTemp);
		timeBites = resTemp.split(" |\n");
		
		//System.out.println("Long Bites: " + timeBites.length);
		
		duration = Float.parseFloat(timeBites[timeBites.length-3]); // Ok!!
		//System.out.println("Duration: " + duration);
			
			for (int m=1; m<timeBites.length; m=m+3){
					// * 
				name = timeBites[m+2];
				ends = Double.parseDouble((timeBites[m]));
				
				double mid = ((ends - prevEnds) / 2);
				double intensity = 1;
				//
				double[] valuesOK = pm.getMappingPoints(name);
				boolean consonant = pm.getMappingLet(name);
				String formant = pm.getMappingType(name);
				String position = pm.getMappingPos(name);
				double[] finalValues = new double[valuesOK.length + 1];
				finalValues[0] = prevEnds + mid;
				
				if (consonant)
					intensity = 0.6;
				for(int idx = 1; idx < finalValues.length; idx++) {
					double value = intensity* valuesOK[idx-1];
					finalValues[idx] = value;
				}
				timestamps.add(finalValues);
				
				prevEnds = ends ;				
				
			}
			
		String regEx = "\\.|\\,| ";
		
		int totalLetters = 0;
		Double wordEnd = 0.0;
		Double wordStart = 0.0;
		words = inText.split(regEx);		
		for (int i = 0; i < words.length; i++) {
			totalLetters = totalLetters + words[i].length();
			wordEnd = Double.parseDouble(timeBites[((totalLetters*3)-2)]);

			wordsnames.add(words[i]);
			wordstarts.add(wordStart);
			wordsends.add(wordEnd);
			wordStart = wordEnd;			
		}
			
	}

	public ArrayList<double[]> getTimeStamps() {
		return this.timestamps;
	}
	
	public ArrayList<String> getWordsName() {
		return this.wordsnames;
	}
	
	public ArrayList<Double> getWordStarts() {
		return this.wordstarts;
	}	
	
	public ArrayList<Double> getWordEnds() {
		return this.wordsends;
	}
	
	public float getDuration() {
		return this.duration;
	}

	public ArrayList<Object> getTextTiming() {
		ArrayList<Object> a = new ArrayList<Object>();
		a.add(this.wordsnames);
		a.add(this.wordstarts);
		a.add(this.wordsends);
		return a;
	}
}