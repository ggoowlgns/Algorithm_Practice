package hufs.eselab.AlgorithmClass;

public class FirstClass {
    public static void main(String[] args) {
        System.out.println(GCD(1000,2));

    }

    /**
     * '-'   -->  '%' Faster
     * @param a
     * @param b
     * @return
     */
    static int GCD(int a , int b){
        int ret = 1;
        // %를 쓸때는 0일때 /zero error 을 피해주기위해 base case를 넣는다.
        if(a== 0 || b==0) return a==0? b:a;
        if(a>b){
//            ret = GCD(a-b,b);
            ret = GCD(a%b,b);
        }
        else if(a<b){
//            ret = GCD(a,b-a);
            ret = GCD(a,b%a);
        }else return a;
        return ret;
    }
}
