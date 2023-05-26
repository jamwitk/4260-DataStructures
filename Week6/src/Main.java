public class Main {
    public static void main(String[] args) {
        System.out.println("First Question: ");
        System.out.println(FirstQuestion(11,12345,24683));
        System.out.println("Second Question: ");
        SecondQuestion(5,3);
        System.out.println("Third Question: ");
        ThirdQuestion(4,3);
        System.out.println("Fourth Question: ");
        FourthQuestion(7);
    }
    public static int FirstQuestion(int a, int n, int p) {
        if (n == 0)
            return 1;
        else if (n % 2 == 0)
            return FirstQuestion((a * a) % p, n / 2, p);
        else
            return (a * FirstQuestion((a * a) % p, (n - 1) / 2, p)) % p;
    }
    public static void SecondQuestion(int n, int k){
        SecondQuestion(n,k,1,"");
    }
    public static void SecondQuestion(int n, int k, int i, String s){
        if(k==0){
            System.out.println("{"+s+"}");
            return;
        }
        if(i>n)
            return;
        SecondQuestion(n,k-1,i+1,s+i+ (k == 1 ? "" : ","));
        SecondQuestion(n,k,i+1,s);
    }

    public static void ThirdQuestion(int n, int k){
        ThirdQuestion(n,k,"");
    }
    public static void ThirdQuestion(int n, int k, String s){
        if(k==0){
            if(n==0)
                System.out.println("{"+s+"}");
            return;
        }
        for (int i = n; i >= 0; i--) {
            ThirdQuestion(n-i,k-1,s+ (s.length() == 0 ? "" : ",")+i);
        }
    }
    public static void FourthQuestion(int n) {
        FourthQuestion(n, n, "",n);
    }
    public static void FourthQuestion(int n, int max, String s,int original) {
        if (n == 0) {
            System.out.println(original + " = "+s);
            return;
        }
        for (int i = Math.min(max, n); i >= 1; i--) {
            FourthQuestion(n - i, i, s + (s.length()==0 ? "" : " + ") + i,original);
        }
    }

}