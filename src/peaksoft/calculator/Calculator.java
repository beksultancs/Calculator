package peaksoft.calculator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.calculator.exceptions.CantCastToInteger;
import peaksoft.calculator.exceptions.CantDivideByZero;
import peaksoft.calculator.helper.Result;
import peaksoft.calculator.helper.type.Arabic;
import peaksoft.calculator.helper.type.Type;

import static peaksoft.calculator.helper.CalculatorHelper.*;

/**
 * created by Beksultan Mamatkadyr uulu
 * project : Calculator
 * 25/12/21
 * Saturday 16:39
 */
@NoArgsConstructor
@Getter
@Setter
public class Calculator <T extends Type> {
    private T type;
    private int a;
    private int b;
    private Character operation;

    public Calculator(T type,
                      String firstNum,
                      String secondNum,
                      Character operation) throws CantCastToInteger {
        this.type = type;
        if (isNumber(firstNum) && isNumber(secondNum)) {
            this.a = Integer.parseInt(firstNum);
            this.b = Integer.parseInt(secondNum);
        } else {
            this.a = castToInteger(firstNum);
            this.b = castToInteger(secondNum);
        }
        this.operation = operation;
    }

    public Result getResult() throws CantDivideByZero {
        if (type instanceof Arabic) {
            return new Result<Integer>(getValue());
        } else {
            return new Result<String>(castToRoman(getValue()));
        }
    }

    private int getValue() throws CantDivideByZero {
        int result = 0;
        switch (operation) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '*' -> result = a * b;
            case '/' -> {
                if (b == 0) {
                    throw new CantDivideByZero("can't divide by zero");
                } else {
                    result = a / b;
                }
            }
            case '%' -> result = a % b;
        }
        return result;
    }
}

