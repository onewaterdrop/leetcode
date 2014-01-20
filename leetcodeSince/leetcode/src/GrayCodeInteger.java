
public class GrayCodeInteger {

    // append reverse of order n gray code to prefix string, and print
    public static void yarg(Integer prefix, int n) {
        if (n == 0) System.out.println(prefix);
        else {
            gray(prefix*2 + 1, n - 1);
            yarg(prefix*2 + 0, n - 1);
        }
    }  

    // append order n gray code to end of prefix string, and print
    public static void gray(Integer prefix, int n) {
        if (n == 0) System.out.println(prefix);
        else {
            gray(prefix*2 + 0 , n - 1);
            yarg(prefix*2 + 1,  n - 1);
        }
    }  


    public static void main(String[] args) {
 //       int N = Integer.parseInt(args[0]);
        gray(0, 5);
    }

}