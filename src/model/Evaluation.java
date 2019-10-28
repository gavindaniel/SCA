package model;

import java.util.Arrays;

public class Evaluation {

	Integer[] answers = new Integer[22];
//	Integer severity = 
	
	public void printEvaluation() {
		
		for (int i = 0; i < answers.length; i++) {
			System.out.println("Answer to  Q" + (i+1) + ": " + answers[i]);
		}
		
	}

	public int getAnswer(int qNum) {
		return answers[qNum];
	}
	
	public void setAnswer(int qNum, int ans) {
		answers[qNum] = ans;
	}
	
	public int getNumSymptoms() {
		int num = 0;
		for (int i=0; i < 22; i++) {
			if (answers[i] > 0) {
				num++;
			}
		}
		return num;
	}
	
	public int getSeverityScore() {
		int num = 0;
		for (int i=0; i < 22; i++) {
			num += answers[i];
		}
		return num;
	}
	
	public String getOverallRating(Evaluation prevEval) {
		if ((Math.abs(getNumSymptoms() - prevEval.getNumSymptoms()) < 3) && (Math.abs(getSeverityScore() - prevEval.getSeverityScore()) < 10)) {
			return "No difference";
		} 
		if ((Math.abs(getNumSymptoms() - prevEval.getNumSymptoms()) < 3) && (Math.abs(getSeverityScore() - prevEval.getSeverityScore()) >= 10)) {
			return "Unsure";
		}
		if ((Math.abs(getNumSymptoms() - prevEval.getNumSymptoms()) >= 3) || (Math.abs(getSeverityScore() - prevEval.getSeverityScore()) >= 15)) {
			return "Very different";
		}
		return "Unsure";
	}
	
	public void printNumSymptoms() {
		System.out.println("\tTotal number of symptoms (max. possible 22): " + getNumSymptoms());
	}
	
	public void printSeverityScore() {
		System.out.println("\tSymptom severity score (max. possible 22 x 6 = 132): " + getSeverityScore());
	}
	
	
}