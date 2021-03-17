package com.rocketmiles.cashregister.service;

import org.springframework.context.annotation.Configuration;

import java.util.Map;

public interface CashRegisterBillsService {

    /** This method is used to show the current state of cash register bills */
    Map<Integer, Integer> show(Map<Integer, Integer> currentBillsState);

    /** This method is used to put bills in the cash register */
    Map<Integer, Integer> put(Map<Integer, Integer> currentBillsState, Integer[] newBills);

    /** This method is used to take out bills from the cash register */
    Map<Integer, Integer> take(Map<Integer, Integer> currentBillsState, Integer[] takeBills);

    /** This method is used to get the change from the cash register */
    Map<Integer, Integer> change(Map<Integer, Integer> currentBillsState, Integer amountToChange);

    /** This method is used to compute dinomination based on user inputted amount */
    Map<Integer, Integer> dinomination(Map<Integer, Integer> currentBillsState, Integer amountToChange);

    /** This method is used to extract args values form user input */
    Integer[] splitCommandArgs(String[] strArgs);
}
