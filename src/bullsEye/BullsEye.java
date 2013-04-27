package bullsEye;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class BullsEye {

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
				  long rad = Long.parseLong(stringArray[0]);
				  long ltr = Long.parseLong(stringArray[1]);
				  long ring_count = 0;
				  
				  while(true){
					  
					  long outer =(rad + 1) * (rad+1);
					  long inner = (rad) * (rad);
					  
					  long curr_area = outer - inner;

					  if ((ltr - curr_area) < 0)
						  break;
					  
					  ltr -= curr_area;
					  
					  rad+=2;
					  
					  ring_count++;
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
	
}
