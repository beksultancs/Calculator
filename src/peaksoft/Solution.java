package peaksoft;

/**
 * created by Beksultan Mamatkadyr uulu
 * project : Calculator
 * 27/12/21
 * Monday 22:13
 */
public class Solution {
    public int romanToInt(String s) {
        return castToInteger(s);
    }

    public static int castToInteger(String romanNumber) {
        String underProcess = makeMyRomanType(romanNumber);
        System.err.println(underProcess);
        int arabicNumber = 0;
        char[] romanNumbers = underProcess.toCharArray();
        for (int i = 0; i < romanNumbers.length; i++) {
            arabicNumber += Integer.parseInt(romanToArabic(romanNumbers[i]));
        }
        return arabicNumber;
    }

    private static String makeMyRomanType(String roman) {
        roman = roman.replaceAll("IV", "F");
        roman = roman.replaceAll("IX", "N");
        roman = roman.replaceAll("CD", "T");
        roman = roman.replaceAll("CM", "P");
        roman = roman.replaceAll("XC", "B");
        roman = roman.replaceAll("XL", "K");
        return roman;
    }

    public static String romanToArabic(char romanNumber)  {
        return switch (romanNumber) {
            case 'I' -> "1";
            case 'F' -> "4";
            case 'V' -> "5";
            case 'N' -> "9";
            case 'X' -> "10";
            case 'K' -> "40";
            case 'L' -> "50";
            case 'B' -> "90";
            case 'C' -> "100";
            case 'T' -> "400";
            case 'D' -> "500";
            case 'P' -> "900";
            case 'M' -> "1000";
            default -> "";
        };
    }



}
