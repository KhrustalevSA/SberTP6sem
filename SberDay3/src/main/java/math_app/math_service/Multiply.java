package math_app.math_service;

public class Multiply implements MathOperations{
    @Override
    public String getOperation(double val1, double val2) {
        return String.valueOf(val1 * val2);
    }

    @Override
    public String getOperationSign() {
        return "*";
    }
    @Override
    public String getOperationWord() {
        return "mul";
    }
}
