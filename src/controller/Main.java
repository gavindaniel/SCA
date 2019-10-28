package controller;

import model.Athlete;
import model.Evaluation;
import model.Practitioner;

import java.util.Scanner; // Import the Scanner class

public class Main {

	

	public static void main(String[] args) {

		Athlete athlete = new Athlete();
		Practitioner practitioner = new Practitioner();
		
		String helpText = "(None [0], Mild [1-2], Moderate [3-4], Severe [5-6])";
		String answer = "";
		Integer answerInt = -1;
		
		String[] questions = new String[22];
		
		questions[0] = "Headache";
		questions[1] = "Pressure in head";
		questions[2] = "Neck pain";
		questions[3] = "Nausea or vomitting";
		questions[4] = "Dizziness";
		questions[5] = "Blurred vision";
		questions[6] = "Balance problems";
		questions[7] = "Sensitivity to light";
		questions[8] = "Sensitivity to noise";
		questions[9] = "Feeling slowed down";
		questions[10] = "Feeling like 'in a fog'";
		questions[11] = "'Don't feel right'";
		questions[12] = "Difficulty concentrating";
		questions[13] = "Dfficulty remembering";
		questions[14] = "Fatigue or low energy";
		questions[15] = "Confusion";
		questions[16] = "Drowsiness";
		questions[17] = "Trouble failing asleep";
		questions[18] = "More emotional";
		questions[19] = "Irritability";
		questions[20] = "Sadness";
		questions[21] = "Nervous or anxious";
		
		Scanner scanner = new Scanner(System.in); // Create a Scanner object

		
//		System.out.println("User entered: " + personType); // Output user input

		while (answer != "quit" ) { 
			System.out.println("******************** Sport Concussion Assessment ********************");

			System.out.print("Enter [1] for Athlete or [2] for Practitioner: ");
			answer = scanner.nextLine(); // Read user input
			try {
				answerInt = Integer.parseInt(answer);
				// athlete 
				System.out.println("Entered: " + answer);
				if (answerInt == 1) {
					System.out.print("Enter [1] for New Evaluation or [2] to See Evaluation Summaries: ");
					answer = scanner.nextLine(); // Read user input
					try {
						answerInt = Integer.parseInt(answer);
						// New Evaluation
						if (answerInt == 1) {
							Evaluation eval = new Evaluation();
							int i = 0;
							while(i < 22) {
								System.out.print("Q" + (i+1) + ": " + questions[i] + " " + helpText + ": ");
								answer = scanner.nextLine(); // Read user input
								try {
									answerInt = Integer.parseInt(answer);
								
									if ((answerInt >= 0) && (answerInt <= 6)) {
										eval.setAnswer(i, answerInt);
										i++;
									}
									else {
										System.out.println("\tError: Enter a Valid Number");
									}
								} catch (NumberFormatException e) {
									System.out.println("\tError: Enter a Valid Number");
								}
							}
//							System.out.println("********** Evaluation Complete **********");
							athlete.addEvaluation(eval);
							eval.printNumSymptoms();
							eval.printSeverityScore();
							athlete.printOverallRating(athlete.getNumEvals());
							
						// See Previous Evaluation Summaries
						} else if (answerInt == 2) {
							
						} else {
							System.out.println("\tError: Enter a Valid Number: " + answerInt);
						}
					} catch (NumberFormatException e) {
						System.out.println("\tError: Enter a Valid Number");
					}
				// practitioner
				} else if (answerInt == 2) {
						
				} else {
					System.out.println("\tError: Enter a Valid Number: " + answerInt);
				}
			} catch (NumberFormatException e) {
				System.out.println("\tError: Enter a Valid Number");	
			}
		} 
		scanner.close();
	}

}