package Week2.caesarCipher;

import java.io.*;

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        // Write your code here
        StringBuilder stringBuilder = new StringBuilder(s);
        k = k % 26;
        for (int i = 0; i < s.length(); i++) {
            if ((int) stringBuilder.charAt(i) <= (int) 'z' && (int) stringBuilder.charAt(i) >= (int) 'a' ) {
                if ((int) stringBuilder.charAt(i) <= (int) 'z' - k) {
                    char ch = (char) ((int) stringBuilder.charAt(i) + k);
                    stringBuilder.setCharAt(i, ch);
                } else {
                    char ch = (char) ((int) stringBuilder.charAt(i) + k - 26);
                    stringBuilder.setCharAt(i, ch);
                }
            }
            if ((int) stringBuilder.charAt(i) <= (int) 'Z' && (int) stringBuilder.charAt(i) >= (int) 'A' ) {
                if ((int) stringBuilder.charAt(i) <= (int) 'Z' - k) {
                    char ch = (char) ((int) stringBuilder.charAt(i) + k);
                    stringBuilder.setCharAt(i, ch);
                } else {
                    char ch = (char) ((int) stringBuilder.charAt(i) + k - 26);
                    stringBuilder.setCharAt(i, ch);
                }
            }
        }
        return  stringBuilder.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        System.out.println(result);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
