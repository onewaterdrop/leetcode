package wrapper;

import java.util.ArrayList;
import java.util.Random;

public class WordWrapper {

	/**
	 * @param args
	 */
	  public static void main(String[] args) {
		    ArrayList<String> strings = new ArrayList<String>();
		    strings.add("Hello, World!");
		    strings.add("Welcome to CoderPad.");
		    strings.add("This pad is running Java 8.");

		    for (String string : strings) {
		      System.out.println(string);
		    }
		    
	//	    Integer.valueOf(s);

		    for(String s:generateWords(3)){
//		    	System.out.println(s);
//		    	System.out.println("#######################################");
//		    	 System.out.println(wordWrap4(s,0));
		    	 
		    	 System.out.println(wordWrap2(s).equals(wordWrap4(s,0)));
		    }
		   
		    
		    
		  }
	  
	     static String[] generateWords(int count){
	    	 
	    	 String[] arr = new String[count];
			  StringBuilder sb = new StringBuilder();
			  Random r = new Random();
			  for(int i=0;i<count;i++){
				  for(int j=0;j<50;j++){
					  sb.append("word " + r.nextInt() + " ");
				  }
			  
				  arr[i]=sb.toString();
			  }
	    	 
			  return arr;
	     }
		  
		  // Wordwrap Function
		  // Takes in a str
		  // 80 characters, newline \n
		  // Output a str with the newline
		  // Do not break words
		  
		  // ..... world<- 80th character
		  // ..... world\n
		  
		  // ..... worl<- 80th character d
		  // ..... \nworld
		  
		  public static String wordWrap4(String str,int extra){
			    
			    StringBuilder sb  = new StringBuilder();
			    if(str.length()<79) return str;
			    
			    int n = 79 - extra;
			    if(str.length()>=n){
			    	
				      if(isLastLetterofWord(str,79)) {
					        sb.append(LastLetterOfWord(str,0,79));
					        sb.append(wordWrap4(str.substring(80),0));
					        
					      }else if(isMiddleLetterOfWord(str,79)){
//					        System.out.print("newStart = " + newstart);
					        sb.append(MiddleLetterOfWord(str,0,79));

					        int newstart = seekNextSpaceIndex(str,79);
					        sb.append(wordWrap4(str.substring(newstart),newstart-80));
					      }else{
					        sb.append(SpaceCase(str,0,79));
					        sb.append(wordWrap4(str.substring(80),0));
					      }
			    }
			    	
		        
			    return sb.toString();
			  }
	     
		  public static String wordWrap3(String str){
			    

			    StringBuilder sb  = new StringBuilder();
			    if(str.length()<79) return str;
			    
			    if(str.length()>=79){
			    	
				      if(isLastLetterofWord(str,79)) {
					        sb.append(LastLetterOfWord(str,0,79));
					        sb.append(wordWrap3(str.substring(80)));
					        
					      }else if(isMiddleLetterOfWord(str,79)){
//					        System.out.print("newStart = " + newstart);
					        sb.append(MiddleLetterOfWord(str,0,79));

					        int newstart = seekNextSpaceIndex(str,79);
					        sb.append(wordWrap3(str.substring(newstart)));
					      }else{
					        sb.append(SpaceCase(str,0,79));
					        sb.append(wordWrap3(str.substring(80)));
					      }
			    }
			    	
		        
			    return sb.toString();
			  }
	     
	     
		  public static String wordWrap2(String str){
		    

		    StringBuilder sb  = new StringBuilder();
		    if(str.length()<80) return str + '\n';
		    
		    int newstart =0;
		    
		    for(int j=1,i= 80*j -1 ;i<str.length();j++,i=80*j-1){
		      if(isLastLetterofWord(str,i)) {
		        sb.append(LastLetterOfWord(str,newstart,i));
		        newstart = i+1;
		        
		      }else if(isMiddleLetterOfWord(str,i)){
//		        System.out.print("newStart = " + newstart);
		        sb.append(MiddleLetterOfWord(str,newstart,i));
		        newstart = seekNextSpaceIndex(str,i);
		      }else{
		        sb.append(SpaceCase(str,newstart,i));
		        newstart = i;
		      }
//		      System.out.print("newStart = " + newstart);
		    }
		    sb.append(remainSubString(str,newstart));
	        
		    return sb.toString();
		  }

		   public  static String SpaceCase(String str,int start,int end){
		     
		     return str.substring(start,end) + "\n";
		     
		   }

		   public static String remainSubString(String str,int start){
		     
		     return str.substring(start);
		     
		   }

		   public static boolean isLastLetterofWord(String str,int i){
		     
		     return (i+1 < str.length()) && Character.isWhitespace(str.charAt(i+1)) && Character.isLetterOrDigit(str.charAt(i));
		     
		   }
		   public static  boolean isMiddleLetterOfWord(String str,int i){
		     
		     return (i+1 < str.length())&& !Character.isWhitespace(str.charAt(i+1))&&Character.isLetterOrDigit(str.charAt(i));
		     
		   }
		   public  static String LastLetterOfWord(String str,int start,int end){
		     
		      return str.substring(start,end+1) + "\n";
		     
		   }
		   public static  String MiddleLetterOfWord(String str,int start,int end){
		     
		     int inc = end;
		     while(inc>0 && inc+1<str.length() && Character.isLetterOrDigit(str.charAt(inc))){
		    	 inc--;
//		    	 System.out.println(inc);
		     }
		     
		     return str.substring(start,inc) + "\n";
		     
		   }
		   public  static int seekNextSpaceIndex(String str,int start){
		     
		     int inc = start;
		     while(inc+1<str.length() && Character.isLetterOrDigit(str.charAt(inc)))inc++;
		     
		     return inc;
		     
		   }

}
