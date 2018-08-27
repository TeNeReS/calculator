package main.java.arkhipov.calculator;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class CalculatorExpression {

    private CalculatorOperation operation;

    private CalculatorExpressionResult result;

    public void calculateExpression() {
        setResult(new CalculatorExpressionResult(operation.execute()));
    }

    @XmlElement(name="operation")
    public CalculatorOperation getOperation() {
        return operation;
    }

    public void setOperation(CalculatorOperation operation) {
        this.operation = operation;
    }

    @XmlTransient
    public CalculatorExpressionResult getResult() {
        return result;
    }

    public void setResult(CalculatorExpressionResult result) {
        this.result = result;
    }
}
