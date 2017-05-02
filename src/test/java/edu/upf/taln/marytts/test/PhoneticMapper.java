package edu.upf.taln.marytts.test;

import java.util.HashMap;

public class PhoneticMapper {
	
	static class PhoneticInfo {
		
		double[] points;
		String value1;
		String value2;
		String value3;
		String value4;
		String value5;

		public PhoneticInfo(double[] points, String value1, String value2, String value3, String value4, String value5) {
			
			super();
			this.points = points;
			this.value1 = value1;
			this.value2 = value2;
			this.value3 = value3;
			this.value4 = value4;
			this.value4 = value5;
		}
	}
	
	private HashMap<String, PhoneticInfo> phoneticMap;

	public PhoneticMapper() {
	
		phoneticMap = new HashMap<String, PhoneticInfo>();
		// mapping for lips and mouth position: --vowels--  jaw /smile / air /kiss/ close /sad -type vlng open frnt rnd
		phoneticMap.put("i:", new PhoneticInfo(new double[]{0.20, 0.47, 0.00, 0.00, 0.00, 0.10}, "v", "l", "1", "1", "-"));//
		phoneticMap.put("i" , new PhoneticInfo(new double[]{0.20, 0.47, 0.00, 0.00, 0.00, 0.10}, "v", "s", "1", "1", "-"));//
		phoneticMap.put("y:", new PhoneticInfo(new double[]{0.22, 0.60, 0.00, 0.00, 0.00, 0.20}, "v", "l", "1", "2", "+"));//
		phoneticMap.put("y" , new PhoneticInfo(new double[]{0.22, 0.60, 0.00, 0.00, 0.00, 0.20}, "v", "s", "1", "2", "+"));//
		phoneticMap.put("e:", new PhoneticInfo(new double[]{0.22, 0.60, 0.00, 0.00, 0.00, 0.20}, "v", "l", "2", "1", "-"));//
		phoneticMap.put("e" , new PhoneticInfo(new double[]{0.18, 0.65, 0.00, 0.00, 0.00, 0.20}, "v", "s", "2", "1", "-"));//
		phoneticMap.put("E:", new PhoneticInfo(new double[]{0.18, 0.65, 0.00, 0.00, 0.00, 0.20}, "v", "l", "2", "1", "-"));//
		phoneticMap.put("2:", new PhoneticInfo(new double[]{0.18, 0.65, 0.00, 0.00, 0.00, 0.20}, "v", "l", "2", "2", "+"));//
		phoneticMap.put("2" , new PhoneticInfo(new double[]{0.18, 0.65, 0.00, 0.00, 0.00, 0.20}, "v", "s", "2", "2", "+"));//
		phoneticMap.put("u:", new PhoneticInfo(new double[]{0.18, 0.65, 0.00, 0.00, 0.00, 0.20}, "v", "l", "1", "3", "+"));//
		phoneticMap.put("u" , new PhoneticInfo(new double[]{0.18, 0.65, 0.00, 0.00, 0.00, 0.20}, "v", "s", "1", "3", "+"));//
		phoneticMap.put("o:", new PhoneticInfo(new double[]{0.18, 0.65, 0.00, 0.00, 0.00, 0.20}, "v", "l", "2", "3", "+"));//
		phoneticMap.put("o" , new PhoneticInfo(new double[]{0.18, 0.65, 0.00, 0.00, 0.00, 0.20}, "v", "s", "2", "3", "+"));//
		phoneticMap.put("a:", new PhoneticInfo(new double[]{0.18, 0.65, 0.00, 0.00, 0.00, 0.20}, "v", "l", "3", "2", "-"));//
		phoneticMap.put("I" , new PhoneticInfo(new double[]{0.18, 0.65, 0.00, 0.00, 0.00, 0.20}, "v", "s", "1", "1", "-"));//
		phoneticMap.put("Y",  new PhoneticInfo(new double[]{0.22, 0.65, 0.00, 0.00, 0.00, 0.20}, "v", "s", "1", "2", "+"));//
		phoneticMap.put("E",  new PhoneticInfo(new double[]{0.00, 0.00, 0.35, 0.30, 0.60, 0.00}, "v", "s", "2", "1", "-"));//
		phoneticMap.put("9",  new PhoneticInfo(new double[]{0.00, 0.00, 0.35, 0.40, 0.60, 0.00}, "v", "s", "2", "2", "+"));//
		phoneticMap.put("U" , new PhoneticInfo(new double[]{0.00, 0.00, 0.00, 0.63, 0.00, 0.00}, "v", "s", "1", "3", "+"));//
		phoneticMap.put("O",  new PhoneticInfo(new double[]{0.12, 0.45, 0.00, 0.20, 0.20, 0.15}, "v", "s", "2", "3", "+"));//
		phoneticMap.put("a" , new PhoneticInfo(new double[]{0.00, 0.42, 0.00, 0.53, 0.20, 0.15}, "v", "s", "3", "2", "-"));
		phoneticMap.put("6" , new PhoneticInfo(new double[]{0.00, 0.42, 0.00, 0.53, 0.20, 0.15}, "v", "a", "3", "2", "-"));
		phoneticMap.put("@" , new PhoneticInfo(new double[]{0.00, 0.42, 0.00, 0.53, 0.20, 0.15}, "v", "a", "2", "2", "-"));
		phoneticMap.put("aI", new PhoneticInfo(new double[]{0.00, 0.42, 0.00, 0.53, 0.20, 0.15}, "v", "d", "3", "1", "-"));
		phoneticMap.put("OY", new PhoneticInfo(new double[]{0.00, 0.42, 0.00, 0.53, 0.20, 0.15}, "v", "d", "2", "3", "+"));
		phoneticMap.put("aU", new PhoneticInfo(new double[]{0.00, 0.42, 0.00, 0.53, 0.20, 0.15}, "v", "d", "3", "2", "+"));
		phoneticMap.put("EI", new PhoneticInfo(new double[]{0.16, 0.60, 0.00, 0.00, 0.00, 0.25}, "v", "d", "2", "1", "-"));//
		phoneticMap.put("a~", new PhoneticInfo(new double[]{0.16, 0.55, 0.00, 0.00, 0.00, 0.20}, "v", "l", "3", "2", "-"));
		phoneticMap.put("e~", new PhoneticInfo(new double[]{0.16, 0.55, 0.00, 0.00, 0.00, 0.20}, "v", "l", "2", "1", "-"));
		phoneticMap.put("o~", new PhoneticInfo(new double[]{0.16, 0.55, 0.00, 0.00, 0.00, 0.20}, "v", "l", "2", "3", "+"));
		phoneticMap.put("9~", new PhoneticInfo(new double[]{0.16, 0.55, 0.00, 0.00, 0.00, 0.20}, "v", "l", "2", "2", "+"));
		// final German vowels block
		// Arabic vowels
		phoneticMap.put("aa", new PhoneticInfo(new double[]{0.11, 0.30, 0.00, 0.00, 0.00, 0.15}, "v", "l", "3", "2", "-"));//
		phoneticMap.put("AA", new PhoneticInfo(new double[]{0.11, 0.30, 0.00, 0.00, 0.00, 0.15}, "v", "s", "3", "2", "-"));//
		phoneticMap.put("A",  new PhoneticInfo(new double[]{0.11, 0.30, 0.00, 0.00, 0.00, 0.15}, "v", "s", "3", "2", "-"));//
		phoneticMap.put("uu0",new PhoneticInfo(new double[]{0.18, 0.65, 0.00, 0.00, 0.00, 0.20}, "v", "l", "1", "3", "+"));//
		phoneticMap.put("u0", new PhoneticInfo(new double[]{0.18, 0.65, 0.00, 0.00, 0.00, 0.20}, "v", "s", "1", "3", "+"));//
		phoneticMap.put("UU0",new PhoneticInfo(new double[]{0.00, 0.00, 0.00, 0.63, 0.00, 0.00}, "v", "s", "1", "3", "+"));//
		phoneticMap.put("U0", new PhoneticInfo(new double[]{0.00, 0.00, 0.00, 0.63, 0.00, 0.00}, "v", "s", "1", "3", "+"));//
		phoneticMap.put("U1", new PhoneticInfo(new double[]{0.00, 0.00, 0.00, 0.63, 0.00, 0.00}, "v", "s", "1", "3", "+"));//
		phoneticMap.put("UU1",new PhoneticInfo(new double[]{0.00, 0.00, 0.00, 0.63, 0.00, 0.00}, "v", "s", "1", "3", "+"));//
		phoneticMap.put("uu1",new PhoneticInfo(new double[]{0.00, 0.00, 0.00, 0.63, 0.00, 0.00}, "v", "s", "1", "3", "+"));//
		phoneticMap.put("u1", new PhoneticInfo(new double[]{0.00, 0.00, 0.00, 0.63, 0.00, 0.00}, "v", "s", "1", "3", "+"));//
		phoneticMap.put("ii0",new PhoneticInfo(new double[]{0.18, 0.65, 0.00, 0.00, 0.00, 0.20}, "v", "l", "1", "1", "-"));//
		phoneticMap.put("i0", new PhoneticInfo(new double[]{0.18, 0.65, 0.00, 0.00, 0.00, 0.20}, "v", "s", "1", "1", "-"));//
		phoneticMap.put("ii1",new PhoneticInfo(new double[]{0.18, 0.65, 0.00, 0.00, 0.00, 0.20}, "v", "s", "1", "1", "-"));//
		phoneticMap.put("i1", new PhoneticInfo(new double[]{0.18, 0.65, 0.00, 0.00, 0.00, 0.20}, "v", "s", "1", "1", "-"));//
		phoneticMap.put("II0",new PhoneticInfo(new double[]{0.18, 0.65, 0.00, 0.00, 0.00, 0.20}, "v", "s", "1", "1", "-"));//
		phoneticMap.put("I0", new PhoneticInfo(new double[]{0.18, 0.65, 0.00, 0.00, 0.00, 0.20}, "v", "s", "1", "1", "-"));//
		phoneticMap.put("I1", new PhoneticInfo(new double[]{0.18, 0.65, 0.00, 0.00, 0.00, 0.20}, "v", "s", "1", "1", "-"));//
		//
		// mapping for lips and mouth position: consonant  jaw /smile / air /kiss/ close /sad - v/c type  place null vox
		phoneticMap.put("p" , new PhoneticInfo(new double[]{0.16, 0.55, 0.00, 0.00, 0.00, 0.20}, "c", "s", "l", "-", "-"));
		phoneticMap.put("t" , new PhoneticInfo(new double[]{0.16, 0.55, 0.00, 0.00, 0.00, 0.20}, "c", "s", "a", "-", "-"));
		phoneticMap.put("k",  new PhoneticInfo(new double[]{0.05, 0.25, 0.18, 0.43, 0.50, 0.10}, "c", "s", "v", "-", "-"));
		phoneticMap.put("b",  new PhoneticInfo(new double[]{0.05, 0.15, 0.00, 0.53, 0.00, 0.00}, "c", "s", "l", "+", "+"));
		phoneticMap.put("d",  new PhoneticInfo(new double[]{0.18, 0.25, 0.00, 0.43, 0.00, 0.10}, "c", "s", "a", "+", "+"));
		phoneticMap.put("g",  new PhoneticInfo(new double[]{0.08, 0.25, 0.00, 0.43, 0.00, 0.15}, "c", "s", "v", "+", "+"));
		phoneticMap.put("f",  new PhoneticInfo(new double[]{0.08, 0.25, 0.00, 0.43, 0.00, 0.15}, "c", "f", "b", "-", "-"));
		phoneticMap.put("v",  new PhoneticInfo(new double[]{0.08, 0.25, 0.00, 0.43, 0.00, 0.15}, "c", "f", "b", "+", "+"));
		phoneticMap.put("T",  new PhoneticInfo(new double[]{0.10, 0.55, 0.00, 0.40, 0.05, 0.30}, "c", "f", "d", "-", "-"));//
		phoneticMap.put("D",  new PhoneticInfo(new double[]{0.10, 0.55, 0.00, 0.40, 0.05, 0.30}, "c", "f", "d", "+", "+"));//
		phoneticMap.put("s",  new PhoneticInfo(new double[]{0.10, 0.55, 0.00, 0.40, 0.05, 0.30}, "c", "f", "a", "-", "-"));//
		phoneticMap.put("z",  new PhoneticInfo(new double[]{0.10, 0.55, 0.00, 0.40, 0.05, 0.30}, "c", "f", "a", "+", "+"));//
		phoneticMap.put("S",  new PhoneticInfo(new double[]{0.10, 0.55, 0.00, 0.40, 0.05, 0.30}, "c", "f", "p", "-", "-"));//
		phoneticMap.put("Z",  new PhoneticInfo(new double[]{0.10, 0.55, 0.00, 0.40, 0.05, 0.30}, "c", "f", "p", "+", "+"));//
		phoneticMap.put("x",  new PhoneticInfo(new double[]{0.10, 0.55, 0.00, 0.40, 0.05, 0.30}, "c", "f", "u", "-", "-"));//
		phoneticMap.put("C",  new PhoneticInfo(new double[]{0.10, 0.55, 0.00, 0.48, 0.05, 0.30}, "c", "f", "v", "-", "-"));//
		phoneticMap.put("h",  new PhoneticInfo(new double[]{0.10, 0.56, 0.00, 0.40, 0.00, 0.30}, "c", "f", "g", "-", "-"));//
		phoneticMap.put("pf", new PhoneticInfo(new double[]{0.10, 0.55, 0.00, 0.43, 0.00, 0.30}, "c", "a", "l", "-", "-"));//
		phoneticMap.put("ts", new PhoneticInfo(new double[]{0.18, 0.35, 0.00, 0.30, 0.00, 0.15}, "c", "a", "a", "-", "-"));//
		phoneticMap.put("tS", new PhoneticInfo(new double[]{0.11, 0.15, 0.00, 0.00, 0.60, 0.05}, "c", "a", "p", "-", "-"));//
		phoneticMap.put("l",  new PhoneticInfo(new double[]{0.11, 0.30, 0.00, 0.00, 0.00, 0.15}, "c", "l", "a", "+", "+"));//
		phoneticMap.put("m",  new PhoneticInfo(new double[]{0.08, 0.15, 0.00, 0.00, 0.50, 0.10}, "c", "n", "l", "+", "+"));//
		phoneticMap.put("n",  new PhoneticInfo(new double[]{0.18, 0.25, 0.00, 0.00, 0.40, 0.20}, "c", "n", "a", "+", "+"));//
		phoneticMap.put("N",  new PhoneticInfo(new double[]{0.18, 0.20, 0.00, 0.10, 0.40, 0.20}, "c", "n", "v", "+", "+"));//
		phoneticMap.put("R",  new PhoneticInfo(new double[]{0.15, 0.20, 0.00, 0.10, 0.40, 0.05}, "c", "l", "u", "+", "+"));//
		phoneticMap.put("r",  new PhoneticInfo(new double[]{0.15, 0.20, 0.00, 0.10, 0.40, 0.05}, "c", "r", "a", "+", "+"));//
		phoneticMap.put("w",  new PhoneticInfo(new double[]{0.15, 0.10, 0.00, 0.10, 0.40, 0.05}, "c", "r", "l", "+", "+"));//
		phoneticMap.put("j",  new PhoneticInfo(new double[]{0.20, 0.10, 0.00, 0.80, 0.00, 0.00}, "c", "r", "p", "+", "+"));//
		phoneticMap.put("?",  new PhoneticInfo(new double[]{0.20, 0.10, 0.00, 0.80, 0.00, 0.00}, "c", "s", "g", "-", "-"));//
		// SILENCE
		phoneticMap.put("_",new PhoneticInfo(new double[]{0.00, 0.00, 0.00, 0.00, 0.00, 0.00},  "c",  "",  "",  "",  ""));
		// Turkish consonants
		phoneticMap.put("G",  new PhoneticInfo(new double[]{0.08, 0.25, 0.00, 0.43, 0.00, 0.15}, "c", "n", "b", "+", "-"));
		phoneticMap.put("dZ", new PhoneticInfo(new double[]{0.10, 0.55, 0.00, 0.40, 0.05, 0.30}, "c", "a", "p", "+", "+"));//
		phoneticMap.put("L",  new PhoneticInfo(new double[]{0.11, 0.30, 0.00, 0.00, 0.00, 0.15}, "c", "l", "a", "+", "+"));//
		// Arabic consonants
		phoneticMap.put("&lt",new PhoneticInfo(new double[]{0.11, 0.30, 0.00, 0.00, 0.00, 0.15}, "c", "s", "g", "+", "+"));//
		phoneticMap.put("^",  new PhoneticInfo(new double[]{0.11, 0.30, 0.00, 0.00, 0.00, 0.15}, "c", "f", "a", "-", "-"));//
		phoneticMap.put("H",  new PhoneticInfo(new double[]{0.10, 0.56, 0.00, 0.40, 0.00, 0.30}, "c", "f", "g", "-", "-"));//
		phoneticMap.put("*",  new PhoneticInfo(new double[]{0.10, 0.56, 0.00, 0.40, 0.00, 0.30}, "c", "f", "a", "+", "+"));//
		phoneticMap.put("$",  new PhoneticInfo(new double[]{0.10, 0.56, 0.00, 0.40, 0.00, 0.30}, "c", "f", "p", "-", "-"));//
		phoneticMap.put("q",  new PhoneticInfo(new double[]{0.10, 0.56, 0.00, 0.40, 0.00, 0.30}, "c", "s", "v", "+", "+"));//
		phoneticMap.put("&lt&lt",new PhoneticInfo(new double[]{0.11, 0.30, 0.00, 0.00, 0.00, 0.15},"c", "s", "g", "+", "+"));//
		phoneticMap.put("bb", new PhoneticInfo(new double[]{0.05, 0.15, 0.00, 0.53, 0.00, 0.00}, "c", "s", "l", "+", "+"));
		phoneticMap.put("tt", new PhoneticInfo(new double[]{0.16, 0.55, 0.00, 0.00, 0.00, 0.20}, "c", "s", "a", "-", "-"));
		phoneticMap.put("^^", new PhoneticInfo(new double[]{0.11, 0.30, 0.00, 0.00, 0.00, 0.15}, "c", "f", "a", "-", "-"));//
		phoneticMap.put("jj", new PhoneticInfo(new double[]{0.20, 0.10, 0.00, 0.80, 0.00, 0.00}, "c", "s", "p", "+", "+"));//
		phoneticMap.put("HH", new PhoneticInfo(new double[]{0.10, 0.56, 0.00, 0.40, 0.00, 0.30}, "c", "f", "g", "-", "-"));//
		phoneticMap.put("xx", new PhoneticInfo(new double[]{0.10, 0.55, 0.00, 0.40, 0.05, 0.30}, "c", "f", "g", "-", "-"));//
		phoneticMap.put("dd", new PhoneticInfo(new double[]{0.18, 0.25, 0.00, 0.43, 0.00, 0.10}, "c", "s", "a", "+", "+"));
		phoneticMap.put("**", new PhoneticInfo(new double[]{0.10, 0.56, 0.00, 0.40, 0.00, 0.30}, "c", "f", "a", "+", "+"));//
		phoneticMap.put("rr", new PhoneticInfo(new double[]{0.15, 0.20, 0.00, 0.10, 0.40, 0.05}, "c", "r", "a", "+", "+"));//
		phoneticMap.put("zz", new PhoneticInfo(new double[]{0.10, 0.55, 0.00, 0.40, 0.05, 0.30}, "c", "f", "a", "+", "+"));//
		phoneticMap.put("ss", new PhoneticInfo(new double[]{0.10, 0.55, 0.00, 0.40, 0.05, 0.30}, "c", "f", "a", "-", "-"));//
		phoneticMap.put("$$", new PhoneticInfo(new double[]{0.10, 0.56, 0.00, 0.40, 0.00, 0.30}, "c", "f", "p", "-", "-"));//
		phoneticMap.put("SS", new PhoneticInfo(new double[]{0.10, 0.56, 0.00, 0.40, 0.00, 0.30}, "c", "f", "a", "-", "-"));//
		phoneticMap.put("DD", new PhoneticInfo(new double[]{0.10, 0.55, 0.00, 0.40, 0.05, 0.30}, "c", "f", "a", "+", "+"));//
		phoneticMap.put("TT", new PhoneticInfo(new double[]{0.10, 0.55, 0.00, 0.40, 0.05, 0.30}, "c", "s", "a", "+", "+"));//
		phoneticMap.put("ZZ", new PhoneticInfo(new double[]{0.10, 0.55, 0.00, 0.40, 0.05, 0.30}, "c", "f", "a", "+", "+"));//
		phoneticMap.put("EE", new PhoneticInfo(new double[]{0.10, 0.56, 0.00, 0.40, 0.00, 0.30}, "c", "a", "g", "+", "+"));//
		phoneticMap.put("gg", new PhoneticInfo(new double[]{0.08, 0.25, 0.00, 0.43, 0.00, 0.15}, "c", "a", "g", "+", "+"));
		phoneticMap.put("ff", new PhoneticInfo(new double[]{0.08, 0.25, 0.00, 0.43, 0.00, 0.15}, "c", "f", "b", "-", "-"));
		phoneticMap.put("qq", new PhoneticInfo(new double[]{0.10, 0.56, 0.00, 0.40, 0.00, 0.30}, "c", "s", "v", "+", "+"));//
		phoneticMap.put("kk", new PhoneticInfo(new double[]{0.05, 0.25, 0.18, 0.43, 0.50, 0.10}, "c", "s", "v", "-", "-"));
		phoneticMap.put("ll", new PhoneticInfo(new double[]{0.11, 0.30, 0.00, 0.00, 0.00, 0.15}, "c", "l", "a", "+", "+"));//
		phoneticMap.put("mm", new PhoneticInfo(new double[]{0.08, 0.15, 0.00, 0.00, 0.50, 0.10}, "c", "n", "l", "+", "+"));//
		phoneticMap.put("nn", new PhoneticInfo(new double[]{0.08, 0.15, 0.00, 0.00, 0.50, 0.10}, "c", "n", "a", "+", "+"));//
		phoneticMap.put("hh", new PhoneticInfo(new double[]{0.08, 0.15, 0.00, 0.00, 0.50, 0.10}, "c", "f", "g", "-", "-"));//
		phoneticMap.put("ww", new PhoneticInfo(new double[]{0.08, 0.15, 0.00, 0.00, 0.50, 0.10}, "c", "r", "l", "+", "+"));//
		phoneticMap.put("yy", new PhoneticInfo(new double[]{0.08, 0.15, 0.00, 0.00, 0.50, 0.10}, "c", "r", "p", "+", "+"));//
		phoneticMap.put("pp", new PhoneticInfo(new double[]{0.08, 0.15, 0.00, 0.00, 0.50, 0.10}, "c", "s", "l", "-", "-"));//
		phoneticMap.put("dist", new PhoneticInfo(new double[]{0.08, 0.15, 0.00, 0.00, 0.50, 0.10}, "c", "s", "l", "-", "-"));

	}
	
	public double[] getMappingPoints(String label) {
		
		PhoneticInfo info = phoneticMap.get(label);
		if (info == null) {
			System.out.println(label);
		}
		
		double arousal = 0.15;/*  */
		if (arousal > 0){
			//System.out.printf("Valor previ: %f\n", info.points[1]);
			info.points[1] = info.points[1] * (1+(arousal/2));
			//System.out.printf("Valor post: %f\n", info.points[1]);
		}
		
		
		return info.points;
	}
	/*
	public double[] getMapping(String label) {
		
		PhoneticInfo info = phoneticMap.get(label);
		return info.points;
	}**/
	
	// this function applies a factor depending if the letter is a vowel or consonant:
	// as vowel have full effect from mapping, otherwise the effect is reduced 50%
	// 
	public boolean getMappingLet(String label) {
				
		PhoneticInfo info = phoneticMap.get(label);
		boolean consonant = true;
		if (info.value1 == "v") 
			consonant = false;
		return consonant;
	}
	
	public String getMappingType(String label) {
		// on vowels this is the time: long or short for utter it		
		PhoneticInfo info = phoneticMap.get(label);
		return info.value2;
	}
	
	public String getMappingPos(String label) {
		// on vowels this is how open is the mouth
		// on consonants is the place of utterance
		PhoneticInfo info = phoneticMap.get(label);
		return info.value3;
	}
	
	public String getMappingFront(String label) {
		// on vowels this is the front position relative
		// on consonants this a NULL value		
		PhoneticInfo info = phoneticMap.get(label);
		return info.value4;
	}
	
	public String getMappingVox(String label) {
		// this is the voiced level or prominence
		PhoneticInfo info = phoneticMap.get(label);
		return info.value5;
	}
}
