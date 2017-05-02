package edu.upf.taln.marytss.core;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.sound.sampled.AudioInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import edu.upf.taln.utils.conll.ConllSentence;
import edu.upf.taln.utils.conll.ConllText;
import edu.upf.taln.utils.conll.ConllToken;
import marytts.LocalMaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.data.audio.MaryAudioUtils;

public class Txt2Wav{

    private static final String PROSMARK_TEMPLATE = "<%s %s='%s'/>";

	LocalMaryInterface mary = null;

	//private Float rate;
	private double prosody_rate = 0; // -10
	private double period_break_time = 0; // 0.5
	private double paragraph_break_time = 0; //2
	
	public Txt2Wav (String lang, ConllText conll, String audioFilepath) throws MaryConfigurationException {		
		
		// initialization of Mary
		System.out.println("Input:" + conll);
		String inputText = conll.getText();
		System.out.println("text:" + inputText);
		
		try {
			mary = new LocalMaryInterface();
			/*
			Set<String> voices = mary.getAvailableVoices();
			System.out.println(voices);
			*/
		} catch (MaryConfigurationException e) {
			System.err.println("Could not initialize MaryTTS interface: " + e.getMessage());
			throw e;
		}

		// synthesize
		AudioInputStream audio = null;
		try {
			switch (lang) {
			case "de":
				mary.setVoice("bits1-hsmm");
				break;				
			case "ar":
				mary.setVoice("ar-nah-hsmm");
				break;				
			case "tr":
				mary.setVoice("dfki-ot-hsmm");
				break;				
			case "en":
				mary.setVoice("cmu-slt-hsmm");
				break;				
			default : 
				mary.setVoice("cmu-slt-hsmm");
				break;					
			}
			System.out.println("Sintesis: " + inputText );
			audio = mary.generateAudio(inputText);
			
		} catch (SynthesisException e) {
			System.err.println("Synthesis failed: " + e.getMessage());
			System.exit(1);
		}

		// write to output audio FILE
		double[] samples = MaryAudioUtils.getSamplesAsDoubleArray(audio);
		//
		try {
			MaryAudioUtils.writeWavFile(samples, audioFilepath , audio.getFormat());
		} catch (IOException e) {
			System.err.println("Could not write to file: " + audioFilepath + "\n" + e.getMessage());
			System.exit(1);
		}
	}
	



	public double getProsodyRate() {
		return prosody_rate;
	}
	public void setProsodyRate(double prosody_rate) {
		this.prosody_rate = prosody_rate;
	}
	public double getPeriodBreakTime() {
		return period_break_time;
	}
	public void setPeriodBreakTime(double period_break_time) {
		this.period_break_time = period_break_time;
	}
	public double getParagraphBreakTime() {
		return paragraph_break_time;
	}
	public void setParagraphBreakTime(double paragraph_break_time) {
		this.paragraph_break_time = paragraph_break_time;
	}
	
	public String getMaryXML(ConllText conll) throws Exception {
		
		StringBuilder cereprocStr = new StringBuilder();
		for(ConllSentence sentence : conll) {
			
			cereprocStr.append("<s>");
			for(ConllToken token : sentence) {
				
				String form = token.getForm();
				String prosmark = token.getFeature("prosmark");
				
				if (prosmark != null) {
	     			System.out.println("Pont: " + form + " -Prosmark: " + prosmark);

		     		String[] pont2 = prosmark.split("_");
		     		cereprocStr.append(String.format(PROSMARK_TEMPLATE, pont2[0], pont2[1], pont2[2]));
		        }
				cereprocStr.append(form);
				cereprocStr.append(" ");
			}
			cereprocStr.append("</s>");
		}
		
		return cereprocStr.toString();
	}

	public String getMaryXML(String sentence) throws Exception {
		
		String output_sentence = sentence;
		if (this.period_break_time != 0.0) {
			output_sentence = output_sentence.replace(".", ".<break time=\"" + this.period_break_time + "s\"/>");
		}
		
		if (this.paragraph_break_time != 0.0) {
			output_sentence = output_sentence.replace("\n\n", ".<break time=\"" + this.paragraph_break_time + "s\"/>");
			output_sentence = output_sentence.replace("\r\n\r\n", ".<break time=\"" + this.paragraph_break_time + "s\"/>");
		}
		
		if (this.prosody_rate != 0.0) {
			output_sentence = "<prosody rate=\"" + this.prosody_rate + "%\">" + output_sentence;
			output_sentence += "</prosody>";
		}
		
		output_sentence = "<s>" + output_sentence + "</s>";
		System.out.println(output_sentence);
		
		return output_sentence;
	}
	
	public GenerationInfo generate(String sentence, String out_audio_file) throws Exception {
		
		if (mary == null) {
			throw new Exception("Not initialized!");
		}
		
		String xml = getMaryXML(sentence);
		return generate(xml, sentence, out_audio_file);
	}
	
	public GenerationInfo generate(ConllText conll, String out_audio_file) throws Exception {
		
		if (mary == null) {
			throw new Exception("Not initialized!");
		}
		
		String xml = getMaryXML(conll);
		return generate(xml, conll.getText(), out_audio_file);
	}
	
	

	public GenerationInfo generate(String xml, String text, String out_audio_file) throws Exception {
		
		SequenceExtractor cb = null;
		try {
			// Read the input file line by line and write to the synthesis buffer
		    // System.out.println("Sample rate: " + rate);
			// Set our callback class onto it
			cb = new SequenceExtractor();
			cb.Callback(mary, text);
			

		    GenerationInfo info = new GenerationInfo();
		    info.setText(text);
		    info.setSequence(cb.getTimeStamps());
		    info.setDuration(cb.getDuration());
		    info.setAudioFilePath(out_audio_file);
		    info.setValence(0.0);
		    info.setArousal(0.0);
		    info.setTextTiming(cb.getTextTiming());
			
			return info;
			
		} catch (Exception e) {
			
			
			throw e;
		}
    }
	
}
