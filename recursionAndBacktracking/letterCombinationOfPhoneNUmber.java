package coding_practice.recursionAndBacktracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinationOfPhoneNUmber {
    public static void main(String[] args) {
        String digits = "23";

        List<String> list = combo(digits);

        for (String s : list) {
            System.out.print(s + " ");
        }
    }

    public static List<String> combo(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        generateCombinations(digits, 0, new StringBuilder(), result, map);

        return result;
    }

    public static void generateCombinations(String digits, int index, StringBuilder current, List<String> result,
            Map<Character, String> digitMap) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = digitMap.get(digit);

        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            generateCombinations(digits, index + 1, current, result, digitMap);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
