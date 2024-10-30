package Week2.towerBreakers;

import java.io.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'towerBreakers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    public static int towerBreakers(int n, int m) {
        // Write your code here
        if (m == 1) {
            // Player 1 cannot make a move, so Player 2 wins.
            return 2;
        } else if (n == 1) {
            // Player 1 can always reduce the tower to 1 and win.
            return 1;
        }

        // Determine the winner based on the parity of n:
        if (n % 2 == 0) {
            // Even number of towers: Player 2 wins with optimal play.
            return 2;
        } else {
            // Odd number of towers: Player 1 wins with optimal play.
            return 1;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr  -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.towerBreakers(n, m);

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
