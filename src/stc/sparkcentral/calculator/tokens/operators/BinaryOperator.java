package stc.sparkcentral.calculator.tokens.operators;

import stc.sparkcentral.calculator.tokens.operands.Operand;

public interface BinaryOperator extends Operator {
    int Operate(Operand leftOperand, Operand rightOperand);
}
