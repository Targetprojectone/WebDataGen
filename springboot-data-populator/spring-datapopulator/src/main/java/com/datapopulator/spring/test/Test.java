package com.datapopulator.spring.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Test {

	
	
	
	
	
	
	
	
	
	
	
	   
	static List<List<String>> query(int columnSize, String queryStr, List<String> list) {
		
SortedSet<String> sortedSet = new TreeSet<String>(list);
        List<List<String>> suggestion = new ArrayList<>();
        
        
        int sizeOfQueryStr = 0;
        sizeOfQueryStr = queryStr.length();
        
        for (int i = 2; i <= sizeOfQueryStr; i++) {
			
        	String queryStr2 = queryStr.substring(0, i);
        	suggestion.add(getMatched(queryStr2, sortedSet)); 
        	
		}
        
        return suggestion;
    }

    private static List<String> getMatched(String query, SortedSet<String> sortedSet) {
    	
       
		return  sortedSet.stream().filter(o-> o.toLowerCase().startsWith(query.toLowerCase())).limit(3).collect(Collectors.toList());
    }	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		
		
		List<String> list= new ArrayList<String>(Arrays.asList("mobile","mouse","moneyPoint","monitor","mousePad"));
		List<List<String>> queryOut = query(5, "mouse", list);
		
		System.out.println(queryOut);
		
		//  minuteDilema(); 
		  
		 /* 
		 * addingtwoNumber(); coderFriend();
		 */
		//printNumber();
		}

	private static void coderFriend() {

		Map<Character, Integer> scores = new HashMap<Character, Integer>();
		scores.put('E', 1);
		scores.put('M', 3);
		scores.put('H', 5);

		String erica = "EHH";
		String bob = "EME";
		int ericaScores = 0;
		int bobScores = 0;
		String answer;
		for (char a : erica.toCharArray()) {
			ericaScores = ericaScores + scores.get(a);

		}

		for (char a : bob.toCharArray()) {
			bobScores = bobScores + scores.get(a);

		}

		answer = ericaScores > bobScores ? "Erica" :bobScores>ericaScores? "Bob":"Tie";

		System.out.println("output of Coder Friends is : " + answer);
	}

	private static void addingtwoNumber() {

		float f1 = 2.3f;
		float f2 = 1.9f;
		int ans = (int) (f1+f2);
		long l = (long)ans;
		System.out.println("output of Adding Two Numbers is : "  +ans);
		
		String[] arr = null;
		String arr1 = new String();
		List<String> list = new ArrayList<String>(Arrays.asList(arr));
		boolean anyMatch = list.stream().anyMatch(o->o.equalsIgnoreCase(arr1));
		
	}

	private static void minuteDilema() {

		List<Integer> songs = new ArrayList<>(Arrays.asList(4, 10, 50, 90,30,70));

	    int count = 0;

	        for(int i = 0, j =i+1; i<songs.size()&&j<songs.size(); i++, j++){

	                //for(int j = i+1; j<songs.size(); j++){

	                if((songs.get(i)+songs.get(j))%60==0){
	                count++;

	                }


	        //}

	        }
	  

		System.out.println("output of Minute Dilema is : "  +count);

	}
	
	
	private static void printNumber() {
	
		int n = 15;
		int i = 1;
		while (i<=n) {

			String answer= (i%3==0&&i%5==0)?"FizzBuzz":i%3==0?"Fizz":i%5==0?"Buzz":Integer.toString(i);
		
		System.out.println(answer);
		i++;
		
		}


	}
}
