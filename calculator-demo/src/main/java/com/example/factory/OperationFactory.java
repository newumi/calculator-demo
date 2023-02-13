package com.example.factory;

import com.example.strategy.Operation;
import com.example.strategy.impl.AddOperation;
import com.example.strategy.impl.DivideOperation;
import com.example.strategy.impl.MultiplyOperation;
import com.example.strategy.impl.SubtractOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * 操作工厂，根据操作类型，提供对应操作对象
 */
public class OperationFactory {
    private static final Map<Character, Operation> operationMap = new HashMap<>();

    static {
        operationMap.put('+', new AddOperation());
        operationMap.put('-', new SubtractOperation());
        operationMap.put('*', new MultiplyOperation());
        operationMap.put('/', new DivideOperation());
    }

    public static Operation getOperation(Character type) {
        Operation operation = operationMap.get(type);
        if (operation == null) {
            System.out.println(type);
            throw new RuntimeException("运算符号错误或不支持");
        }
        return operation;
    }

}