package main.java.arkhipov.calculator;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class CalculatorOperation {
    private String operationType;

    private List<CalculatorOperation> operations;

    private List<Integer> args;

    private CalculatorOperation calculatorOperationOne;

    private CalculatorOperation calculatorOperationTwo;

    private Integer argOne;

    private Integer argTwo;

    public CalculatorOperation(String operationType) {
        this.operationType = operationType;
    }

    @XmlAttribute(name="OperationType")
    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    @XmlElement(name="operation")
    public List<CalculatorOperation> getOperations() {
        return operations;
    }

    public void setOperations(List<CalculatorOperation> operations) {
        this.operations = operations;
    }

    @XmlElement(name="arg")
    public List<Integer> getArgs() {
        return args;
    }

    public void setArgs(List<Integer> args) {
        this.args = args;
    }

    @XmlElement(name="operation1")
    public CalculatorOperation getCalculatorOperationOne() {
        return calculatorOperationOne;
    }

    public void setCalculatorOperationOne(CalculatorOperation calculatorOperationOne) {
        this.calculatorOperationOne = calculatorOperationOne;
    }

    @XmlElement(name="operation2")
    public CalculatorOperation getCalculatorOperationTwo() {
        return calculatorOperationTwo;
    }

    public void setCalculatorOperationTwo(CalculatorOperation calculatorOperationTwo) {
        this.calculatorOperationTwo = calculatorOperationTwo;
    }

    @XmlElement(name="arg1")
    public Integer getArgOne() {
        return argOne;
    }

    public void setArgOne(Integer argOne) {
        this.argOne = argOne;
    }

    @XmlElement(name="arg2")
    public Integer getArgTwo() {
        return argTwo;
    }

    public void setArgTwo(Integer argTwo) {
        this.argTwo = argTwo;
    }
}
