package com.XiaoYu233.Equation;
import java.util.*;
class Main{
    private static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println(Parser.parsePolynomial(inputEquation()).toString());
    }
    private static String inputEquation(){
        System.out.println("请输入整式或方程");
        return scn.nextLine();
    }

}
