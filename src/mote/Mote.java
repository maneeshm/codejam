package mote;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class Mote {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			  // Open the file that is the first 
			  // command line parameter

			 
			  FileInputStream fstream = new FileInputStream("A-large.in");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  
			  FileOutputStream ostream  = new FileOutputStream("Output1.txt");
			  DataOutputStream out = new DataOutputStream(ostream);
			  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
			  
			  //Read File Line By Line
			  int count = Integer.parseInt(br.readLine());
			  
			  for (int i = 0; i < count; i++)   {
				  
				  String [] stringArray = br.readLine().split(" ");
				  int amin_mote = Integer.parseInt(stringArray[0]);
				  int mote_count = Integer.parseInt(stringArray[1]);
				  int minAddCount = 0;
				  int curAminMote=amin_mote;
				  //bw.write("Case #" + (i+1) + ": " + "amin note " + amin_mote + " mote_count " + mote_count);
				  int [] moteArray = new int [mote_count];
				  String [] stringArrayMotes = br.readLine().split(" ");
				  
				  for (int j = 0; j < mote_count; j++){
					  moteArray[j] = Integer.parseInt(stringArrayMotes[j]);
				  }
				  
				  Arrays.sort(moteArray);
				  
				  for (int k =0; k< mote_count; k++){
					  if (curAminMote > moteArray[k]){
						  curAminMote+=moteArray[k];
						  continue;
					  }
					  else{
						  int l = 1; 
						  int curLoopAdditions=0;
						  while (true){
							  if((minAddCount + curLoopAdditions) < mote_count){
								  if (l < (mote_count - k)){
									  curAminMote += (curAminMote - 1);
									  if (curAminMote > moteArray[k]){
										  curAminMote += moteArray[k];
										  minAddCount += (curLoopAdditions+1);
										  break;
									  }
									  else{
										  curLoopAdditions++;
									  }
								  }else {
									  //exceeded max
									  minAddCount+=(mote_count-k);
									  k+=mote_count;//(mote_count - k);
									  break;
								  }
								  l++;
							  }
							  else{
								  //exceeded max
								  k=mote_count;
								  minAddCount = mote_count;
								  break;
							  }
						  }
						  

					  }
					  
				  }
				  
				  bw.write("Case #" + (i+1) + ": " + minAddCount);
				  
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


}
