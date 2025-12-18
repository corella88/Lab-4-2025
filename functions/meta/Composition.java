package functions.meta;

import functions.Function;

public class Composition implements Function {
    private Function outerFunction;  // Это ln
    private Function innerFunction;  // Это exp
    
    public Composition(Function outerFunction, Function innerFunction) {
        this.outerFunction = outerFunction;
        this.innerFunction = innerFunction;
    }
    
    @Override
    public double getLeftDomainBorder() {
        return innerFunction.getLeftDomainBorder(); // Берем границы от внутренней функции
    }
    
    @Override
    public double getRightDomainBorder() {
        return innerFunction.getRightDomainBorder(); // Берем границы от внутренней функции
    }
    
    @Override
    public double getFunctionValue(double x) {
        // ПРАВИЛЬНО: outerFunction(innerFunction(x))
        // Для ln(exp(x)): outerFunction = ln, innerFunction = exp
        double innerValue = innerFunction.getFunctionValue(x);
        return outerFunction.getFunctionValue(innerValue);
    }
}