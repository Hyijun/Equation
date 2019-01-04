package com.XiaoYu233.Equation;

@SuppressWarnings("unused")
public class CalculateResult<E extends Formula> {
    private StringBuffer calculation;
    private E result;

    public CalculateResult(StringBuffer calculation, E result) {
        this.calculation = calculation;
        this.result = result;
    }

    public E getResult() {
        return result;
    }

    public void setResult(E result) {
        this.result = result;
    }

    public StringBuffer getCalculation() {
        return calculation;
    }

    public void setCalculation(StringBuffer calculation) {
        this.calculation = calculation;
    }
}
