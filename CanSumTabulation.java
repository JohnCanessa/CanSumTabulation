import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 */
public class CanSumTabulation {


    /**
     * Write a function `canSum(targetSum, numbers)` that takes in a 
     * targetSum and an array of numbers as arguments.
     * 
     * The function should return a boolean indicating wether or not it
     * is possible to generate the targetSum using numbers from the array.
     * 
     * You may use an element of the array as many times as needed.
     * 
     * You may assume that all input members are nonnegative.
     * 
     * m = targetSum
     * n = numbers.length
     * Time: O(m*n) - Space O(m)
     */
    static boolean canSum(int targetSum, int[] numbers) {

        // **** sanity check(s) ****
        if (targetSum == 0) return true;

        // **** initialization ****
        boolean[] table = new boolean[targetSum + 1];
        table[0] = true;            // base case

        // **** loop through the table ****
        for (int i = 0; i <= targetSum; i++) {

            // **** check if true ****
            if (table[i] == true) {

                // **** loop through the numbers array ****
                for (int j = 0; j < numbers.length; j++) {

                    // **** for ease of use ****
                    int num = numbers[j];

                    // **** if valid index; set to true ****
                    if (i + num <= targetSum) table[i + num] = true;
                }
            }
        }

        // ???? ????
        System.out.println("canSum <<< table: " + Arrays.toString(table));

        // **** return result ****
        return table[targetSum];
    }


    /**
     * Test scaffold
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // **** read target sum ***
        int targetSum = Integer.parseInt(br.readLine().trim());

        // **** read numbers ****
        int[] numbers = Arrays.stream(br.readLine().trim().split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< targetSum: " + targetSum);
        System.out.println("main <<< numbers: " + Arrays.toString(numbers));

        // **** compute and display result ****
        System.out.println("main <<< canSum: " + canSum(targetSum, numbers));
    }

}