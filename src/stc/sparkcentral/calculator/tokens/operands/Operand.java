package stc.sparkcentral.calculator.tokens.operands;

import com.sun.javaws.exceptions.InvalidArgumentException;
import stc.sparkcentral.calculator.tokens.Token;

public interface Operand extends Token {
    int evaluate() throws InvalidArgumentException;
}
