package com.datapopulator.spring.test;

import java.util.ArrayList;
import java.util.List;

public class NewTest {
	
	   int minimumHours(int rows, int columns, List<List<Integer>> grid)
	    {
	        int counter = 0;
			do 
	        {
	             grid = getTempArray(rows, columns, grid);
	             counter++;
	        }while (!checkIfOnes(rows, columns, grid));
	        return counter;
	    }
	    boolean checkIfOnes(int rows, int columns, List<List<Integer>> grid) 
	    {
	        for (int i = 0; i < rows; i++) 
	        {
	             for (int j = 0; j < columns; j++ ) 
	             {
	                 if (grid.get(i).get(j) == 0) 
	                	 return false;
	             }
	        }
	        return true;
	     }
	    
	    
	    
	    List<List<Integer>> getTempArray(int rows, int columns, List<List<Integer>> grid) 
	    {
	        List<List<Integer>> temp = new ArrayList<List<Integer>>();
	        
	        for(int x=0;x<rows;x++) {
	        	ArrayList<Integer> row = new ArrayList<>();
	        	for(int j=0;j<columns;j++) {
	        		row.add(0);
	        	}
	        	temp.add(row);
	        }
	        
	        System.out.println(temp);
	         for (int i = 0; i < rows; i++) 
	         {
	            for (int j = 0; j < columns; j++ ) 
	            {
	                if (grid.get(i).get(j)==1) 
	                {
	                    if (j - 1 >= 0 && j - 1 < columns){
	                        temp.get(i).set(j - 1, 1);
	                        temp.get(i).set(j, 1);
	                    } if (j + 1 < columns) {
	                         temp.get(i).set(j + 1, 1);
	                         temp.get(i).set(j, 1);
	                    } if (i - 1 >= 0 && i - 1 < rows) {
	                         temp.get(i - 1).set(j, 1);
	                         temp.get(i).set(j, 1);
	                    } if (i + 1 > 0 && i + 1 < rows) {
	                         temp.get(i + 1).set(j, 1);
	                         temp.get(i).set(j, 1);
	                    }
	                }
	            }
	        }
	        System.out.print(temp+" ");
	        return temp;
	    }
		

}
