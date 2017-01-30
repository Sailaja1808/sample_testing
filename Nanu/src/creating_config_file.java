import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;


public class creating_config_file{
	private static boolean debug = false;
	static String header = "PGMSSN|ACCT|TESTINGPROGRAM|ADMIN|STARTING_BARCODE|ENDING_BARCODE|MAX_BARCODE|GENERIC_ST_BARCODE|GENERIC_END_BARCODE|GENERIC_MAX_BARCODE|DATE_TIME";
	HashMap<String, String> hmap = new HashMap<String, String>();
	
    public static void main(String[] args) throws Exception {
        
        try {
        	creating_config_file ccf = new creating_config_file();
             if (args.length < 5) {  
                check_args();
                System.exit(1);
            }
             
             if(args[0].equalsIgnoreCase("true"))
 				debug = true;
            String Config1 = args[1]; 
            String Config2 = args[2]; 
            String Config3 = args[3];
            String Output = args[4];
            System.out.println(" \n *** Execution Start *** \n");
            if (debug){
                System.out.println(
                "Config1 = "+Config1 +"\n" +
                "Config2 = "+Config2 + "\n" +
                "Config3 = "+Config3 + "\n" +
                "Output = "+Output);
            }
            
            ccf.createHashKeys(header);
            ccf.readConfigFile1(Config1);
            ccf.readConfigFile2(Config2);
            ccf.readConfigFile3(Config3);
            ccf.writeConfigFile(Output);
            System.out.println("\n *** Execution End *** \n");
            System.out.println(" \n Output Student Barcode Config file = " +Output);
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        
    }
    
    public static void check_args()
    {
        System.out.println("  Please enter the following parms:\n" +
                "       Debug ( true or false) \n" +
                "       Config File 1 ( md_msa_hsajan17_barcode.dat ) \n" +
                "       Config File 2 ( md_msa_hsajan17_generic_barcode.dat ) \n" +
                "       Config File 3 ( md_msa_hsajan17_barcode_Init.dat ) \n" +
                "       Output Config File ( md_msa_hsajan17_barcodes.dat ) \n" );
    }
    
    private void readConfigFile1(String Config1)
    {
       BufferedReader br = null;
        String strLine = "";
        int lineNumber = 0; 
        try{
                br = new BufferedReader( new FileReader(Config1));              
               
                while ((strLine = br.readLine()) != null) {
                	
	                	lineNumber++;
	
	                	if (lineNumber > 1 && strLine.length() > 0 && strLine != null) {
	                		String[] arr = strLine.split("\\|");
	
							hmap.put("PGMSSN", arr[0].trim());
							hmap.put("ACCT", arr[1].trim());
							hmap.put("TESTINGPROGRAM", arr[2].trim());
							hmap.put("ADMIN", arr[3].trim());
							hmap.put("ENDING_BARCODE", arr[4].trim());
							hmap.put("MAX_BARCODE", arr[5].trim());						
							
	                	}           
       
                }
                if(debug){
                	System.out.println(" \n -------------- Values of Hashmap after updating the config file 1 values ------------ \n ");
                    printHashmap(hmap);                	
                }
                
      } catch (Exception e) {
            e.printStackTrace();
      } finally {
             try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                 
       }
    }
    
    private void readConfigFile2(String Config2)
    {
       BufferedReader br = null;
        String strLine = "";
        int lineNumber = 0; 
        try{
                br = new BufferedReader( new FileReader(Config2));              
               
                while ((strLine = br.readLine()) != null) {
                	
	                	lineNumber++;
	
	                	if (lineNumber > 1 && strLine.length() > 0 && strLine != null) {
	                		String[] arr = strLine.split("\\|");
	
							hmap.put("GENERIC_ST_BARCODE", arr[4].trim());
							hmap.put("GENERIC_END_BARCODE", arr[5].trim());
							hmap.put("GENERIC_MAX_BARCODE", arr[6].trim());
								
							
	                	}           
       
                }
                if(debug){
                	System.out.println(" \n ----------- Values of Hashmap after updating the config file 2 values --------------- \n ");
                    printHashmap(hmap);
                }
                
      } catch (Exception e) {
            e.printStackTrace();
      } finally {
             try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                 
       }
    }
    
    private void readConfigFile3(String Config3)
    {
       BufferedReader br = null;
        String strLine = "";
        int lineNumber = 0; 
        try{
                br = new BufferedReader( new FileReader(Config3));              
               
                while ((strLine = br.readLine()) != null) {
                	
	                	lineNumber++;
	
	                	if (lineNumber > 1 && strLine.length() > 0 && strLine != null) {
	                		String[] arr = strLine.split("\\|");
	
							hmap.put("STARTING_BARCODE", arr[4].trim());
													
							
	                	}           
       
                }
                
                if(debug){
                	 System.out.println(" \n ---------------- Values of Hashmap after updating the config file 3 values ---------------- \n ");
                     printHashmap(hmap);
                }
               
      } catch (Exception e) {
            e.printStackTrace();
      } finally {
             try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                 
       }
    }
    
    private void writeConfigFile(String Output)
    {
       BufferedWriter bw = null;
       String outline = null;
        try{
                bw = new BufferedWriter( new FileWriter(Output));              
                bw.write(header);
			    bw.newLine();
      
		         outline = hmap.get("PGMSSN")+ "|" + hmap.get("ACCT")+ "|" + hmap.get("TESTINGPROGRAM")+ "|" + hmap.get("ADMIN")+ "|" + hmap.get("STARTING_BARCODE")+ "|" +
		        		   hmap.get("ENDING_BARCODE")+ "|" + hmap.get("MAX_BARCODE")+ "|" + hmap.get("GENERIC_ST_BARCODE")+ "|" + hmap.get("GENERIC_END_BARCODE")+ "|" + hmap.get("GENERIC_MAX_BARCODE")+ "|" +
		        		   hmap.get("DATE_TIME");
		        		 
		         if(debug)System.out.println(" \n Output concat String ="+outline);
		         bw.write(outline);
		         bw.flush();

      } catch (Exception e) {
            e.printStackTrace();      
       } finally {
             try {
				
				if(bw!=null){
					   bw.flush();
					   bw.close();
					   }
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                 
       }
    }
    
    private void createHashKeys(String header){
    	String[] arr = header.split("\\|");
    	
    	for (int i = 0; i < arr.length; i++) {            
            hmap.put(arr[i].trim(),"z");
         } 
    	hmap.put("DATE_TIME", datetime());
       if (debug){
    	   System.out.println(" \n ---------------Creation of Hash Keys -------------- \n");
    	   printHashmap(hmap);
       }
    }
    
    private void printHashmap(HashMap<String, String> hmap){
    	
    	 Iterator<String> iterator = hmap.keySet().iterator();
         while(iterator.hasNext()) {
      	   String key = iterator.next().toString();
      	   String value = hmap.get(key).toString();      	  
      	   System.out.println("Key="+ key + "---------- Value=" + value);
         }   
    	
    }
    
    private String datetime(){
    	
    	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    	Date date = new Date();    	
    	String fdate=dateFormat.format(date);
    	if(debug)System.out.println("Date = "+fdate);
    	return fdate;
    	
    }
    
    
}
    