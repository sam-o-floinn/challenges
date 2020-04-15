/* Challenge - Find the Odd:
 * Given an array of ints, find the int that appears an odd number of times.
 * Assume there will always be at least one int, and only one, that appears an odd amount of times
 */

public class FindTheOdd {
    public static int findIt(int[] a) {
        //double nested loop approach
        int odd = 0; //the int that appears an odd number of times

        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[j] == a[i]) {
                    count++;
                }
            }
            if ((count % 2) == 1) {
                //       System.out.println("Found the odd! Returning " + a[i]);
                odd = a[i];
                break;
            }
            //   System.out.println("Next number");
        }
        return odd;
    }
    public static int findItWithXor(int[] A) {
        //nested loop with XOR approach
        int odd = 0;
        for (int item : A) {
            odd = odd ^ item;
            // XOR will cancel out everytime you XOR with the same number
            // so 1^1=0 but 1^1^1=1 so every pair should cancel out leaving the odd number out
        }

        return odd;
    }
}
