package math_app.entitys;

import math_app.math_service.*;
import org.jcp.xml.dsig.internal.MacOutputStream;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MathEntity {
    private String operation;
    private double firstValue;
    private double secondValue;
    private Set<MathOperations> mathOperationsSet = new HashSet<MathOperations>();

    public MathEntity(String operation, double firstValue, double secondValue){
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.operation = operation;
        mathOperationsSet.add(new Sum());
        mathOperationsSet.add(new Divide());
        mathOperationsSet.add(new Multiply());
        mathOperationsSet.add(new Subtraction());

    }

    public String doOperation(){
        MathOperations rez = null;
        for (MathOperations operations : mathOperationsSet){
            if (Objects.equals(operations.getOperationWord(), operation)){
                rez = operations;
            }
        }
        if (rez != null)
        return firstValue + " " + rez.getOperationSign() + " " + secondValue + " = " + rez.getOperation(firstValue, secondValue);
        else return "enter valid URL like: http://localhost:8080/math?operation=mul&firstValue=2&secondValue=2";
    }


    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }
    public double getFirstValue() {
        return firstValue;
    }
    public void setFirstValue(double firstValue) {
        this.firstValue = firstValue;
    }
    public double getSecondValue() {
        return secondValue;
    }
    public void setSecondValue(double secondValue) {
        this.secondValue = secondValue;
    }
}
