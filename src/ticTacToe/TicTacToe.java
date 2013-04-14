package ticTacToe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TicTacToe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			  // Open the file that is the first 
			  // command line parameter
			 boolean is_completed = true;
			 int player_X = 0, player_O = 0;
			 int bit_shift=0;
			 
			 
			 int row_one = 0x0000000f;
			 int row_two = 0x000000f0;
			 int row_three = 0x00000f00;
			 int row_four = 0x0000f000;
			 
			 int col_one = 0x00001111;
			 int col_two = 0x00002222;
			 int col_three = 0x00004444;
			 int col_four = 0x00008888;
			 
			 int r_to_l_diag = 0x00008421;
			 int l_to_r_diag = 0x00001248;
			 
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
				  
				  bit_shift=1;
				  is_completed = true;
				  player_X = 0; 
				  player_O = 0;
				  
				  for (int j = 0; j < 4; j++){
					  
					  String stringArray = br.readLine();
					  char array[] = stringArray.toCharArray();
					  
					  for (int k = 0; k < 4; k++){
						  
						  // check for completeness
						  if (array[k] == '.')
							  is_completed = false;
						  else if (array[k] == 'X')
							  player_X |= bit_shift;
						  else if (array[k] == 'O')
							  player_O |= bit_shift;
						  else{
							  player_X |= bit_shift;
							  player_O |= bit_shift;
						  }
						bit_shift <<= 1;
					  }
				  }
				  if ((i+1) < count)
					  br.readLine();
				  
				  if (((row_one & player_X) == row_one) ||
						  ((row_two & player_X) == row_two) ||
						  ((row_three & player_X) == row_three) ||
						  ((row_four & player_X) == row_four)){
					  
					  bw.write("Case #" + (i+1) + ": " + "X won");
					  
				  } else if (((col_one & player_X) == col_one) ||
						  ((col_two & player_X) == col_two) ||
						  ((col_three & player_X) == col_three) ||
						  ((col_four & player_X) == col_four)){
					  
					  bw.write("Case #" + (i+1) + ": " + "X won");
					  
				  } else if (((l_to_r_diag & player_X) == l_to_r_diag) ||
						  ((r_to_l_diag & player_X) == r_to_l_diag)){
					  
					  bw.write("Case #" + (i+1) + ": " + "X won");
					  
				  } else if (((row_one & player_O) == row_one) ||
						  ((row_two & player_O) == row_two) ||
						  ((row_three & player_O) == row_three) ||
						  ((row_four & player_O) == row_four)){
					  
					  bw.write("Case #" + (i+1) + ": " + "O won");
					  
				  } else if (((col_one & player_O) == col_one) ||
						  ((col_two & player_O) == col_two) ||
						  ((col_three & player_O) == col_three) ||
						  ((col_four & player_O) == col_four)){
					  
					  bw.write("Case #" + (i+1) + ": " + "O won");
					  
				  } else if (((l_to_r_diag & player_O) == l_to_r_diag) ||
						  ((r_to_l_diag & player_O) == r_to_l_diag)){
					  
					  bw.write("Case #" + (i+1) + ": " + "O won");
					  
				  } else if (is_completed == false){
					  bw.write("Case #" + (i+1) + ": " + "Game has not completed");
				  } else {
					  bw.write("Case #" + (i+1) + ": " + "Draw");
				  }
				  
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
