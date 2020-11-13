package ca.sheridancollege.beans;

import java.io.Serializable;
import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Matrix implements Serializable{

	
	private static final long serialVersionUID = 770634477683159449L;

	private int m;  //length of matrix
	
	private char[][] matrixOne;
	private char c;
	
	
	public char[][] generateMatrix() {
	
	  matrixOne = new char[m][m];
		Random rnd = new Random();
		
	
		for (int i=0;i<matrixOne.length;i++) {
			for(int j=0;j<matrixOne[i].length;j++) {
			 c = (char) (rnd.nextInt(26) + 'a');
				matrixOne[i][j] = c;
				
		
			}
		}
		

			
			
	return matrixOne;
	
	}
	
 
		    
	   }
	  
	
	

