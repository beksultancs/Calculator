package peaksoft.calculator.helper;

import peaksoft.calculator.exceptions.InvalidProblemException;
import peaksoft.calculator.exceptions.OperationNotFoundException;

import java.util.Arrays;

import static peaksoft.calculator.helper.CalculatorHelper.*;

/**
 * created by Beksultan Mamatkadyr uulu
 * project : Calculator
 * 25/12/21
 * Saturday 18:05
 */
public class Check {

    public static boolean isNumbers(String problem) {
        return problem.matches("[0-9]*");
    }

    public static boolean isValid(String problem) throws OperationNotFoundException, InvalidProblemException {
        if (problem.length() <= 2) {
            throw new InvalidProblemException("invalid problem");
        }
        problem = replaceWithSpace(problem);
        String[] strings = splitProblems(problem);
        if (strings.length < 2) {
            return false;
        }

        if (strings.length > 2) {
            throw new InvalidProblemException("there more than two operations or given incorrect");
        }

        String a = strings[0];
        String b = strings[1];

        if (a == null && b == null) {
            throw new InvalidProblemException("invalid problem: you give incorrect problem ");
        }

        if (isRoman(a) && isRoman(b)) {

        } else if (isNumbers(a) && isNumbers(b)) {

        } else if (isNumbers(a) && isRoman(b) || isNumbers(b) && isRoman(a)) {
            throw new InvalidProblemException("invalid problem: both sides must be equal");
        } else {
            throw new InvalidProblemException("invalid arabic numbers or roman numbers");
        }
        return true;
    }

    public static boolean isRomanNumbers(String[] problems) {
        boolean roman = false;
        for (String problem : problems) {
            if (isRoman(problem)) {
                roman = true;
            } else {
                roman = false;
            }
        }
        return roman;
    }
    public static boolean isRoman(String problem) {
        return problem.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
    }
}
