package com.XiaoYu233.Equation;

@SuppressWarnings("WeakerAccess")
public class UnknownNum extends Integer{
    char letterSymbol;
    int index;

    public UnknownNum(char letterSymbol, int index) {
        this.letterSymbol = letterSymbol;
        this.index = index;
    }

    @Override
    public String toString() {
        return this.letterSymbol + (index == 1 ? "" : "^" + index);
    }
}
