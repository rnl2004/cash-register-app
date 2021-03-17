package com.rocketmiles.cashregister.service;

import com.rocketmiles.cashregister.constants.CashRegisterEnum;
import com.rocketmiles.cashregister.constants.DollarBillsEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class CashRegisterBillsServiceImpl implements CashRegisterBillsService {
    private static final Logger logger = LoggerFactory.getLogger(CashRegisterBillsServiceImpl.class);
    private static final String CASH_REGISTER_SHOW_MSG1 = ">>> Showing bills in cash register <<<";

    @Override
    public Map<Integer, Integer> show(Map<Integer, Integer> currentBillsState) {
        logger.info(CASH_REGISTER_SHOW_MSG1);
        Integer total = 0;
        String linearDisplay = "";
        List<Map.Entry<Integer, Integer>> reverseMapKeys = currentBillsState.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toList());
        for (Map.Entry<Integer, Integer> entry : reverseMapKeys) {
            linearDisplay += " " + entry.getValue();
            total += entry.getKey() * entry.getValue();
        }
        logger.info("Current State: ${}{}", total, linearDisplay);
        return currentBillsState;
    }

    @Override
    public Map<Integer, Integer> put(Map<Integer, Integer> currentBillsState, Integer[] newBills) {
        String userInputBills = "";
        for (Integer bill : newBills) {
            userInputBills += " " + bill;
        }
        logger.info("put " + userInputBills);
        currentBillsState.put(DollarBillsEnum.TWENTY_DOLLAR_BILL.getValue(), currentBillsState.get(DollarBillsEnum.TWENTY_DOLLAR_BILL.getValue()) + newBills[0]);
        currentBillsState.put(DollarBillsEnum.TEN_DOLLAR_BILL.getValue(), currentBillsState.get(DollarBillsEnum.TEN_DOLLAR_BILL.getValue()) + newBills[1]);
        currentBillsState.put(DollarBillsEnum.FIVE_DOLLAR_BILL.getValue(), currentBillsState.get(DollarBillsEnum.FIVE_DOLLAR_BILL.getValue()) + newBills[2]);
        currentBillsState.put(DollarBillsEnum.TWO_DOLLAR_BILL.getValue(), currentBillsState.get(DollarBillsEnum.TWO_DOLLAR_BILL.getValue()) + newBills[3]);
        currentBillsState.put(DollarBillsEnum.ONE_DOLLAR_BILL.getValue(), currentBillsState.get(DollarBillsEnum.ONE_DOLLAR_BILL.getValue()) + newBills[4]);
        return currentBillsState;
    }

    @Override
    public Map<Integer, Integer> take(Map<Integer, Integer> currentBillsState, Integer[] takeBills) {
        String userTakeBills = "";
        for (Integer bill : takeBills) {
            userTakeBills += " " + bill;
        }
        logger.info("take " + userTakeBills);
        currentBillsState.put(DollarBillsEnum.TWENTY_DOLLAR_BILL.getValue(), currentBillsState.get(DollarBillsEnum.TWENTY_DOLLAR_BILL.getValue()) - takeBills[0]);
        currentBillsState.put(DollarBillsEnum.TEN_DOLLAR_BILL.getValue(), currentBillsState.get(DollarBillsEnum.TEN_DOLLAR_BILL.getValue()) - takeBills[1]);
        currentBillsState.put(DollarBillsEnum.FIVE_DOLLAR_BILL.getValue(), currentBillsState.get(DollarBillsEnum.FIVE_DOLLAR_BILL.getValue()) - takeBills[2]);
        currentBillsState.put(DollarBillsEnum.TWO_DOLLAR_BILL.getValue(), currentBillsState.get(DollarBillsEnum.TWO_DOLLAR_BILL.getValue()) - takeBills[3]);
        currentBillsState.put(DollarBillsEnum.ONE_DOLLAR_BILL.getValue(), currentBillsState.get(DollarBillsEnum.ONE_DOLLAR_BILL.getValue()) - takeBills[4]);
        return currentBillsState;
    }

    @Override
    public Map<Integer, Integer> change(Map<Integer, Integer> currentBillsState, Integer amountToChange) {
        logger.info("change " + amountToChange);
        dinomination(currentBillsState, amountToChange);
        return null;
    }

    @Override
    public Map<Integer, Integer> dinomination(Map<Integer, Integer> currentBillsState, Integer amountToChange) {
        int c = amountToChange, count;
        Map<Integer, Integer> reverseMapKeys = currentBillsState.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
        for (Map.Entry<Integer, Integer> entry : reverseMapKeys.entrySet()) {
            count = amountToChange / entry.getKey();
            if (count != 0) {
                logger.info("${} => count = {}", entry.getKey(), count);
            } else {
                logger.info("${} => count = {}", entry.getKey(), count);
            }
            amountToChange = amountToChange % entry.getKey();
        }
        return null;
    }

    @Override
    public Integer[] splitCommandArgs(String[] strArgs) {
        Integer[] finalSplitResult = new Integer[CashRegisterEnum.CASH_REGISTER_BILLS_SLOTS.getValue()];
        int argsCount;
        int billsArgsCount = 0;
        String[] result = strArgs != null ? Arrays.copyOfRange(strArgs, 1, strArgs.length) : null;
        if (result != null && result.length < CashRegisterEnum.CASH_REGISTER_BILLS_SLOTS.getValue()) {
            argsCount = CashRegisterEnum.CASH_REGISTER_BILLS_SLOTS.getValue() - result.length;
            billsArgsCount += result.length + argsCount;
        }
        if (result != null) {
            for (int i = 0; i < result.length; i++) {
                finalSplitResult[i] = Integer.valueOf(result[i]);
            }
            for (int i = result.length; i < billsArgsCount; i++) {
                finalSplitResult[i] = 0;
            }
        }
        return finalSplitResult;
    }
}
