package jamOneC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class JamOneC {

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

				  new MainImplementation(stringArray, i, bw).run();
			  }
			  
			  //Close the input stream
			  in.close();
			  out.close();
			  }catch (Exception e){//Catch exception if any
				  System.err.println("Error: " + e.getMessage());
				}
	}



}



class MainImplementation implements Runnable{
	
	private static int globali = 0;

	String stringArray[];
	int i=0;

	private static BufferedWriter bw;
	
	public MainImplementation(String stringArray[], int i, BufferedWriter bw) {
		// TODO Auto-generated constructor stub
		this.stringArray = stringArray;
		this.i = i;
		this.bw = bw;
		
	}
	
	private static boolean isConsonantMAtch(String name, int index, int nvalue) {
		// TODO Auto-generated method stub

		char nameArray[] = name.toCharArray();
		
		if ((index + nvalue) > name.length())
			return false;
		
		for(int i = 0; i < nvalue; i++){
		  if((nameArray[i + index] == 'a') || (nameArray[i + index] == 'e') || (nameArray[i + index] == 'i') ||
				  (nameArray[i + index] == 'o') || (nameArray[i + index] == 'u')){
			  return false;		  
		  }
		
		}
		return true;
	}

	
	private static void mainPart(String stringArray[], int i, BufferedWriter bw) throws IOException {
		  
		  String name = stringArray[0];
		  int nvalue = Integer.parseInt(stringArray[1]);
		  int lastmatch=-1;
		  int nOutPutVal=0;
		  
		  for(int j = 0; j < name.length(); j++){
			  
			  if(isConsonantMAtch(name, j, nvalue)){
				  
				  int preCount = j + 1;
				  if(lastmatch >= 0){
					  preCount = j - lastmatch;
				  }
				  int postCount = name.length() - nvalue - j + 1;
				  
				  nOutPutVal += preCount * postCount;
				  

				  
				  lastmatch = j;
				  
			  }
		  }
		  
		  while (globali != i){
		  }
		  bw.write("Case #" + (i+1) + ": " + nOutPutVal);

		  bw.newLine();
		  bw.flush();
		  globali++;

		  
	  }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			mainPart(stringArray, i, bw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}