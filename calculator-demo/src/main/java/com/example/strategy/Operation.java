package com.example.strategy;

import java.math.BigDecimal;
import java.util.List;

/**
 *  操作接口
 */
public interface Operation {
    default void doOperation(List<BigDecimal> numStack, BigDecimal num2) {};
}