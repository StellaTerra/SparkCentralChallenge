package stc.sparkcentral.calculator.tokens.operands;

public class IntegerOperand implements Operand {
    private int value;

    public IntegerOperand(int value)
    {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }
}
