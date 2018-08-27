package main.java.arkhipov.calculator;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement
public class SimpleCalculator {

    private List<CalculatorExpression> expressions;

    private List<CalculatorExpressionResult> expressionResults;

    public void calculate() {
        // Вычисляем выражения
        expressions.forEach(CalculatorExpression::calculateExpression);

        // Устанавливаем список результатов
        setExpressionResults(expressions.stream().map(CalculatorExpression::getResult).collect(Collectors.toList()));

        // Обнуляем список выражений, чтобы они не попали в выходной xml (пока нет задачи хранить выражения).
        setExpressions(null);
    }

    @XmlElementWrapper
    @XmlElement(name="expression")
    public List<CalculatorExpression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<CalculatorExpression> expressions) {
        this.expressions = expressions;
    }

    @XmlElementWrapper
    @XmlElement(name="expressionResult")
    public List<CalculatorExpressionResult> getExpressionResults() {
        return expressionResults;
    }

    public void setExpressionResults(List<CalculatorExpressionResult> expressionResults) {
        this.expressionResults = expressionResults;
    }
}
