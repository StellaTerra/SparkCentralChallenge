package stc.sparkcentral.calculator;

import com.sun.javaws.exceptions.InvalidArgumentException;
import stc.sparkcentral.calculator.tokens.Token;
import stc.sparkcentral.calculator.tokens.operands.ExpressionOperand;
import stc.sparkcentral.calculator.tokens.operands.IntegerOperand;
import stc.sparkcentral.calculator.tokens.operands.Operand;
import stc.sparkcentral.calculator.tokens.operators.AdditionOperator;
import stc.sparkcentral.calculator.tokens.operators.BinaryOperator;
import stc.sparkcentral.calculator.tokens.operators.Operator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public int processCalculation(String rawCalculation) throws InvalidArgumentException {
        List<Token> tokens = tokenize(rawCalculation);

        return new ExpressionOperand(tokens).evaluate();
    }

    private List<Token> tokenize(String rawInput)
    {
        String[] rawTokens = rawInput.split(" ");

        List<Token> output = new ArrayList<Token>();
        for (String rawToken : rawTokens) {
            switch (rawToken) {
                case "+":
                    output.add(new AdditionOperator());
                    break;
                default:
                    int integerToken;
                    try {
                        integerToken = Integer.parseInt(rawToken);
                    } catch (NumberFormatException e) {
                      throw new IllegalArgumentException(
                              String.format("An argument \"%s\" was received, but it is not recognized as a valid " +
                                      "operator, nor operand.", rawToken), e);
                    }
                    output.add(new IntegerOperand(integerToken));

                    break;
            }
        }

        return output;
    }
}
