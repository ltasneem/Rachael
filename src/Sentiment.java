import java.util.*;
import java.io.*;

public class Sentiment {
	
	private Set<String> positive = new HashSet<String>();
	private Set<String> negative = new HashSet<String>();
	private Set<String> neutral = new HashSet<String>();
	private File posFile;
	private File negFile;
	private File neuFile;
	
	private HashMap<String,Set<String>> replaceSentimentMap = new HashMap<String,Set<String>>();
	
	public Sentiment(){
		
			replaceSentimentMap.put("Positive",positive);
			replaceSentimentMap.put("Negative",negative);
			replaceSentimentMap.put("Neutral",neutral);
			
		
	}

	private void loadWords() {

		posFile = new File("positive-words-1.txt");
		LinkedList<Customer> customers = new LinkedList<Customer>();
		
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String record = sc.nextLine();
				String[] customer = record.split("\\t");
				
				//strict format
				Customer c = new Customer(customer[0],customer[1],customer[2],customer[3],customer[4],customer[5],customer[6],customer[7],customer[8],customer[9],customer[10]);
				customers.add(c);
//				System.out.println(c);
				
			}
			sc.close();
			
			PrintWriter writer=null;
			 try {
			     writer = new PrintWriter(new File("output.txt"));
			     for(Customer c: customers){
			    	 writer.write(c.getFullName() + "\t" + c.getEmail() + "\n");
			     }
			 } catch (FileNotFoundException e) {
			     System.out.println("File not found");
			 }
			 //close the print writer
			 writer.close();
		
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		posFile = new File()
	}
}
