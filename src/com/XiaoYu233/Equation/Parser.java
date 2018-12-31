package com.XiaoYu233.Equation;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings({"WeakerAccess","ResultOfMethodCallIgnored"})
public class Parser {
    static Monomial parseMonomial(String src) {
        Matcher letterMatcher = Pattern.compile("[a-z]").matcher(src);
        //尚未支持小数指数,所以先这样写
        Matcher indexMatcher = Pattern.compile("(|-)\\d+").matcher(src);
        ArrayList<UnknownNum> unknownNumbs = new ArrayList<>();
        while (letterMatcher.find()) {
            char symbol;
            symbol = src.substring(letterMatcher.start(), letterMatcher.end()).charAt(0);
            int index = 1;
            try {
                if (src.charAt(letterMatcher.start() + 1) == '^') {
                    indexMatcher.find(letterMatcher.end());
                    index = Integer.parseInt(src.substring(indexMatcher.start(), indexMatcher.end()));
                }
            } catch (StringIndexOutOfBoundsException ignored) {
            }
            UnknownNum unknownNum = new UnknownNum(symbol, index);
            unknownNumbs.add(unknownNum);
        }
        letterMatcher.reset().find();
        Fraction coefficient;
        String coefficientText = src.substring(0, letterMatcher.start());
        UnknownNum[] finalUnknownNum = new UnknownNum[unknownNumbs.size()];
        unknownNumbs.toArray(finalUnknownNum);
        if (!coefficientText.equalsIgnoreCase("")) {
            if (coefficientText.contains("/")) {
                coefficient = Fraction.fromString(coefficientText);
            } else {
                if(coefficientText.length()==1) coefficient = Fraction.fromInt(Integer.parseInt(coefficientText+"1"));
                else coefficient = Fraction.fromInt(Integer.parseInt(coefficientText));
            }
            return new Monomial(coefficient, finalUnknownNum);

        } else {
            return new Monomial(Fraction.fromInt(1), finalUnknownNum);
        }
    }
    static Polynomial parsePolynomial(String src) {
        ArrayList<Integer> indexList = new ArrayList<>();
        ArrayList<Monomial> monomialArrayList = new ArrayList<>();
        Matcher symbolMatcher = Pattern.compile("[+\\-]").matcher(src);
        while (symbolMatcher.find()) {
            indexList.add(symbolMatcher.start());
        }
        for(int i =1;i<indexList.size();i++){
            monomialArrayList.add(parseMonomial(src.substring(indexList.get(i-1),indexList.get(i)).replace("+","")));
        }
        monomialArrayList.add(parseMonomial(src.substring(indexList.get(indexList.size()-1)).replace("+","")));
        return new Polynomial(monomialArrayList);
    }
}
