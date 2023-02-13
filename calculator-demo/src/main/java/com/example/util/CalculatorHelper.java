package com.example.util;

import com.example.factory.OperationFactory;
import com.example.strategy.Operation;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class CalculatorHelper {
    StringBuilder expressionBuilder = new StringBuilder();
    List<Character> undoLog = new LinkedList<>();
    public void addContent(String content) {
        expressionBuilder.append(content);
    }

    public String toString() {
        return expressionBuilder.toString();
    }
    /**
     * 撤销输入，删除最后一个输入字符
     */
    public String undo() {
        if (!expressionBuilder.isEmpty()) {
            int lastChar = expressionBuilder.length() - 1;
            Character character = expressionBuilder.charAt(lastChar);
            expressionBuilder.setLength(lastChar);
            undoLog.add(character);
        }
        return expressionBuilder.toString();
    }

    public String redo() {
        if (!undoLog.isEmpty()) {
            expressionBuilder.replace(0, expressionBuilder.length(), "");
        }
        return expressionBuilder.toString();
    }

    /**
     * 计算结果
     */
    public BigDecimal clac() {
        List<BigDecimal> numStack = new LinkedList<>();
        StringBuilder numBuilder = new StringBuilder();
        // 遍历过程中最近一个操作符
        Operation operation = null;
        for (int i = 0; i < expressionBuilder.length(); i++) {
            char c = expressionBuilder.charAt(i);
            //数据或'.'添加numBuilder用于构建数字
            if ('0' <= c && c <= '9') {
                numBuilder.append(c);
                continue;
            } else if ('.' == c) {
                numBuilder.append(c);
                continue;
            } else {
                if (numBuilder.length() > 0) {
                    BigDecimal num = new BigDecimal(numBuilder.toString());
                    // 清空
                    numBuilder.setLength(0);
                    if (operation == null) {
                        numStack.add(num);
                    } else {
                        operation.doOperation(numStack, num);
                    }

                }
            }
            if (c == ' ' || c=='\n' || c=='\r') {
                continue;
            }
            operation = OperationFactory.getOperation(c);
        }
        // 最后一个数字处理
        operation.doOperation(numStack, new BigDecimal(numBuilder.toString()));
        // 计算numStack总和
        BigDecimal result = BigDecimal.ZERO;
        for (BigDecimal decimal : numStack) {
            result = result.add(decimal);
        }
        return result;
    }
}
