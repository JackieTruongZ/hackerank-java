package Week3.climbingTheLeaderBoard;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        int index = 0;

        List<Integer> rankSort = new ArrayList<>();
        List<Integer> rankResult = new ArrayList<>();
        rankSort.add(ranked.get(0));

        for (int i = 1; i < ranked.size(); i++) {
            if (rankSort.get(index) - ranked.get(i) != 0) {
                rankSort.add(ranked.get(i));
                index++ ;
            }
        }

        for (int score : player) {
            int start = rankSort.size()-1;

            if (score >= rankSort.get(0)) {
                rankResult.add(1);
            } else {
                for ( ; start >= 0; start--) {
                    if (score < rankSort.get(start)) {
                        rankResult.add(start + 2);
                        break;
                    }
                }
            }
        }

        for (int rank : rankResult) {
            System.out.println(rank);
        }
        System.out.println(rankResult.size());

        return rankResult;


    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        System.out.println(result);

//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
