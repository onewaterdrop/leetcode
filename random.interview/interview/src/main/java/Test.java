import java.util.regex.*;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("a,b,c,d");
		System.out.println();
		System.out.println("a,b,c,d");
		String x ="12345";
		CharSequence cs = "234324";
		Character y=cs.charAt(1);
		System.out.println(y);
		java.util.regex.Pattern p = Pattern.compile("^xyz");
		
		java.util.regex.Matcher m = p.matcher("xyzxm");
		System.out.println(m.find());
		
		System.out.println("---------");
		assert(Pattern.matches("a?b", "aab"));
		System.out.println(Pattern.matches("a?b", "aaab"));
		System.out.println(Pattern.matches("a?b", "ab"));
		System.out.println("---------");
		assert(Pattern.matches("a*b", "ab"));
		System.out.println(Pattern.matches("a*b", "aab"));
		System.out.println(Pattern.matches("a*b", "aaab"));
		System.out.println(Pattern.matches("a*b", "afb"));
		System.out.println("---------");
		assert(Pattern.matches("a+b", "aab"));
		System.out.println(Pattern.matches("a+b", "afb"));
		System.out.println(Pattern.matches("a+b", "aab"));
		
		assert(true);
	}

}
