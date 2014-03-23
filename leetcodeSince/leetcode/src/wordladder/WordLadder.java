package wordladder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadder {
	
	static HashSet<String> dict = new HashSet<String>(Arrays.asList(new String[]{"hot","dot","dog","lot","log"}));
	static String start ="hit";
	static String end ="cog";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ladderLength(start,end,dict));
		System.out.println(ladderLength1(start,end,dict));

	}
	    public static int ladderLength(String start, String end, HashSet<String> dict) {
	 
	        int len=0;
	        HashSet<String> visited = new HashSet<String>();
	 
	        for(int i=0; i<start.length(); i++){
	            char[] startArr = start.toCharArray();
	 
	            for(char c='a'; c<='z'; c++){
	                if(c==start.toCharArray()[i]){
	                    continue;
	                }
	 
	                startArr[i] = c;
	                String temp = new String(startArr);
	                if(dict.contains(temp)){
	                    len++;
	                    start = temp;
	                    if(temp.equals(end)){
	                        return len;
	                    }
	                }
	            }
	        }
	 
	        return len;
	    }
	    
	    public static int ladderLength1(String start, String end, HashSet<String> dict) {
	    	 
	        if (dict.size() == 0)  
	            return 0; 
	 
	        int result = 0;
	 
	        LinkedList<String> wordQueue = new LinkedList<String>();
	        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
	 
	        wordQueue.add(start);
	        distanceQueue.add(1);
	 
	 
	        while(!wordQueue.isEmpty()){
	            String currWord = wordQueue.pop();
	            Integer currDistance = distanceQueue.pop();
	 
	            if(currWord.equals(end)){
	                return currDistance;
	            }
	 
	            for(int i=0; i<currWord.length(); i++){
	                char[] currCharArr = currWord.toCharArray();
	                for(char c='a'; c<='z'; c++){
	                    currCharArr[i] = c;
	 
	                    String newWord = new String(currCharArr);
	                    if(dict.contains(newWord)){
	                        wordQueue.add(newWord);
	                        distanceQueue.add(currDistance+1);
	                        dict.remove(newWord);
	                    }
	                }
	            }
	        }
	 
	        return 0;
	    }

}
