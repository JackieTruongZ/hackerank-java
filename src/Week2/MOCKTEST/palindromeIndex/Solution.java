package Week2.MOCKTEST.palindromeIndex;

import java.io.*;
import java.util.stream.*;


class Result {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int palindromeIndex(String s) {
        // Write your code here
        for (int i = 0; i < s.length()/2 ; i++) {
            if ( s.charAt(i) != s.charAt(s.length() - 1 - i ) ) {
                if ( s.charAt(i) == s.charAt(s.length() - i - 2)  && s.charAt(i+1) == s.charAt(s.length() - i - 3 ) ) {
                    return s.length()-i-1;
                }
                if (s.charAt(i+1) == s.charAt(s.length() - i - 1)  && s.charAt(i+2) == s.charAt(s.length() - i - 2 )) {
                    return i;
                }
            }
        }

        return -1;
    }

}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.palindromeIndex(s);

                System.out.println(result);

//                bufferedWriter.write(String.valueOf(result));
//                bufferedWriter.newLine();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
