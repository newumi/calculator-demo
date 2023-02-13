package com.example.main;

import com.example.util.CalculatorHelper;

import java.util.Scanner;

/**
 * 计算器启动类
 */
public class CalculatorApplication {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        for (;;) {
            System.out.println("请输入一条数学公式，运算符支持+、-、*、/，输入=计算结果,输入u撤销，输入r重做，例如：1+2+3=。退出程序请输入exit");
            CalculatorHelper helper = new CalculatorHelper();
            for (;; ) {
                String s = sn.nextLine();
                // 停止程序
                if (s.equalsIgnoreCase("exit")) {
                    System.exit(0);
                }
                if (s.equals("u")) {
                    helper.undo();
                    System.out.printf("当前公式内容为：%s。输入=计算结果,输入u撤销，输入r重做。\n", helper);
                    continue;
                }
                if (s.equals("r")) {
                    helper.redo();
                    System.out.printf("请输入一条数学公式，运算符支持+、-、*、/，输入=计算结果,输入u撤销，输入r重做，例如：1+2+3=。退出程序请输入exit\n");
                    continue;
                }
                if (s.indexOf("=") == -1) {
                    helper.addContent(s.trim());
                    System.out.printf("当前公式内容是：%s。输入=计算结果,输入u撤销，输入r重做。\n", helper);
                } else {
                    helper.addContent(s.substring(0, s.indexOf("=")).trim());
                    break;
                }
            }

            try {
                System.out.printf("计算结果是:%s。【当前计算已完成，已为您开启新一轮计算～】\n\n", helper.clac().toString());
            }catch (Exception exception){
                System.out.printf("当前公式无法进行结果计算，请输入合法计算公式！");
            }

        }

    }
}
