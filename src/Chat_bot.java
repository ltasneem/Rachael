import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

/*
 * Eliza Chat Bot Implementation with 'Sentiments'
 * 
 * Toma Tadros
 * Srikant Kumar Kalaputapu
 * Taimur Sohrab
 * Lubaba Nuzhat Tasneem
 *  
 * June 28th, 2017
 */
public class Chat_bot {

	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		Random rand = new Random();
		long startTime = System.currentTimeMillis();
		
		//get patient name
		System.out.println("Enter your name. I will see if I can pull up any old records for you.");
		String patient = keyboard.nextLine();
		
		
		//get old sessions or create new patient file
		Conversation cv = new Conversation();
		HashMap<String, ArrayList<String>> prevConvos;
		if (!(cv.create_patient_directory(patient))) {
			prevConvos = cv.load_sessions(patient);
		}
		
		
		ArrayList<String> log = new ArrayList<String>();
		
		
		//Therapist rachael = new Therapist();
		String input = "";
		System.out.println("Welcome to your therapy session! You can call me Dr. Rachael. What would you like to talk about?");
		log.add("Welcome to your therapy session! You can call me Dr. Rachael. What would you like to talk about?");
		input = keyboard.nextLine();
		int endSessionCount = 0;
		while (!input.equals("q")) {
			if (input.equals("q") && endSessionCount < 3) {
				System.out.print("Before you leave...");
			} else if (input.equals("q") && endSessionCount >= 3) {
				break;
			}
			int responseDecision = rand.nextInt(100);
			if (responseDecision < 5) {
				//look back at old convo
			} else if (responseDecision >= 5 && responseDecision < 10) {
				//sentiment analysis
			} else if (responseDecision >= 10 && responseDecision < 40) {
				//question
			} else if (responseDecision >= 40 && responseDecision < 70) {
				//qualify
			} else {
				//hedge
			}
		}
		long endTime = System.currentTimeMillis();
		long sessionTime = endTime - startTime;
		double cost = (sessionTime / 60000.0) * 10;
		cv.create_session(patient, log);
		System.out.printf("You owe me $%.02f for this session. Thanks for your time!", cost);
		
	}

}
