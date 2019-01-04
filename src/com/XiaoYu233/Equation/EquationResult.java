package com.XiaoYu233.Equation;

import java.util.HashMap;

@SuppressWarnings({"unused"})
public class EquationResult<R extends Formula> {
    private StringBuffer calculation;
    private HashMap<CharSequence, R> solutionMap;

    EquationResult(HashMap<CharSequence, R> solutionMap) {
        this.solutionMap = solutionMap;
    }

    EquationResult() {
    }

    public HashMap<CharSequence, R> getSolutionMap() {
        return solutionMap;
    }

    public void setSolutionMap(HashMap<CharSequence, R> solutionMap) {
        this.solutionMap = solutionMap;
    }

    public StringBuffer getCalculation() {
        return calculation;
    }

    public void setCalculation(StringBuffer calculation) {
        this.calculation = calculation;
    }
}
