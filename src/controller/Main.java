package controller;

import model.Athlete;
import model.Evaluation;

import java.util.Scanner; // Import the Scanner class

public class Main {

	

	public static void main(String[] args) {

		Athlete athlete = new Athlete();
		
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
			System.out.println();
			System.out.println("******************** Sport Concussion Assessment ********************");
			System.out.println();
			System.out.print("Enter [1] for New Evaluation or [2] to See Evaluation Summaries or [3] to See If At Risk: ");
			answer = scanner.nextLine(); // Read user input
			try {
				answerInt = Integer.parseInt(answer);
				// New Evaluation
				if (answerInt == 1) {
					System.out.println();
					Evaluation eval = new Evaluation();
					int i = 0;
					System.out.println("Please Enter a Score [0-6] for each Question " + helpText + ": ");
					System.out.println();
					while(i < 22) {
//						System.out.print("Q" + (i+1) + ": " + questions[i] + " " + helpText + ": ");
						System.out.print("Q" + (i+1) + ": " + questions[i] + ": ");
						answer = scanner.nextLine(); // Read user input
						try {
							answerInt = Integer.parseInt(answer);
						
							if ((answerInt >= 0) && (answerInt <= 6)) {
								eval.setAnswer(i, answerInt);
								i++;
							}
							else {
								if (answer.compareTo("back") == 0 || answer.compareTo("quit") == 0) {
									break;
								} else {
									System.out.println("\tError: Enter a Valid Number " + helpText);
								}
							}
						} catch (NumberFormatException e) {
							System.out.println("\tError: Enter a Valid Number " + helpText);
						}
					}
					System.out.println();
					System.out.println("********** Evaluation Complete **********");
					athlete.addEvaluation(eval);
					eval.printNumSymptoms();
					eval.printSeverityScore();
					athlete.printOverallRating(athlete.getNumEvals());
					
				// See Previous Evaluation Summaries
				} else if (answerInt == 2) {
					System.out.println("\tSelected: [2] View Evaluation Summaries");
					System.out.println();
					
					if (athlete.getNumEvals() > 0) { 
						if (athlete.getNumEvals() == 1) {
							System.out.print("Enter [1] to View Last Game Evaulation Summary: ");
							answer = scanner.nextLine(); // Read user input
						}
						else { 
							for (int i=0; i < athlete.getNumEvals(); i++) {
								if (i == 0) {
									System.out.println("Enter [1] to View Last Game Evaulation Summary,");
								} else {
									System.out.print("Enter [" + (i+1) + "] to View " + (i+1) + " Games Ago Evaluation Summary");
									if (i == (athlete.getNumEvals()-1)) {
										System.out.print(": ");
									} else {
										System.out.println(",");
									}
								}
							}
							answer = scanner.nextLine(); // Read user input
						}
						try {
							answerInt = Integer.parseInt(answer);
							if (answerInt >= 1 && answerInt <= athlete.getNumEvals()) {
								Evaluation e = athlete.getEval(answerInt-1);
								System.out.println();
								System.out.println("********** Evaluation Summary **********");
								e.printNumSymptoms();
								e.printSeverityScore();
								athlete.printOverallRating(answerInt);
								System.out.println();
							} else {
								System.out.println("\tError: Enter a Valid Number");
							}
						} catch (NumberFormatException e) {
							System.out.println("\tError: Enter a Valid Number");
						}
					} else {
						System.out.println("No evaluations on record. Please submit an evaluation first.");
					}
				} else if (answerInt == 3) {
					athlete.printOverallRating(athlete.getNumEvals());
				}
				else {
					System.out.println("\tError: Enter a Valid Number: " + answerInt);
				}
			} catch (NumberFormatException e) {
				if (answer.compareTo("quit") == 0) {
					break;
				} else {
					System.out.println("\tError: Enter a Valid Number");
				}
			}
		} 
		scanner.close();
		System.out.println();
		System.out.println("******************** Application Terminated ********************");
	}

}