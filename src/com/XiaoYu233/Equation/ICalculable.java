package com.XiaoYu233.Equation;

@SuppressWarnings("unused")
public interface ICalculable {
    void add(ICalculable other);
    void subtract(ICalculable other);
    void multiply(ICalculable other);
    void divide(ICalculable other);
}
