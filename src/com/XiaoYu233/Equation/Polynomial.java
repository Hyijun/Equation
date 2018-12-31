package com.XiaoYu233.Equation;

import java.util.ArrayList;

@SuppressWarnings({"unused", "WeakerAccess", "StringConcatenationInsideStringBufferAppend"})
public class Polynomial {
    private ArrayList<Monomial> monomialsList = new ArrayList<>();

    public Polynomial() {
    }
    public Polynomial(ArrayList<Monomial> monomialsList){
        this.monomialsList = monomialsList;
    }

    public void addMonomial(Monomial singleMonomial) {
        this.monomialsList.add(singleMonomial);
    }
    public Monomial getMonomial(int index){
        return this.monomialsList.get(index);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Monomial monomial : monomialsList){
            if (!monomial.coefficient.isMinus()) result.append("+"+monomial.toString());
            else result.append(monomial.toString());
        }
        return result.toString();
    }
}
