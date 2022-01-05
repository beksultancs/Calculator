package peaksoft;

import peaksoft.calculator.Calculator;
import peaksoft.calculator.ManageCalculator;
import peaksoft.calculator.exceptions.CantCastToInteger;
import peaksoft.calculator.exceptions.CantDivideByZero;
import peaksoft.calculator.exceptions.InvalidProblemException;
import peaksoft.calculator.exceptions.OperationNotFoundException;
import peaksoft.calculator.helper.Check;
import peaksoft.calculator.helper.Result;
import peaksoft.calculator.helper.type.Arabic;
import peaksoft.calculator.helper.type.Roman;

import java.util.Scanner;

import static peaksoft.calculator.helper.CalculatorHelper.*;
import static peaksoft.calculator.helper.Check.*;


public class Main {

    public static void main(String[] args) throws CantCastToInteger {
     Solution solution = new Solution();
        System.out.println(solution.romanToInt("MCMXCIV"));
        System.out.println("hello");
    }
}
