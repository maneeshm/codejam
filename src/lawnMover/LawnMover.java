package lawnMover;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LawnMover {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			  // Open the file that is the first 
			  // command line parameter

			 
			  FileInputStream fstream = new FileInputStream("B-large.in");
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
				  int row = Integer.parseInt(stringArray[0]);
				  int col = Integer.parseInt(stringArray[1]);
				  
				  int [][] array = new int [row][col];
				  int [][] discissionArray = new int [row][col];
				  int [] highestInEachCol = new int [col];
				  boolean fail = false;
				  
				  for (int j = 0; j < row; j++){
					  String [] stringArrayElements = br.readLine().split(" ");
					  int highestInRow = 0;
					  
					  for (int k = 0; k < col; k++) {
						  array[j][k] = Integer.parseInt(stringArrayElements[k]);
						  
						  if (array[j][k] > highestInEachCol[k])
							  highestInEachCol[k] = array[j][k];
						  
						  if (array[j][k] > highestInRow)
							  highestInRow = array[j][k];
						  
					  }
					  
					  // set 1 in discionArray for highest in row
					  for (int l = 0; l < col; l++){
						  if (highestInRow == array[j][l])
							  discissionArray[j][l]=1;
					  }
				  }
				  
				  for (int m = 0; m < row; m++){
					  for (int n = 0; n < col; n++){
						  if (discissionArray[m][n] == 1)
							  continue;
						  if (highestInEachCol[n] == array[m][n]){
							  discissionArray[m][n] =1;
							  continue;
						  }
						  fail=true;
					  }
				  }
				  
				  if (fail)
					  bw.write("Case #" + (i+1) + ": " + "NO");
				  else
					  bw.write("Case #" + (i+1) + ": " + "YES");
				  
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
