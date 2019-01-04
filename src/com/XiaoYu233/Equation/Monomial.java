package com.XiaoYu233.Equation;

@SuppressWarnings("WeakerAccess")
public class Monomial extends Integer{
    Fraction coefficient;
    UnknownNum[] unknownNumbs;

    public Monomial(Fraction coefficient, UnknownNum... unknownNumbs) {
        this.coefficient = coefficient;
        this.unknownNumbs = unknownNumbs;
    }


    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        if ((coefficient.value()==1|(coefficient.value()==-1))){
            result.append(coefficient.value()==-1?"-":"");
        }else {
            result.append(coefficient.toString());
        }
        for (UnknownNum unknownNum : unknownNumbs) {
            result.append(unknownNum.toString());
        }
        if (coefficient.value() == 0) result = new StringBuffer("0");
        return result.toString();
    }
}
