package stc.sparkcentral;

import stc.sparkcentral.calculator.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        try {
            System.out.println(calc.processCalculation("1 + 2"));
        }
        catch (Exception e)
        {
            System.out.print("things broke!");
        }
    }
}
