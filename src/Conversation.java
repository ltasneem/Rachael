import java.util.*;
import java.io.*;


/*
 * Created by Lubaba Nuzhat Tasneem
 * */

public class Conversation {
	
	/*Constructor
	 * */
	
	public Conversation()
	{
		initialize_directory();
	}
	
	/*
	 * initializes the parent directory
	 */
	public void initialize_directory()
	{
		String strDirectoy = "Patients";
		try{
		    
		    boolean success = (new File(strDirectoy)).mkdir();
		    if (success) {
		      System.out.println("Directory: " + strDirectoy + " created");
		    }    


		    }catch (Exception e){//Catch exception if any
		      System.err.println("Error: " + e.getMessage());
		    }  
	}
	/*
	 * Creates directory for each patient
	 * */
	
	public void create_patient_directory(String patientname)
	{
		try{
		    
		    boolean success = (new File("Patients/"+patientname)).mkdir();
		    if (success) {
		      System.out.println("Directory: " + patientname + " created");
		    }    

		    }catch (Exception e){//Catch exception if any
		      System.err.println("Error: " + e.getMessage());
		    } 
	}
	
	/*
	 * saves sessions in patient's directory as  txt files;
	 * */
	
	public void create_session(String patientname, int session,ArrayList<String> file_s)
	{
		Iterator<String> iter1 = file_s.iterator();
		PrintWriter writer=null;
		 try {
		     writer = new PrintWriter(new File("Patients/"+patientname+"/session"+session+".txt"));
		     for (int i = 0; i < file_s.size(); i++) {
		    	 	String s=iter1.next();
		    	 	writer.println(s);
		    	 	System.out.println(s);
				}
		 } catch (FileNotFoundException e) {
		     System.out.println("File not found");
		 }
		 writer.close();
	}
	
	/* load previous sessions
	 * */
	
	public HashMap<String,ArrayList<String>> load_sessions(String patientname) throws IOException
	{
		//ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
		HashMap<String,ArrayList<String>> table = new HashMap<String,ArrayList<String>>();
		
		int num_session = new File("Patient/"+patientname).listFiles().length;
		String line ="";
		
		for(int i=0;i<num_session;i++)
		{
			ArrayList<String> array = new ArrayList<String>();
			 try {
				 
		            FileReader fileReader = new FileReader("Patients/"+patientname+"/session"+i+".txt");

		            BufferedReader bufferedReader = new BufferedReader(fileReader);

		            while((line = bufferedReader.readLine()) != null) {
		                System.out.println(line);
		                array.add(line);
		            }   

		            bufferedReader.close();         
		        }
		        catch(FileNotFoundException ex) {
		            System.out.println("Unable to open file 'session" + i + "'");                
		        }
			table.put("session"+i,array);
		}
		
		return table;
	}

}
