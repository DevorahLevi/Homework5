package edu.blitstein.calc.engine.op.engine;

import edu.blitstein.calc.engine.op.UnaryOperation;
import edu.blitstein.calc.engine.op.UnaryOperationFactory;
import edu.blitstein.calc.engine.op.UnaryOperationFactory;
import edu.blitstein.calc.exception.DivideByZeroException;
import edu.blitstein.calc.exception.UnknownOpException;

public class Calculator {
    private double result;

    public Calculator() {
        this(0.0);
    }

    public Calculator(double initialValue) {
        result = initialValue;
    }

    public void reset() {
        result = 0;
    }

    public void setResult(double newResult) {
        result = newResult;
    }

    public double getResult() {
        return result;
    }

    /**
     * Returns n1 op n2, provided op is one of '+', '', '*',or '/'.
     * Any other value of op throws UnknownOpException.
     */
    public double evaluate(String opType, double n1)
            throws DivideByZeroException, UnknownOpException {
        double answer;
        UnaryOperation op = UnaryOperationFactory.getOperator(opType);
        answer = op.apply(n1);
        return answer;
    }
}