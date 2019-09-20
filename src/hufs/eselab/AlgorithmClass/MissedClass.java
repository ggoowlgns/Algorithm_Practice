package hufs.eselab.AlgorithmClass;


/***
 * 2019-09-18
 * 수업 빠짐
 * **/


public class MissedClass {
    public static void main(String[] args) {

    }
    /**
     *  최악의 입력을 알아야 하는 이유: 그 알고리즘의 수행 시간을 보장 할 수 있다.

     def arrayMax(A, n):
     M = A[0]
     for i in range(1, n):
     if M < A[i]:
     M = A[i]
     return M
     T(n) = 2n-1

     def count(n):
     k=1
     while k*k<n:
     k=k+1
     T(n) = 4*sqrt(n) + 1

     def sum(A, B, n):
     s=0
     for i in range(n):
     for j in range(i, n):
     s = s+A[i]*B[j]
     return s
     T(n) = 3* n(n+1)/2 +1 = 3/2*n^2 + 3/2*n + 1

     T(n) 증가율(growth ratio)이 중요! 증가율은 최고차항이 결정!
     */


    /**
     * Time Complexity
     * T(n) = 2n-1
     * @param A
     * @param n
     * @return
     */
    public static int arrayMax(int[] A, int n){
        int M = A[0];
        for(int i=1;i<n;i++ ){
            M = Math.max(M,A[0]);
        }
        return M;
    }

    /**
     * Time Complexity
     * T(n) = 4*sqrt(n) + 1
     * @param n
     * @return
     */
    public static int count(int n){
        int k =1;
        while((k*k) <n) k+=1;
        return k;
    }

    /**
     * Time Complexity
     * T(n) = 3* n(n+1)/2 +1 = 3/2*n^2 + 3/2*n + 1
     * T(n) 증가율(growth ratio)이 중요! 증가율은 최고차항이 결정!
     * @param A
     * @param B
     * @param n
     * @return
     */
    public static int sum(int[] A, int[] B, int n){
        int s = 0;
        for(int i=0; i<n;  i++){
            for(int j=i; j<n ; j++){
                s = s+A[i]*B[j];
            }
        }
        return s;
    }
    /*********************************************************************************/


    /**
     *  <Big-O 표기법>
     T(n) = 2n-1  ->  O(n)
     T(n) = 4*sqrt(n) + 1  ->  O(sqrt(n))
     T(n) = 3* n(n+1)/2 +1 = 3/2*n^2 + 3/2*n + 1  ->  O(n^2)
     log10(n) = log2(n)/log2(10) = O(log2(n))

     nlog(n), n*sqrt(n) 비교
     log를 밑에 씌우면 loglog(n) < log(sqrt(n)) = 1/2*log(n)

     T(n) = 4^log2(n) + n^1.5 = O(n^2)
     T(n) = 10^-6*n^2 + 10^6 * n = O(n^2)
     뭐 대충 n*2가 증가율이 더 크다는 내용.

     Prefix

     s = [0]  * n
`     # S[i] = X[0] + X[1] + ... + X[i]
     for i in range(n):
     for j in range(i+1):
     S[i] = S[i] + X[j]
     T(n) = O(n^2)

     s = [0]*n
     s[0] = x[0]
     for i in range(1, n):
     s[i] = s[i-1] + x[i]
     T(n) = O(n)
     */
    /**
     * ?????? 호찬이한테 물어보기
     * @return
     */
    public static int[] prefix(){
        int[] ret = {};
        return ret;
    }





    /*********************************************************************************/

    /**
     *
     Selection Problem
     -Maximum
     -Minimum
     -Maximum + Minimum
     가장큰수를 찾고 싶다.
     전체 집합에서 두개씩 비교한다.
     두번째 큰 수를 찾고 싶다.
     => 1등에게 진 집합 안에있다.
     n+ [log2(n)] -2 비교하면 가장큰수와 두번째 큰수를 교할 수 있다.
     *
     */


}
