package math_app.entitys;

import math_app.math_service.MathServic;

public class MathEntity {
    private String operation;
    private double firstValue;
    private double secondValue;
    private String rez;

    public MathEntity(String operation, double firstValue, double secondValue){
        MathServic service = new MathServic(operation,firstValue,secondValue);
        this.secondValue = secondValue;
        this.operation = operation;
        this.firstValue = firstValue;
        this.rez = service.doOperation();
    }


    public String getRez() {
        return rez;
    }
    public void setRez(String rez) {
        this.rez = rez;
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
