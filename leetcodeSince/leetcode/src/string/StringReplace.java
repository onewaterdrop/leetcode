package string;

import java.util.Arrays;

public class StringReplace {
	
	static String testString ="Mr John Smith";
	
	static String test = "%20Mr%20John%20Smith20";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String helper = replaceSpace(testString);
		System.out.println(helper);
		
		System.out.println(test.length() + "\t" + test);
		String res = ReplaceSpaceInPlace2(test);
		System.out.println(res.length() + "\t" + res);
		char[] resChar = ReplaceSpaceInPlace3(test.toCharArray());
		System.out.println("\t" + Arrays.toString(resChar));
		char[] resChar2 = ReplaceSpaceInPlace4(test.toCharArray());
		System.out.println("\t" + Arrays.toString(resChar2));
		
	}
	
	public static String replaceSpace(String x){
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<x.length();i++){
			
			if(x.charAt(i)==' '){
				//sb.replace(i, i+1, "%20");
				sb.append("%20");
			}else{
				sb.append(x.charAt(i));
			}
			
		}
		
		
		return sb.toString();
		
	}
	
	
	public static String ReplaceSpaceBack(char[] x){
		
		
		StringBuilder sb = new StringBuilder();
		
		int len = x.length;
		for(int i=0;i<len;){
			
			if(x[i]=='%'){
				if(i+2<len && x[i+1]=='2' &&x[i+2]=='0')
				sb.append(" ");
				i=i+3;
			}else{
				sb.append(x[i]);
				i=i+1;
			}
			
		}
		
		
		return sb.toString();
		
	}
	
	public static String ReplaceSpaceInPlace(char[] x){
		
		int len = x.length;
		for(int i=len-1;i>=0;){

			if(x[i]=='0'){
				if(i-2>=0 && x[i-1]=='2' &&x[i-2]=='%'){
					x[i]=' ';
					x[i-1]=' ';
					x[i-2]=' ';
					i=i-3;
				}else{
					i--;
				}
				

			}else{
				
				i--;
			}
			
		}
		
		System.out.println("\t"+x.length);
		
		return new String(x);
		
	}
	
	public static String ReplaceSpaceInPlace2(char[] x){
		
		int len = x.length;
		for(int i=len-1;i>=0;i--){
			
			if(x[i]=='0'){
				if(i-2>=0 && x[i-1]=='2' &&x[i-2]=='%'){
					x[i]=' ';
					x[i-1]=' ';
					x[i-2]=' ';
					for(int j=i-1;j>0;j--){
						x[j]=x[j-1];
					}
				}
			}
			
		}
		
		System.out.println("\t"+x.length);
		
		return new String(x);
		
	}
	public static String ReplaceSpaceInPlace2(String x){
		
		String[] helpers =x.split("%20");
		String ret="";
		for(int i=1;i<helpers.length;i++){
			ret +=" "+helpers[i];
		}
//		if(helpers[0].length()==0)return ret.substring(1);
			return helpers[0] + ret;

	}
	
	public static char[] ReplaceSpaceInPlace3(char[] x){
		
		int len = x.length;
		int count=0;
		for(int i=0;i<len;i++){
			
			if(x[i]=='%'){
				if(i+2<len && x[i+1]=='2' &&x[i+2]=='0'){
					count++;
					x[i]=' ';
					System.arraycopy(x, i+3, x, i+1, len-3-i);
				}
			}
			
		}
		
		System.out.println(len-2*count);
		
		return x;
		
		
	}
	public static char[] ReplaceSpaceInPlace4(char[] x){
		
		int len = x.length;
		int count=0;
		int i;
		for(i=0;i<len;i++){
			
			if(x[i]=='%'){
				if(i+2<len && x[i+1]=='2' &&x[i+2]=='0'){
					count++;
					x[i]=' ';
					System.arraycopy(x, i+3, x, i+1, len-1-2-i);
					len=len-2;
				}
			}
			
		}
		
		System.out.println("\t"+i);
		System.out.println("\t"+len);
		
		return x;
		
		
	}
	
	

}
