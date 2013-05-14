package jamOneCPogo;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Pogo {

	static int finalx, finaly;
	static Boolean isDone=false;
	
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

				  finalx = Integer.parseInt(stringArray[0]);
				  finaly = Integer.parseInt(stringArray[1]);
				  
				  calculatePogoPath();
			  }
			  
			  //Close the input stream
			  in.close();
			  out.close();
			  }catch (Exception e){//Catch exception if any
				  System.err.println("Error: " + e.getMessage());
				}
	}

	private static void calculatePogoPath() {

		System.out.print("case #");
		isDone = false;
		getPogoPath(0,0,0);
		System.out.println();
		
	}

	private static boolean getPogoPath(int xAxis, int yAxis,int step) {
		
		synchronized (isDone) {
			if (isDone == true) 
				return false;
		}
		
		int absfinalx = ((finalx < 0)? -finalx:finalx);
		int absfinaly = ((finaly < 0)? -finaly:finaly);
		
		int absxAxis = ((xAxis < 0)? -xAxis:xAxis);
		int absyAxis = ((yAxis < 0)? -yAxis:yAxis); 
		
		if ((( absxAxis > absfinalx) && (absxAxis > absfinaly)) ||
				(( absyAxis > absfinalx) && (absyAxis > absfinaly)))
			return false;
		
		if ((xAxis == finalx) && (yAxis == finaly)){
			synchronized (isDone) {
				isDone = true;
			}
			return true;
		}
		step++;
		
		boolean east = getPogoPath(xAxis + step, yAxis,step);
		boolean west = getPogoPath(xAxis - step, yAxis,step);
		boolean north = getPogoPath(xAxis, yAxis + step,step);
		boolean south = getPogoPath(xAxis, yAxis - step,step);
		
		/// read the output right to left
		
		System.out.print(east? "E":"");  //move east
		System.out.print(west? "W":"");  //move west
		System.out.print(north? "N":"");  //move north
		System.out.print(south? "S":"");  //move south
		
		return (east || west || north || south); 
		
	}



}
