package edu.upf.taln.marytts.test;

import java.util.ArrayList;

public class GenerationInfo {
	
	private String text;
	private String audioFilePath;
	private String audioURL;
	private double duration;
	private double valence;
	private double arousal;
	private ArrayList<double[]> sequence;
	private ArrayList<Object> textTiming;
	
	public GenerationInfo() {
	}
	
	public GenerationInfo(GenerationInfo info) {
		this();
    	this.setText(info.getText());
    	this.setValence(info.getValence());
    	this.setArousal(info.getArousal());
    	this.setAudioURL(info.getAudioURL());
    	this.setDuration(info.getDuration());
    	this.setSequence(info.getSequence());
    	this.setTextTiming(info.getTextTiming());
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getAudioFilePath() {
		return audioFilePath;
	}
	public void setAudioFilePath(String path) {
		this.audioFilePath = path;
	}
	
	public String getAudioURL() {
		return audioURL;
	}
	
	public void setAudioURL(String url) {
		this.audioURL = url;
	}
	
	public double getDuration() {
		return duration;
	}
	
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	public double getValence() {
		return valence;
	}
	
	public void setValence(double valence) {
		this.valence = valence;
	}
	
	public double getArousal() {
		return arousal;
	}
	
	public void setArousal(double arousal) {
		this.arousal = arousal;
	}
	
	public ArrayList<double[]> getSequence() {
		return sequence;
	}
	
	public void setSequence(ArrayList<double[]> sequence) {
		this.sequence = sequence;
	}

	public ArrayList getTextTiming() {
		return textTiming;
	}

	public void setTextTiming(ArrayList textTiming) {
		this.textTiming = textTiming;
	}

	@Override
	public String toString() {
		return "Info [audioURL=" + audioFilePath + ", sequence=" + sequence + ", duration=" + duration + ", valence=" + valence + ", arousal=" + arousal + "]";
	}
}
