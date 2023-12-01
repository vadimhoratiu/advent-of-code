package vadim;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Aoc1 {
    private static final Map<String, Integer> numberMap = new HashMap<>();

    static {
        numberMap.put("0", 0);
        numberMap.put("1", 1);
        numberMap.put("2", 2);
        numberMap.put("3", 3);
        numberMap.put("4", 4);
        numberMap.put("5", 5);
        numberMap.put("6", 6);
        numberMap.put("7", 7);
        numberMap.put("8", 8);
        numberMap.put("9", 9);
        numberMap.put("one", 1);
        numberMap.put("two", 2);
        numberMap.put("three", 3);
        numberMap.put("four", 4);
        numberMap.put("five", 5);
        numberMap.put("six", 6);
        numberMap.put("seven", 7);
        numberMap.put("eight", 8);
        numberMap.put("nine", 9);
    }

    public static void main(String[] args) {
        Scanner scanner = getScanner();
        Integer total = 0;
        while (scanner.hasNext()) {
            total += getTotalForLine(scanner.next());
        }
        System.out.println(total);
    }

    private static Integer getTotalForLine(String line) {
        Set<String> stringsToLookFor = numberMap.keySet();
        String firstNumber = "0";
        String lastNumber = "0";
        int firstNoIndex = Integer.MAX_VALUE;
        int lastNoIndex = Integer.MIN_VALUE;
        for (String stringToLookFor : stringsToLookFor) {
            int firstIndex = line.indexOf(stringToLookFor);
            if (firstIndex == -1) {
                continue;
            }
            if (firstIndex < firstNoIndex) {
                firstNoIndex = firstIndex;
                firstNumber = stringToLookFor;
            }
            int lastIndex = line.lastIndexOf(stringToLookFor);
            if (lastIndex > lastNoIndex) {
                lastNoIndex = lastIndex;
                lastNumber = stringToLookFor;
            }
        }
        return Integer.parseInt(numberMap.get(firstNumber).toString() + numberMap.get(lastNumber).toString());
    }


    public static Scanner getScanner() {
        try {
            return new Scanner(new File(Aoc1.class.getResource("/aoc1.in").toURI()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
