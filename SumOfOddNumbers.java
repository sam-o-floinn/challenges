/* Challenge: Sum of Odd Number Pyramid.
- Pyramid of odd numbers. row 1 = 1. row 2 = 3, 5. row 3 = 7, 11, 13, etc.
- given argument n = the requested row,
     - return the sum of all the numbers on that row
*/

class RowSumOddNumbers {
    public static int rowSumOddNumbers(int n) {

        return n*n*n;

        /*Explanation:
         * sum of consequent M numbers is (M+1)M/2, so
         * we may know how many numbers were below
         * our ROW : numbersBelow = ((n-1)*(n))/2.
         * Now we may calculate the first number in row:
         * firstNumberInRow = 2*numbersBelow+1.
         * So, firstNumberInRow = n*n-n+1 and
         * last number in ROW is n*n-n+1 + 2(n-1).
         * Let assume that last number before row is
         * x1 and last number in row is x2. It's known
         * that 1+3+5+...+(2k-1) = k*k.
         * Sum in row must be x2*x2 - x1*x1.
         // OUR x1 = (n*n-n)/2 and x2 = (n*n+n)/2.
         * After some simplification: SUM = n*n*n. */
    }
}