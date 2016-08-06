package stc.sparkcentral.calculator.tokens.operators;

import com.sun.javaws.exceptions.InvalidArgumentException;
import stc.sparkcentral.calculator.tokens.operands.Operand;

public class SubtractionOperator implements BinaryOperator {
    @Override
    public int Operate(Operand leftOperand, Operand rightOperand) throws InvalidArgumentException {
        return leftOperand.evaluate() - rightOperand.evaluate();
    }

    @Override
    public int OrderOfOperationsPriority() {
        return 4;
    }
}
