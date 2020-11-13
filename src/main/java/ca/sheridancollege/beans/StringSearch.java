package ca.sheridancollege.beans;

import java.io.Serializable;
import java.util.LinkedList;

public class StringSearch implements Serializable{
	
	 
	private static final long serialVersionUID = 8173604481968395784L;

	public  boolean search(final String word, char[][] matrix) {
    
     char firstLetter = word.charAt(0);
	        for (int y = 0; y < matrix.length; y++) {
	            for (int x = 0; x < matrix[y].length; x++) {
	                if (matrix[y][x] == firstLetter) {
	                  LinkedList<String> words = allDirection(word.length(), x, y, matrix);
	                    if (words.contains(word)) {
	                        return true;
	                    }
	                }
	            }
	        }

	        return false;
	    }

	  String direction[] =  {"NORTH","SOUTH","EAST","WEST", "NORTH_EAST" ,"NORTH_WEST","SOUTH_EAST","SOUTH_WEST"};

	    private  LinkedList<String> allDirection(int length,int x, int y, char[][] matrix) {
	        LinkedList<String> words = new LinkedList<>();
	      
	        for (String sub : direction) {
	           words.add(readWord(length, x, y, matrix,sub));
	        }
	        return words;
	    }

	    private static String readWord(int length,  int xStart,  int yStart, char[][] matrix,  String direction) {
	        final int xEnd = getXEnd(xStart, length, direction);
	        final int yEnd = getYEnd(yStart, length, direction);
	        int x;
	        int y;

	        
	         StringBuilder matrixWord = new StringBuilder();
	       
	         if (direction.equals("SOUTH")) {
	        	 if (yEnd > matrix.length-1) {
	                 return null;
	             }
	            for (y = yStart; y <= yEnd; y++) {
	                matrixWord.append(matrix[y][xStart]);
	            }
	        }
	        if (direction.equals("NORTH")) {
	            if (yEnd < 0) {
	                return null;
	            }
	            for (y = yStart; y >= yEnd; y--) {
	                matrixWord.append(matrix[y][xStart]);
	            }
	        }
	        if (direction.equals("EAST")){
	            if (xEnd > matrix[yStart].length-1) {
	                return null;
	            }
	            for (x = xStart; x <= xEnd; x++) {
	                matrixWord.append(matrix[yStart][x]);
	            }
	        }
	        if (direction.equals("WEST")) {
	            if (xEnd < 0) {
	                return null;
	            }
	            for (x = xStart; x >= xEnd; x--) {
	                matrixWord.append(matrix[yStart][x]);
	            }
	        }
	        if (direction.equals("SOUTH_EAST")){
	            if (yEnd > matrix.length-1 || xEnd > matrix[yStart].length-1) {
	                return null;
	            }
	            x = xStart;
	            y = yStart;
	            while (y <= yEnd && x <= xEnd) {
	                matrixWord.append(matrix[y][x]);
	                y++;
	                x++;
	            }
	        }
	        if (direction.equals("SOUTH_WEST")){
	            if (yEnd > matrix.length-1 || xEnd < 0) {
	                return null;
	            }
	            x = xStart;
	            y = yStart;
	            while (y <= yEnd && x >= xEnd) {
	                matrixWord.append(matrix[y][x]);
	                y++;
	                x--;
	            }
	        }
	        if (direction.equals("NORTH_EAST")) {
	            if (yEnd < 0 || xEnd > matrix[yStart].length-1) {
	                return null;
	            }
	            x = xStart;
	            y = yStart;
	            while (y >= yEnd && x <= xEnd) {
	                matrixWord.append(matrix[y][x]);
	                y--;
	                x++;
	            }
	        }
	        if (direction.equals("NORTH_WEST")) {
	            if (yEnd < 0 || xEnd < 0) {
	                return null;
	            }
	            x = xStart;
	            y = yStart;
	            while (y >= yEnd && x >= xEnd) {
	                matrixWord.append(matrix[y][x]);
	                y--;
	                x--;
	            }
	        }

	        return matrixWord.toString();
	    }

	    private static int getYEnd(final int y, final int length, final String direction) {
	        if (direction.equals("SOUTH") || direction .equals("SOUTH_EAST") || direction.equals("SOUTH_WEST")) {
	           
	        	return y + length - 1;
	        }
	        if (direction.equals("NORTH") || direction.equals("NORTH_EAST") || direction.equals("NORTH_WEST")) {
	           
	            return y - length + 1; 
	        }

	        
	        return y;
	    }

	    private static int getXEnd(final int x, final int length, final String direction) {
	        if (direction.equals("EAST") || direction.equals("NORTH_EAST") || direction.equals("SOUTH_EAST")) {
	            
	            return x + length - 1;
	        }
	        if (direction.equals("WEST") || direction.equals("NORTH_WEST") || direction.equals("SOUTH_WEST")) {
	            
	            return x - length + 1;
	        }

	        
	        return x;
	    }
	}

