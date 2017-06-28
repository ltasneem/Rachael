import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Hedge {
	
	private Set<String> hedgeSet = new HashSet<String>();
	private Random rand;
	
	public Hedge(){
		hedgeSet.add("Please tell me more");
		hedgeSet.add("Many of my patients tell me the same thing");
		hedgeSet.add("It is getting late, maybe we had better quit");
		hedgeSet.add("I see, that's quite interesting");
		hedgeSet.add("Ah, I didn't know that");
		hedgeSet.add("I had a feeling that this was the case");
		hedgeSet.add("Well there's no use crying about it");
		hedgeSet.add("I don't know what to say to that");
		hedgeSet.add("I won't tell anyone I promise");
		hedgeSet.add("Well, at least the weather is nice today");
		hedgeSet.add("You're not the only one who feels this way");
		hedgeSet.add("Can I just say that you remind me of my mother-in-law");
		hedgeSet.add("That's just how life is sometimes");
		hedgeSet.add("Oh believe me, I know how you feel");
		hedgeSet.add("You tell such fascinating stories");
		
	}
	
	public String get(){
		int index = rand.nextInt(hedgeSet.size());
		Iterator<String> iter = hedgeSet.iterator();
		for (int i = 0; i < index; i++) {
			iter.next();
		}
		return iter.next();
	}
	
	public void add(String hedge){
		hedgeSet.add(hedge);
	}
}
