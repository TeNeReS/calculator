package main.java.arkhipov.calculator;


import javax.xml.bind.annotation.XmlElement;

public class CalculatorExpression {

    private CalculatorOperation operation;

    @XmlElement(name="operation")
    public CalculatorOperation getOperation() {
        return operation;
    }

    public void setOperation(CalculatorOperation operation) {
        this.operation = operation;
    }
}
