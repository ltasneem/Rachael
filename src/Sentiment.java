import java.util.*;
import java.io.*;
import java.nio.file.Paths;

public class Sentiment {
	
	private Set<String> positive = new HashSet<String>();
	private Set<String> negative = new HashSet<String>();
	private Set<String> neutral = new HashSet<String>();
	private File posFile;
	private File negFile;
	private File neuFile;
	
	private HashMap<String,Set<String>> sentimentMap = new HashMap<String,Set<String>>();
	
	public Sentiment(){
		File root = new File(Paths.get(".").toAbsolutePath().normalize().toString());

		while(!root.getName().equals("Rachael")){
		 	root = root.getParentFile();
		}
		String path = root.getAbsolutePath() + "/Sentiments/";

		posFile = new File(path + "positive-words-1.txt");
		negFile = new File(path + "negative-words-1.txt");
		neuFile = new File(path + "neutral-words-1.txt");
		sentimentMap.put("Positive",positive);
		sentimentMap.put("Negative",negative);
		sentimentMap.put("Neutral",neutral);
		loadWords();
			
		
	}

	public void loadWords() {

			
		try {
			Scanner sc = new Scanner(posFile);
			while (sc.hasNextLine()) {
				String word = sc.nextLine();
				sentimentMap.get("Positive").add(word);
				
			}
			sc.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		try {
			Scanner sc = new Scanner(negFile);
			while (sc.hasNextLine()) {
				String word = sc.nextLine();
				sentimentMap.get("Negative").add(word);
				
			}
			sc.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			Scanner sc = new Scanner(neuFile);
			while (sc.hasNextLine()) {
				String word = sc.nextLine();
				sentimentMap.get("Neutral").add(word);
				
			}
			sc.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	 
	}

	public boolean addWord(String word, String emotion) {
		if (!(emotion.equals("Positive") || emotion.equals("Negative") || emotion.equals("Neutral"))) {
			System.out.println("I am sorry I didnt understand your feelings.");
			return false;
		}

		sentimentMap.get(emotion).add(word);
		return true;


	}

	/**
	* Determines the emotion of the input the user typed in. If the word does not exist
	* in the ChatBot's dictionary, add it.	
	* @param input - what the user conveyed to the ChatBot
	* @return positive integer when emotion is positive
	*		  negative integer when emotion is negative
	*		  0 when emotion is neutral 			
	*/
	public int getEmotion(String input) {
		String[] words = input.split(" ");
		int totalEmotion = 0;
		for (int i = 0; i < words.length; i++) {
			String emotion = findWord(words[i]);
			if (emotion.equals("Positive")) {
				totalEmotion++;
			} else if (emotion.equals("Negative")) {
				totalEmotion--;
			} else if (emotion.equals("Not Found")) {
				Scanner sc = new Scanner(System.in);
				System.out.println("I do not recognize the word " + words[i] + ". Is it 'Positive', 'Negative', or 'Neutral'?");
				String newEmotion = sc.nextLine();
				addWord(words[i], newEmotion);
				if (newEmotion.equals("Positive")) {
					totalEmotion++;
				} else if (newEmotion.equals("Negative")) {
					totalEmotion--;
				}
			}
		}
		return totalEmotion;
	}

	private String findWord(String word) {
		Set<String> keys = sentimentMap.keySet();
		Iterator<String> iter = keys.iterator();
		for (int i = 0; i < keys.size(); i++) {
			String key = iter.next();
			if (sentimentMap.get(key).contains(word)) {
				return key;
			}
		}
		return "Not Found";
	}
}
