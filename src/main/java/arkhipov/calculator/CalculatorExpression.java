package main.java.arkhipov.calculator;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class CalculatorExpression {

    private CalculatorOperation operation;

    private double result;

    @XmlElement(name="operation")
    public CalculatorOperation getOperation() {
        return operation;
    }

    public void setOperation(CalculatorOperation operation) {
        this.operation = operation;
    }

    @XmlTransient
    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
