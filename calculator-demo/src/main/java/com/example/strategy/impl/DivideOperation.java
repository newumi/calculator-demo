package com.example.strategy.impl;

import com.example.strategy.Operation;

import java.math.BigDecimal;
import java.util.List;

/**
 * 除法操作
 */
public class DivideOperation implements Operation {
    @Override
    public void doOperation(List<BigDecimal> numStack, BigDecimal num2) {
        if (numStack.isEmpty()) {
            throw new RuntimeException("输入公式错误");
        }
        numStack.add(numStack.remove(numStack.size() - 1).divide(num2, 9, BigDecimal.ROUND_HALF_UP));
    }
}