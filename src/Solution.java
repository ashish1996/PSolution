import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    static String[] findViolations(String[] datafeed) {
        
        int lengthOfData= datafeed.length;
        ArrayList<String> outputArray = new ArrayList();
        Map<String, Integer> inputData= new HashMap();
        for(int i=0; i<lengthOfData; i++) {
            String tempData= datafeed[i];
            String[] tempArray=datafeed[i].split(";",-1);
            if (inputData.containsKey(tempArray[0])){
                if(Integer.parseInt(tempArray[1])<inputData.get(tempArray[0])) {
                   String output = i+1 + ";" + tempArray[0] + ";" + "SHORTENED_JOB";
                   outputArray.add(output);
                }else if (tempArray[1] instanceof String) {
                    String[] multInts = tempArray[1].split(",");
                    for ( int j =0; j<multInts.length; j++) {
                        if(Integer.parseInt(multInts[j])<inputData.get(tempArray[0])) {
                            if(j==multInts.length-1) {
                                System.out.println(i+1 + ";" + tempArray[0] + ";" + "SUSPICIOUS_BATCH");
                               String output2=i+1 + ";" + tempArray[0] + ";" + "SUSPICIOUS_BATCH";
                               outputArray.add(output2);
                            }
                            else {
                            System.out.println(i+1 + ";" + tempArray[0] + ";" + "SHORTENED_JOB");
                            String output3=i+1 + ";" + tempArray[0] + ";" + "SHORTENED_JOB";
                            outputArray.add(output3);
                        }
                        }else{
                            inputData.put(tempArray[0],Integer.parseInt(tempArray[1]));
                        }
                        }
                    }
                } 
                else {
                	inputData.put(tempArray[0],Integer.parseInt(tempArray[1]));
  
                }
            }
        			
        			return outputArray.toArray(String[] finalOutput);
                                                 }
                                                 
            
        }
    
	
	

