package main.java.arkhipov.calculator;

import javax.xml.bind.*;
import javax.xml.bind.Marshaller;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(SimpleCalculator.class);

            List<CalculatorExpression> expressions = new ArrayList<CalculatorExpression>(2);
            CalculatorOperation operation = new CalculatorOperation("UUU");

            operation.setArgOne(2);
            operation.setCalculatorOperationOne(new CalculatorOperation("WWW"));

            List<Integer> arguments = new ArrayList<>(2);
            arguments.add(3);
            arguments.add(7);
            operation.setArgs(arguments);

            List<CalculatorOperation> operations = new ArrayList<>(2);
            CalculatorOperation operationOne = new CalculatorOperation("QQQ");
            CalculatorOperation operationTwo = new CalculatorOperation("EEE");
            operations.add(operationOne);
            operations.add(operationTwo);
            operation.setOperations(operations);

            CalculatorExpression expression = new CalculatorExpression();
            expression.setOperation(operation);

            expressions.add(expression);
            expressions.add(expression);

            SimpleCalculator simpleCalculator = new SimpleCalculator();
            simpleCalculator.setExpressions(expressions);

            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(simpleCalculator, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
