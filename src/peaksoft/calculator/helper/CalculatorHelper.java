package peaksoft.calculator.helper;

import peaksoft.calculator.exceptions.CantCastToInteger;
import peaksoft.calculator.exceptions.OperationNotFoundException;

import java.util.TreeMap;

import static peaksoft.calculator.helper.Roman.*;

/**
 * created by Beksultan Mamatkadyr uulu
 * project : Calculator
 * 25/12/21
 * Saturday 16:41
 */
public class CalculatorHelper {

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    public static boolean isNumber(String str) {
        try {
            int a = Integer.parseInt(str);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    public static String[] splitProblems(String problem) {
        String[] strings = problem.split(" ");
        return strings;
    }

    public static String replaceWithSpace(String problem) throws OperationNotFoundException {
        String result = null;
        if (problem.contains("+")) {
            result = problem.replace('+', ' ');
        } else if (problem.contains("-")) {
            result = problem.replace('-', ' ');
        } else if (problem.contains("*")) {
            result = problem.replace('*', ' ');
        } else if (problem.contains("/")) {
            result = problem.replace('/', ' ');
        } else if (problem.contains("%")) {
            result = problem.replace('%', ' ');
        } else {
            throw new OperationNotFoundException("operation not found");
        }
        return result;
    }

    public static Character getOperations(String problem) throws OperationNotFoundException {
        if (problem.contains("+")) {
            return '+';
        } else if (problem.contains("-")) {
            return '-';
        } else if (problem.contains("*")) {
            return '*';
        } else if (problem.contains("/")) {
            return '/';
        } else if (problem.contains("%")) {
            return '%';
        } else {
            throw new OperationNotFoundException("operation not found");
        }
    }

    public static int castToInteger(String romanNumber) throws CantCastToInteger {
        String underProcess = makeMyRomanType(romanNumber);
        int arabicNumber = 0;
        char[] romanNumbers = underProcess.toCharArray();
        for (int i = romanNumbers.length - 1; i >= 0; i--) {
            arabicNumber += Integer.parseInt(romanToArabic(romanNumbers[i]));
        }
        return arabicNumber;
    }

    private static String makeMyRomanType(String roman) {
        roman = roman.replaceAll("IV", "F");
        roman = roman.replaceAll("IX", "N");
        roman = roman.replaceAll("CD", "T");
        roman = roman.replaceAll("CM", "P");
        return roman;
    }

    public final static String castToRoman(int number) {
        int l = map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + castToRoman(number - l);
    }

    public static String romanToArabic(char romanNumber) throws CantCastToInteger {
        return switch (romanNumber) {
            case 'I' -> I.getValue();
            case 'F' -> F.getValue();
            case 'V' -> V.getValue();
            case 'N' -> N.getValue();
            case 'X' -> X.getValue();
            case 'L' -> L.getValue();
            case 'C' -> C.getValue();
            case 'T' -> T.getValue();
            case 'D' -> D.getValue();
            case 'P' -> P.getValue();
            case 'M' -> M.getValue();
            default -> throw new CantCastToInteger("impossible to cast");
        };
    }

}
