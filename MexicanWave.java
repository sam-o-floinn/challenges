/*
    Challenge: Mexican Wave
    Given a string, output it to act like a Mexican wave,
    where the first character will stand up, then sit down as the next stands up.

    e.g wave("hello") => []string{"Hello", "hEllo", "heLlo", "helLo", "hellO"}
 */

import java.util.*;

public class MexicanWave {

    public static String[] wave(String str) {
        //== fields ==
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ' ')
                continue;

            list.add(str.substring(0,i) + Character.toUpperCase(ch) + str.substring(i+1));
        }
        return list.toArray(new String[0]); //new String[0] is just to give toArray() the array type, not the array object
    }

}

