package com.example.strategy.impl;

import com.example.strategy.Operation;

import java.math.BigDecimal;
import java.util.List;

/**
 * 加法操作
 */
public class AddOperation implements Operation {
    @Override
    public void doOperation(List<BigDecimal> numStack, BigDecimal num2) {
        numStack.add(num2);
    }
}