package hufs.eselab.Practice;

public class String_Practice {
    public static void main(String[] args){
        String str = "^(*^^*adaf^&(a128S^D(A987(A*SD^&FA7(^DF^(AS%^FA%S(";


        /**
         * Highly Useful
         * 문자열 filter - replaceAll, regular expression
         */
        String str_filtered = str.replaceAll("[^A-Za-z0-9]","");
        System.out.println(str_filtered);

    }
}
