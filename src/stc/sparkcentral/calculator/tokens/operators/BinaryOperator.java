package stc.sparkcentral.calculator.tokens.operators;

import com.sun.javaws.exceptions.InvalidArgumentException;
import stc.sparkcentral.calculator.tokens.operands.Operand;

public interface BinaryOperator extends Operator {
    int Operate(Operand leftOperand, Operand rightOperand) throws InvalidArgumentException;
}
