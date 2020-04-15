/*
    Challenge: Sort the Odd Numbers.
    Given an array of numbers, sort the odd numbers in ascending order but leave even numbers where they are.
    e.g { 17, 2, 6, 1, 5, 4} = {1, 2, 6, 5, 17, 4}

    Zero isn't an odd number and needn't be moved. Return array if empty.
*/

import java.util.*;

import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

public class SortTheOdd {
    public static int[] sortArray(int[] array) {

        System.out.println(Arrays.toString(array));
        /*
          1) Loop through array
          2) If even, mark position and leave it be
          3) If odd, sort and place in ascending order
        */
        HashMap<Integer, Integer> oddPositions = new HashMap<Integer, Integer>(array.length);
        for (int i = 0; i < array.length; i++) {
            if ( array[i] % 2 == 1) {
                System.out.println("Odd found in array. Adding " + array[i]);
                oddPositions.put(i, array[i]); //odd values go in here under the respective index
            }
        }

        //next, sort oddPositions hashmap using a stream
        Map<Integer, Integer> sortedOdd =
            oddPositions
                .entrySet() //gets the entry set (i.e oddPositions.entrySet())
                .stream() //Get the stream of entries by calling stream() method
                .sorted(comparingByValue()) //Call the sorted method with a Comparator, via the Map.Entry.comparingByValue() sort method
                .collect(  //Collect the result using the collect() method
                    toMap(Map.Entry::getKey, //Use Collectors.toMap() method to get the result in another Map.
                        Map.Entry::getValue, (e1, e2) -> e2, //Provide LinkedHashMap::new to the last parameter
                        LinkedHashMap::new)); //to force it to return a LinkedHashMap, to keep the sorted order preserved

        //sort the keys
        Iterator sortIterator = sortedOdd.entrySet().iterator();

        //test by printing the whole thing
        System.out.println("SortedSet Values:");
        sortedOdd.forEach((key, value) -> System.out.println(key + ": " + value));

        int[] sorted = new int[array.length];
        //If we can FIND i as a key in oddPositions, it must be odd. So put in oddPositions.getValue(i)
        //Else, put in array[i] instead

        for (int i = 0; i < array.length; i++) {
            if (sortedOdd.containsKey(i)) { //get first value
                Map.Entry elm = (Map.Entry)sortIterator.next();
                System.out.println("Odd found. Adding " + sortedOdd.get(i));
                sorted[i] = (int)elm.getValue();
            } else { //assume even
                System.out.println("Even found. Adding " + array[i]);
                sorted[i] = array[i];
            }
        }

        System.out.println(Arrays.toString(sorted)); //for quick testing

        return sorted;
    }
}