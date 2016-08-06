package stc.sparkcentral.calculator.tokens.operators;

import stc.sparkcentral.calculator.tokens.operands.Operand;

public class AdditionOperator implements BinaryOperator {
    @Override
    public int Operate(Operand leftOperand, Operand rightOperand) {
        return leftOperand.evaluate() + rightOperand.evaluate();
    }
}
