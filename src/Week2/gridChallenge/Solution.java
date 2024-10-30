package Week2.gridChallenge;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        int numRows = grid.size();
        int numCols = grid.get(0).length();

        // Kiểm tra xem tất cả các hàng có cùng độ dài hay không
        for (int i = 1; i < numRows; i++) {
            if (grid.get(i).length() != numCols) {
                return "NO"; // Các hàng không có cùng độ dài
            }
        }

        for (int i = 0; i < numRows; i++) {

            char[] charArray = grid.get(i).toCharArray();

            Arrays.sort(charArray);

            String strSorted = new String(charArray);

            grid.set(i,strSorted);

        }

        // Sắp xếp các ký tự trong mỗi cột và so sánh
        for (int col = 0; col < numCols; col++) {

            List<Character> chars = new ArrayList<>();

            for (int row = 0; row < numRows; row++) {
                chars.add(grid.get(row).charAt(col));
            }

            for (int row = 1; row < numRows; row++) {
                if (chars.get(row) < chars.get(row - 1)) {
                    return "NO"; // Cột không theo thứ tự tăng dần
                }
            }
        }

        return "YES"; // Tất cả các cột đều theo thứ tự tăng dần

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                String result = Result.gridChallenge(grid);

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
