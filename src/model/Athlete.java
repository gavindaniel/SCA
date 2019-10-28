package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Athlete {

	List<Evaluation> evaluations;

	public Athlete() {
		evaluations = new ArrayList<Evaluation>();
	}

	public int getAnswer(int eval, int qNum) {
		return evaluations.get(eval).getAnswer(qNum);
	}
	public void setAnswer(int eval, int qNum, int ans) {
		Evaluation tempEval = evaluations.get(eval);
		tempEval.setAnswer(qNum, ans);
		evaluations.set(eval, tempEval);
	}
	
	public List<Evaluation> getEvaluations() {
		return evaluations;
	}
	
	public int getNumEvals() {
		return evaluations.size();
	}
	
	public Evaluation getEval(int index) {
		return evaluations.get(index);
	}
	
	public void addEvaluation(Evaluation e) {
		// no evaluations
		if (evaluations.size() < 5) {
			evaluations.add(e);
		} else {
			for (int i=0; i <= 3; i++) {
				Evaluation temp = evaluations.get(i+1);
				evaluations.set(i, temp);
			}
			evaluations.set(4, e);
		}
		
	}
	
	public void printEvaluations() {
		for (int i = 0; i < evaluations.size(); i++) {
			System.out.println("Evaluation " + (i+1));
			for (int j = 0; j < 22; j++) {
				System.out.println("\tAnswer to  Q" + (i+1) + ": " + evaluations.get(i).getAnswer(j));
			}
		}
		
		
	}
	
	public boolean checkIfPreviousEvalExists(int eNum) {
		if (evaluations.size() > 1) {
			if ((eNum-2) >= 0) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	public Evaluation getPrevEval(int eNum) {
		return evaluations.get(eNum-1);
	}

	public void printOverallRating(int eNum) {
		if (checkIfPreviousEvalExists(eNum) == true) {
			System.out.println("\tOverall rating: " + evaluations.get(eNum-1).getOverallRating(evaluations.get(eNum-2)));
		} else {
			System.out.println("\tOverall rating: Unsure (no previous evaluation to compare to)");
		}
		
	}
	
	
}