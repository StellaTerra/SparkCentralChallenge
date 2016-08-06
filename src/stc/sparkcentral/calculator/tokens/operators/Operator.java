package stc.sparkcentral.calculator.tokens.operators;

import stc.sparkcentral.calculator.tokens.Token;

public interface Operator extends Token {
    /**
     * parentheses are 1
     * exponents are 2
     * multiplication and division are 3
     * addition and subtraction are 4
     * @return
     */
    int OrderOfOperationsPriority();
}
