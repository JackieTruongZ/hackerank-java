package Week2.drawingBook;

import java.io.*;

class Result {

    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {
        // Write your code here
        if (p == 1) {
            return 0;
        }
        if (n % 2 == 1) {
            if (p == n || p == n-1) {
                return 0;
            }
            n--;
        }

        if (n % 2 == 0) {
            if (p == n) {
                return 0;
            }
        }

        int start = (p % 2 == 0) ? (p - 1) : (p - 2);
        int end = (p % 2 == 0) ? (n - p - 1) : (n - p);

        int step = Math.min(start, end);

        step = (step+1)/2 ;

        return step;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.pageCount(n, p);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
