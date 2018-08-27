package main.java.arkhipov.calculator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class SimpleCalculator {

    private List<CalculatorExpression> expressions;

    @XmlElementWrapper
    @XmlElement(name="expression")
    public List<CalculatorExpression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<CalculatorExpression> expressions) {
        this.expressions = expressions;
    }

    public void calculate() {
        expressions.forEach(e -> {
            e.setResult(e.getOperation().execute());
        });
    }
}
