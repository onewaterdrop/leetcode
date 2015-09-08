package real.interview.facebook;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatch {

	
//	console.log(checkMatching("aa", "a")); //false
//	console.log(checkMatching("aa", "aa")); //true
//	console.log(checkMatching("aa", "a*")); //true
//	console.log(checkMatching("aa", "*")); //true
//	console.log(checkMatching("a", "b*a")); //true
//	console.log(checkMatching("a", "a*a")); //true
//	console.log(checkMatching("a", "b*a*a")); //true 
//	console.log(checkMatching("aab", "c*a*b")); //true
//	console.log(checkMatching("ccccccaaab", "c*a*b")); //true
//	console.log(checkMatching("ccccccb", "c*a*b")); //true
//	console.log(checkMatching("ccccccb", "c*a*b")); //true
//	console.log(checkMatching("bz", "c*a*bz")); //true
//	console.log(checkMatching("ccccb", "w*c*a*b")); //true
//	console.log(checkMatching("wz", "w*c*a*b")); //false
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringMatch m = new StringMatch();
//		System.out.println(m.checkMatching("aa", "a")); //false;
//		System.out.println(m.checkMatching("aa", "aa")); //true;
//		System.out.println(m.checkMatching("aa", "a*")); //true;
//		System.out.println(m.checkMatching("a", "b*a")); //true
//		System.out.println(m.checkMatching("a", "a*a")); //true
//		System.out.println(m.checkMatching("a", "b*a*a")); //true
//		System.out.println(m.checkMatching("aab", "c*a*b")); //true
//		System.out.println(m.checkMatching("ccccccaaab", "c*a*b")); //true
//		System.out.println(m.checkMatching("ccccccb", "c*a*b")); //true
//		System.out.println(m.checkMatching("bz", "c*a*bz")); //true
//		System.out.println(m.checkMatching("ccccb", "w*c*a*b")); //true
//		System.out.println(m.checkMatching("wz", "w*c*a*b")); //false;
//		System.out.println(m.checkMatching("aa", "a.")); //true
//		System.out.println(m.checkMatching("aa", "a")); //false;	
//		System.out.println(m.checkMatching("aa", "a.b")); //false;
//		System.out.println(m.checkMatching("aba", "a.a")); //true;	
//		System.out.println(m.checkMatching("aba", "a.*a")); //exception;
		
		int[] arr = {15,4,25,6,-1,4,-2};
		System.out.println(m.maxDrop3(arr));
		int[] rotate = {7,8,9,1,2,3,4,5,6};
		System.out.println(Arrays.binarySearch(rotate,0,9,9));
		Pattern pat = Pattern.compile("a*");
		Matcher mat = pat.matcher("bzsdfaaa");
		if(mat.find()){
			System.out.println(mat.start());
		}
		
		
	}
	
	
	boolean checkMatching(String src,String pat){
		
		return isMatchHelper3(src,pat,src.length()-1,pat.length()-1);
	}
	boolean isMatchHelper(String src,String pat,int srcIndex,int patIndex){
		if("*".equals(pat))return true;
		if(srcIndex<0&&patIndex<0)return true;
		if(srcIndex<0){
			while(patIndex>=0){
				if(pat.charAt(patIndex)=='*'){
					patIndex -=2;
				}else{
					return false;
				}
				
			}
			return true;
			
		}else if(patIndex<0){
			return false;
		}
		//case srcIndex =0 and patIndex = -1;
		
		if(src.charAt(srcIndex)==pat.charAt(patIndex)){
			return isMatchHelper(src,pat,srcIndex-1,patIndex-1);
		}else if(pat.charAt(patIndex) == '*'){
			if(src.charAt(srcIndex) == pat.charAt(patIndex-1)){
				return isMatchHelper(src,pat,srcIndex-1,patIndex);
			}else{
				return isMatchHelper(src,pat,srcIndex,patIndex-2);
			}
			
		}else{
			return false;
		}
		
		
	}
	
	
	int indexOf(String src, String pat){
		if(src == null || pat == null) return -1;
		int n1 = src.length();
		int n2 = pat.length();
		if(n2>n1)return -1;
		for(int i =0;i<n1-n2;i++){
			if(src.substring(i, i+n2).equals(pat))return i;
		}
		
		return -1;
	}
	
	boolean isMatchHelper2(String src,String pat,int srcIndex,int patIndex){
		if("*".equals(pat))return true;
		else if(srcIndex<0&&patIndex<0) return true;
		else if(srcIndex<0){
			while(patIndex>=0){
				if(pat.charAt(patIndex) =='*')patIndex -=2;
				else return false;
			}
			return true;
		}else if(patIndex<0){
			return false;
		}
		
		if(src.charAt(srcIndex) == pat.charAt(patIndex)) return isMatchHelper2(src,pat,srcIndex-1,patIndex-1);
		else if(pat.charAt(patIndex)=='*'){
			if(src.charAt(srcIndex) == pat.charAt(patIndex-1))return  isMatchHelper2(src,pat,srcIndex-1,patIndex);
			else return  isMatchHelper2(src,pat,srcIndex,patIndex-2);	
		}else{
			return false;
		}
	}
	
	boolean isMatchHelper3(String src,String pat,int sIndex,int pIndex){
		if("*".equals(pat))return true;
		if(sIndex<0&&pIndex<0)return true;
		else if(sIndex<0){
			while(pIndex>=0){
				if(pat.charAt(pIndex)=='*'){
					pIndex -=2;
				}else{
					return false;
				}
			}
			
			return true;
		}else if(pIndex<0){
			return false;
		}
		
		if(src.charAt(sIndex) == pat.charAt(pIndex))return isMatchHelper3(src,pat,sIndex-1,pIndex-1);
		else if(pat.charAt(pIndex) == '.') return isMatchHelper3(src,pat,sIndex-1,pIndex-1);
		else if(pat.charAt(pIndex) == '*') {
			if(src.charAt(sIndex) == pat.charAt(pIndex-1)) return isMatchHelper3(src,pat,sIndex-1,pIndex);
			else if(pat.charAt(pIndex-1) == '.') throw new IllegalArgumentException("Invalid pattern");
			else return isMatchHelper3(src,pat,sIndex,pIndex-2);
		}else{
			return false;
		}
		
		
	}
	
	boolean isMatchHelper4(String src,String pat,int sIndex,int pIndex){
		if("*".equals(pat))return true;
		if(sIndex<0&&pIndex<0)return true;
		else if(sIndex<0){
			while(pIndex>=0){
				if(pat.charAt(pIndex)=='*')pIndex -=2;
				else return false;
				
			}
			return true;
		}else if(pIndex<0){
			return false;
		}
		
		if(src.charAt(sIndex) == pat.charAt(pIndex) || pat.charAt(pIndex) == '.')return isMatchHelper4(src,pat,sIndex-1,pIndex-1);
		else if(pat.charAt(pIndex) == '*'){
			if(src.charAt(sIndex) == pat.charAt(pIndex-1))return isMatchHelper4(src,pat,sIndex-1,pIndex);
			else return isMatchHelper4(src,pat,sIndex,pIndex-2);
		}
		else return false;
		
	}
	
	//any two and the second comes after the first one
	
	int maxDrop2(int[] arr){
		int maxdrop =0;int max=0;
		for(int j=1;j<=arr.length-1;j++){
			for(int i=0;i<arr.length-j;i++){
				maxdrop = Math.max(maxdrop,arr[i]-arr[i+j]);
			}
			max = Math.max(maxdrop,max);
		}
		
//		maxdrop = Math.max(maxdrop,arr[arr.length-1]-arr[0]);
		
		return maxdrop;
	}
	int maxDrop3(int[] arr){
		//Di = Math.max(Di-1,Max(i-1)-A[i]);
		
		if(arr == null) return -1;
		
		int maxdrop =0;int max=arr[0];
		for(int i=1;i<arr.length;i++){
			maxdrop = Math.max(maxdrop, max-arr[i]);
			max = Math.max(max, arr[i]);
		}
		
//		maxdrop = Math.max(maxdrop,arr[arr.length-1]-arr[0]);
		
		return maxdrop;
	}
	
	int maxDrop(int[] arr){
		int maxdrop =0;
		for(int i=0;i<arr.length-1;i++){
			maxdrop = Math.max(maxdrop,arr[i]-arr[i+1]);
		}
		
//		maxdrop = Math.max(maxdrop,arr[arr.length-1]-arr[0]);
		
		return maxdrop;
	}

}
