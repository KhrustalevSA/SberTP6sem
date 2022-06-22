package math_app.math_service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MathServic {
    private String operation;
    private double firstValue;
    private double secondValue;
    private Set<MathOperations> mathOperationsSet = new HashSet<MathOperations>();

    public MathServic(){}

    public MathServic(String operation, double firstValue, double secondValue){
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.operation = operation;
        mathOperationsSet.add(new Sum());
        mathOperationsSet.add(new Divide());
        mathOperationsSet.add(new Multiply());
        mathOperationsSet.add(new Subtraction());
    }

    public String doOperation(){
        int result;
        MathOperations mathOperations = null;
        for (MathOperations operations : mathOperationsSet){
            if (Objects.equals(operations.getOperationWord(), operation)){
                mathOperations = operations;
            }
        }
        if (mathOperations != null)
            return mathOperations.getOperation(firstValue, secondValue);
        else return "enter valid URL like: http://localhost:8080/math?operation=mul&firstValue=2&secondValue=2";
    }
}
