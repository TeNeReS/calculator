package main.java.arkhipov.calculator;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

public class CalculatorOperation {
    private OperationType operationType;

    private ArgsType argsType;

    private List<CalculatorOperation> operations;

    private List<Integer> args;

    private CalculatorOperation operationOne;

    private CalculatorOperation operationTwo;

    private Integer argOne;

    private Integer argTwo;

    public CalculatorOperation() {}

    public enum OperationType {
        SUB,
        SUM,
        MUL,
        DIV
    }

    public enum ArgsType {
        TWO_ARGS,
        TWO_OPERATIONS,
        ARG_AND_OPERATION,
        OPERATION_AND_ARG
    }

    // Выполняет операцию
    public double execute() {
        defineArgsType();
        switch (operationType) {
            case SUB: return subtract();
            case SUM: return sum();
            case MUL: return multiply();
            case DIV: return divide();
        }
        return 0;
    }

    // Определяет тип аргументов операции
    private void defineArgsType() {
        if (args != null) {
            argsType = ArgsType.TWO_ARGS;
        } else if (operations != null) {
            argsType = ArgsType.TWO_OPERATIONS;
        } else if (argOne != null && operationOne != null) {
            argsType = ArgsType.ARG_AND_OPERATION;
        } else if (operationTwo != null && argTwo != null) {
            argsType = ArgsType.OPERATION_AND_ARG;
        }
    }

    private double subtract() {
        switch (argsType) {
            case TWO_ARGS: return args.get(0) - args.get(1);
            case TWO_OPERATIONS: return operations.get(0).execute() - operations.get(1).execute();
            case ARG_AND_OPERATION: return argOne - operationOne.execute();
            case OPERATION_AND_ARG: return operationTwo.execute() - argTwo;
        }
        return 0;
    }

    private double sum() {
        switch (argsType) {
            case TWO_ARGS: return args.get(0) + args.get(1);
            case TWO_OPERATIONS: return operations.get(0).execute() + operations.get(1).execute();
            case ARG_AND_OPERATION: return argOne + operationOne.execute();
            case OPERATION_AND_ARG: return operationTwo.execute() + argTwo;
        }
        return 0;
    }

    private double multiply() {
        switch (argsType) {
            case TWO_ARGS: return args.get(0) * args.get(1);
            case TWO_OPERATIONS: return operations.get(0).execute() * operations.get(1).execute();
            case ARG_AND_OPERATION: return argOne * operationOne.execute();
            case OPERATION_AND_ARG: return operationTwo.execute() * argTwo;
        }
        return 0;
    }

    private double divide() {
        switch (argsType) {
            case TWO_ARGS: return (double) args.get(0) / args.get(1);
            case TWO_OPERATIONS: return operations.get(0).execute() / operations.get(1).execute();
            case ARG_AND_OPERATION: return argOne / operationOne.execute();
            case OPERATION_AND_ARG: return operationTwo.execute() /- argTwo;
        }
        return 0;
    }

    @XmlAttribute(name="OperationType")
    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
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
    public CalculatorOperation getOperationOne() {
        return operationOne;
    }

    public void setOperationOne(CalculatorOperation operationOne) {
        this.operationOne = operationOne;
    }

    @XmlElement(name="operation2")
    public CalculatorOperation getOperationTwo() {
        return operationTwo;
    }

    public void setOperationTwo(CalculatorOperation operationTwo) {
        this.operationTwo = operationTwo;
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

    @XmlTransient
    public ArgsType getArgsType() {
        return argsType;
    }

    public void setArgsType(ArgsType argsType) {
        this.argsType = argsType;
    }
}
