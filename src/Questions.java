
/*
 * Represents series of predetermined Questions for a Eliza chatbot implementation
 * Srikant Kumar Kalaputapu
 * June 28th, 2017
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Questions {
	private Set<String> qaSet = new HashSet<String>();
	private Random rand;
	
	public Questions(){
		qaSet.add("On a scale from 1 to 10 how much pain are you in right now?");
		qaSet.add("Why do you suck at life?");
		qaSet.add("Why are you feeling horrible?");
		qaSet.add("What can you do to fix this issue?");
		qaSet.add("Do you want medicine for the problem?");
		qaSet.add("Where do you feel pain?");
		qaSet.add("Why should we care about you right now?");
		
		qaSet.add("How many fingers do you see?");
		qaSet.add("Close your eyes. What do you see in your mind?");
		qaSet.add("What is your favorite thing to do in the world?");
		qaSet.add("Who is your favorite person and why is it me?");
		qaSet.add("What is the meaning of life as we know it?");
		qaSet.add("What do you do in your free time?");
		qaSet.add("Can you exercise more?");
		qaSet.add("What can you do to help me?");
		
	}
	
	/**
	 * Randomly chooses a question to ask from a set of questions
	 * @return question to ask
	 */
	public String get(){
		int index = rand.nextInt(qaSet.size());
		Iterator<String> iter = qaSet.iterator();
		for (int i = 0; i < index; i++) {
			iter.next();
		}
		return iter.next();
	}
	
	/**
	 * Add new question to pool of questions for a chatbot
	 * @param qa - new question to ask
	 */
	public void add(String qa){
		if(!qa.contains("?")){
			System.out.println("Question does not have question mark");
		}
		else{
			qaSet.add(qa);
		}
		
	}
}
