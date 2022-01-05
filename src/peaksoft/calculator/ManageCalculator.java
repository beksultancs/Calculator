package peaksoft.calculator;

import peaksoft.calculator.exceptions.CantCastToInteger;
import peaksoft.calculator.exceptions.CantDivideByZero;
import peaksoft.calculator.exceptions.InvalidProblemException;
import peaksoft.calculator.exceptions.OperationNotFoundException;
import peaksoft.calculator.helper.Result;
import peaksoft.calculator.helper.type.Arabic;
import peaksoft.calculator.helper.type.Roman;

import static peaksoft.calculator.helper.CalculatorHelper.*;
import static peaksoft.calculator.helper.Check.isRomanNumbers;
import static peaksoft.calculator.helper.Check.isValid;

/**
 * created by Beksultan Mamatkadyr uulu
 * project : Calculator
 * 25/12/21
 * Saturday 23:19
 */
public class ManageCalculator {

    public void run(String str) {
        final Roman roman = new Roman();
        final Arabic arabic = new Arabic();
        try {
            Calculator calculator = null;
            String problem = str;
            problem = problem.toUpperCase();
                if (isValid(problem)) {
                    char operation = getOperations(problem);
                    problem = replaceWithSpace(problem);
                    String[] strings = splitProblems(problem);
                    if (isRomanNumbers(strings)) {
                        calculator = new Calculator<Roman>(
                                roman,
                                strings[0],
                                strings[1],
                                operation
                        );
                    } else {
                        calculator = new Calculator<Arabic>(
                                arabic,
                                strings[0],
                                strings[1],
                                operation
                        );
                    }
                }
                Result result = calculator.getResult();
                System.out.println(result.getValue());
        } catch (OperationNotFoundException | InvalidProblemException | CantDivideByZero | CantCastToInteger e) {
            System.err.println(e.getMessage());
        }
    }
}
