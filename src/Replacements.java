import java.util.Iterator;
import java.util.Set;

public class Replacements {

	private HashMap<String><String> repMap;
	
	public Replacements() {
		repMap.put("I", "you");
		repMap.put("me", "you");
		repMap.put("my", "your");
		repMap.put("am", "are");
		repMap.put("our", "all of your");
		repMap.put("we", "all of you");
		repMap.put("was", "were");
		repMap.put("I'm not", "you aren't");
		repMap.put("you", "me");
		repMap.put("your", "my");
		repMap.put("are", "am");
		repMap.put("all of your", "our");
		repMap.put("were", "was");
		repMap.put("all of you", "we");
		repMap.put("you aren't", "I'm not");
	}
	
	public boolean addReplacement(String from, String to) {
		repMap.put(from, to);
		return true;
	}
	
	public String replace(String text) {
		Set<String> keys = repMap.keySet();
		Iterator<String> iter = keys.iterator();
		for (int i = 0; i < keys.size(); i++) {
			String key = iter.next();
			text = text.replaceAll("\\b" + key + "\\b", repMap.get(key));
		}
		return text;
	}
}
