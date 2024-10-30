package Week2.counterGame;

import java.io.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'counterGame' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static String counterGame(long n) {
        // Write your code here

        boolean winCode = false;

        long num = n;

        if (n == 2 || n == 3) {
            return "Louise";
        }

        while (num > 1 ) {
            long newNum = num;
            long minusNum = 1;
            while (newNum >= 2) {
                newNum /= 2;
                minusNum *= 2;
            }

            if (num == minusNum) {
                num /= 2;
            } else {
                num = num - minusNum;
            }

            winCode = !winCode;
        }

        if (winCode) {
            return "Louise";
        } else  {
            return "Richard";
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                String result = Result.counterGame(n);

                System.out.println(result);

//                bufferedWriter.write(result);
//                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

