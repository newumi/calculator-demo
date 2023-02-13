package com.example.strategy.impl;

import com.example.strategy.Operation;

import java.math.BigDecimal;
import java.util.List;

/**
 * 减法操作
 */
public class SubtractOperation implements Operation {
    @Override
    public void doOperation(List<BigDecimal> numStack, BigDecimal num2) {
        //数据变成负数
        numStack.add(num2.negate());
    }
}