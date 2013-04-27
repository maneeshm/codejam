package energy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;

public class ManageEnergy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			  // Open the file that is the first 
			  // command line parameter

			 
			  FileInputStream fstream = new FileInputStream("A-large.in");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  
			  FileOutputStream ostream  = new FileOutputStream("Output.txt");
			  DataOutputStream out = new DataOutputStream(ostream);
			  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
			  
			  //Read File Line By Line
			  int count = Integer.parseInt(br.readLine());
			  
			  for (int i = 0; i < count; i++)   {
				  
				  String [] stringArray = br.readLine().split(" ");
				  int max = Integer.parseInt(stringArray[0]);
				  int incr = Integer.parseInt(stringArray[1]);
				  int intCount = Integer.parseInt(stringArray[2]);
				  
				  String [] stringArrayVals = br.readLine().split(" ");
				  int arrayVals [] = new int[stringArrayVals.length];
				  int totalEnergy = max;
				  int totalGain = 0;
				  
				  for (int k =0; k < intCount; k++)
					 arrayVals[k] = Integer.parseInt(stringArrayVals[k]);
				  
				  int iterCompare = (int)Math.ceil((max/incr));
				  for (int l = 0; l < arrayVals.length;l++,totalEnergy+=incr){
					  					  
					  if (arrayVals[l] <= arrayVals[l+1]){
						  if (totalEnergy > (max - incr)){
						    totalGain += (totalEnergy + incr - max) * arrayVals[l];
						    totalEnergy = (totalEnergy + incr - max) + incr;
						  }
						  
					  } else {
						  int energyToUse=0;
						  for (int m = l; (m < (iterCompare + l)) && (m < arrayVals.length); m++){
							  if (arrayVals[l] < arrayVals[l+m]){
								  energyToUse+= incr;
							  }
							  else{
								  energyToUse+=incr;
								  break;
							  }
						  }
						  
						  
					  }
					  
						  
				  }
				  
				  
				  bw.write("Case #" + (i+1) + ": " + ring_count);
				  bw.newLine();
				  bw.flush();
			  }
			  
			  //Close the input stream
			  in.close();
			  out.close();
			  }catch (Exception e){//Catch exception if any
				  System.err.println("Error: " + e.getMessage());
				}
	}

	private static int getLargestIndex(int[] arrayVals) {
		int largest = arrayVals[0], index = 0;
		for (int i = 1; i < arrayVals.length; i++) {
			if ( arrayVals[i] > largest ) {
				largest = arrayVals[i];
				index = i;
			}
		}
		return index;
	}

}
