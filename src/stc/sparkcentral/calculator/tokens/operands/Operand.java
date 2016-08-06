package stc.sparkcentral.calculator.tokens.operands;

import stc.sparkcentral.calculator.tokens.Token;

public interface Operand extends Token {
    int evaluate();
}
