public class Calculator {
    public static String operator = "add";
    public static int add(int n1,int n2){
        return n1+n2;
    }

    public static int add2(int n1,int n2){
        if (n1 > n2){
            throw new IllegalArgumentException();
        }
        return n1+n2;
    }

}
