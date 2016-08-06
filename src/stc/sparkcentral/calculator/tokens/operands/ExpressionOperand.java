package stc.sparkcentral.calculator.tokens.operands;

import com.sun.javaws.exceptions.InvalidArgumentException;
import stc.sparkcentral.calculator.tokens.Token;
import stc.sparkcentral.calculator.tokens.operators.BinaryOperator;
import stc.sparkcentral.calculator.tokens.operators.Operator;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class ExpressionOperand implements Operand{
    private List<Token> tokens;

    public ExpressionOperand(List<Token> tokens)
    {
        this.tokens = tokens;
    }

    @Override
    public int evaluate() throws InvalidArgumentException {
        int highestPriorityOperator = 0;
        for (Token token : tokens) {
            if(token.getClass().isAssignableFrom(Operator.class) &&
                    ((Operator)token).OrderOfOperationsPriority() > highestPriorityOperator)
            {
                highestPriorityOperator = ((Operator)token).OrderOfOperationsPriority();
            }
        }

        List<Token> left = new ArrayList<>();
        List<Token> right = new ArrayList<>();
        boolean highestPriorityOperatorFound = false;
        Operator operator = null;
        for (Token token : tokens) {
            if(!highestPriorityOperatorFound &&
                    token.getClass().isAssignableFrom(Operator.class) &&
                    ((Operator)token).OrderOfOperationsPriority() == highestPriorityOperator)
            {
                highestPriorityOperatorFound = true;
                operator = (Operator)token;
            }
            else
            {
                if(highestPriorityOperatorFound == false)
                {
                    right.add(token);
                }
                else
                {
                    left.add(token);
                }
            }
        }

        if(!highestPriorityOperatorFound)
        {
            throw new InvalidArgumentException(new String[]{"No operators found!  Probably the input is malformed."});
        }
        if(!operator.getClass().isAssignableFrom(BinaryOperator.class))
        {
            throw new NotImplementedException();
        }

        Operand leftOperand;
        if(left.size() == 1)
        {
            leftOperand = (IntegerOperand)left.get(0);
        }
        else
        {
            leftOperand = new ExpressionOperand(left);
        }

        Operand rightOperand;
        if(left.size() == 1)
        {
            rightOperand = (IntegerOperand)left.get(0);
        }
        else
        {
            rightOperand = new ExpressionOperand(left);
        }

        return ((BinaryOperator)operator).Operate(leftOperand, rightOperand);
    }
}
