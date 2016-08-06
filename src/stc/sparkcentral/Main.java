package stc.sparkcentral;

import stc.sparkcentral.calculator.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.processCalculation("1 + 2"));
    }
}
