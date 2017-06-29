import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Therapist {
	
	private Hedge hedgeSet;
	private Qualifier qualifierSet ;
	private Replacements replacementMap;
	private Questions questionSet;
	
	public Therapist() {
		hedgeSet = new Hedge();
		qualifierSet = new Qualifier();
		replacementMap = new Replacements();
		questionSet = new Questions();
	}
	
	public String hedge() {
		return hedgeSet.get();
	}
	
	public String qualify(String statement) {
		return qualifierSet.getRandomQualifier() + replacementMap.replace(statement);
	}
	
	public String question() {
		return questionSet.get();
	}

	public String sentiment(String input){
		return "GTFO";
	}
	
}