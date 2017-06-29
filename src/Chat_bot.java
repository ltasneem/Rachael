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
		HashMap<String, ArrayList<String>> prevConvos = null;
		if (!(cv.create_patient_directory(patient))) {
			prevConvos = cv.load_sessions(patient);
		}
		
		
		ArrayList<String> log = new ArrayList<String>();
		
		
		Therapist rachael = new Therapist();
		String input = "";
		System.out.println("Welcome to your therapy session! You can call me Dr. Rachael. What would you like to talk about?");
		log.add("Welcome to your therapy session! You can call me Dr. Rachael. What would you like to talk about?");
		input = keyboard.nextLine().toLowerCase();
		log.add(input);
		int endSessionCount = 0;
		while (!input.equals("q") || endSessionCount < 4) {
			if (input.equals("q")){
				if (endSessionCount == 0){
					System.out.print("You want to leave? All right but before you go, tell me ");
				}
				else if (endSessionCount == 1){
					System.out.print("Why are you in such a rush? Listen, just tell me ");
				}
				else if (endSessionCount == 2){
					System.out.print("You want to leave that bad?  Can you just hold on for one second? I need you to tell me ");
				}
				else{
					System.out.println("Fine. Leave then.");
					break;
				}
				String question_response = rachael.question();
				System.out.println(question_response);
				log.add(question_response);
				endSessionCount++;
				input = keyboard.nextLine();
				log.add(input);
				input = input.toLowerCase();
				continue;
			}

			int responseDecision = rand.nextInt(100);
			if (responseDecision < 5) {
				//look back at old convo   * change to input 
				ArrayList<String> lookBack;
				if (prevConvos != null) {
					int randConvo = rand.nextInt(prevConvos.keySet().size() + 1);
					lookBack = (randConvo == prevConvos.keySet().size()) ? log : prevConvos.get("session" + randConvo);
				} else lookBack = log;
				int randStatementIndex = rand.nextInt(lookBack.size() / 2);
				String randStatement = lookBack.get(randStatementIndex * 2 + 1);
				String response = "Earlier you said " + randStatement + ". Tell me why.";
				System.out.println(response);
				log.add(response);
				
			} else if (responseDecision >= 5 && responseDecision < 10) {
				String sentiment_response = rachael.sentiment(input);
				System.out.println(sentiment_response);
				log.add(sentiment_response);

			} else if (responseDecision >= 10 && responseDecision < 40) {
				String question_response = rachael.question();
				System.out.println(question_response);
				log.add(question_response);

			} else if (responseDecision >= 40 && responseDecision < 70) {
				//qualify
				String response = rachael.qualify(input);
				System.out.println(response);
				log.add(response);

			} else {
				//hedge
				String hedge_response = rachael.hedge();
				System.out.println(hedge_response);
				log.add(hedge_response);
			}

			input = keyboard.nextLine();
			log.add(input);
			input = input.toLowerCase();
		}
		long endTime = System.currentTimeMillis();
		long sessionTime = endTime - startTime;
		double cost = (sessionTime / 60000.0) * 10;
		cv.create_session(patient, log);
		System.out.printf("You owe me $%.02f for this session. Thanks for your time!", cost);
		
	}

}
