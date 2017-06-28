/*
 * Qualifier Handler for Chat Bot Implementation.
 * Srikant Kumar Kalaputapu
 * June 28th, 2017
 * 
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Qualifier {
	
	//Set of qualifier statements
	private Set<String> qualifierSet = new HashSet<String>();
	
	/**
	 * Creates default set of qualifiers
	 */
	public Qualifier(){
		qualifierSet.add("Why do you say that");
		qualifierSet.add("You seem to think that");
		qualifierSet.add("So, you are concerned that");
		qualifierSet.add("Hmmm, What seems to be the problem with");
		qualifierSet.add("Other people believe that");
		qualifierSet.add("Why would you believe that");
		qualifierSet.add("Do you kill people while you");
		qualifierSet.add("Do you want to talk about why that");
		qualifierSet.add("Do you see dead people that");
	
	
	
	
	}
	
	
	/**
	 * Create list of qualifiers from pre-existing set of qualifiers
	 * @param s - preexisting qualifier set
	 */
	public Qualifier(Set s){
		qualifierSet.addAll(s);
	}
	
	/**
	 * Add new qualifier statement to set of qualifiers
	 * @param statement - new qualifier to be added
	 */
	public void addQualifier(String statement){
		qualifierSet.add(statement);
	}
	
	/**
	 * Selects a random qualifier to use from the set
	 * @return random qualifier statement
	 */
	private String getRandomQualifier(){
		Random rand = new Random();
		int index = rand.nextInt(qualifierSet.size());
		Iterator<String> iter = qualifierSet.iterator();
		for (int i = 0; i < index; i++) {
		    iter.next();
		}
		return iter.next();
	}
	
	
	
}