package math_app.math_service;

public class Divide implements MathOperations{
    @Override
    public String getOperation(double val1, double val2) {
        if (val2 != 0) return String.valueOf(val1 / val2);
        else return "error divide by 0";
    }

    @Override
    public String getOperationSign() {
        return "/";
    }

    @Override
    public String getOperationWord() {
        return "div";
    }
}
