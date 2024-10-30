package Week2.MOCKTEST.anagram;

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
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
        // Write your code here

        if (s.length() % 2 == 0) {
            int halfLength = s.length() / 2;

            // Split the string into two substrings
            StringBuilder firstHalf = new StringBuilder(s.substring(0, halfLength)) ;
            StringBuilder secondHalf = new StringBuilder(s.substring(halfLength));

            for (int i = 0; i < firstHalf.length(); i++) {
                for (int j = 0; j < secondHalf.length(); j++) {
                    if (firstHalf.charAt(i) == secondHalf.charAt(j)) {
                        firstHalf.setCharAt(i,'0');
                        secondHalf.setCharAt(j,'0');
                    }
                }
            }

            int count = 0;

            for (int i = 0; i < firstHalf.length(); i++) {
                if (firstHalf.charAt(i) != '0') {
                    count ++;
                }
            }
            return count;

        } else {
            return -1;
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.anagram(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

