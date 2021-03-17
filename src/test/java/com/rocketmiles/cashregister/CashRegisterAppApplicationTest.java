package com.rocketmiles.cashregister;

import com.rocketmiles.cashregister.constants.DollarBillsEnum;
import com.rocketmiles.cashregister.service.CashRegisterBillsService;
import com.rocketmiles.cashregister.service.CashRegisterBillsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class CashRegisterAppApplicationTest {

    private CashRegisterBillsService billsService = new CashRegisterBillsServiceImpl();

    @Test
    void testCashRegisterBillsTransaction() throws RuntimeException {
        Map<Integer, Integer> currentState;
        Integer[] putBills;
        Integer[] putBills2;
        Integer[] takeBills;
        Integer expectedCurrentState;
        Map<Integer, Integer> currentStateResult;

        currentState = new HashMap<>();
        currentState.put(DollarBillsEnum.TWENTY_DOLLAR_BILL.getValue(), 0);
        currentState.put(DollarBillsEnum.TEN_DOLLAR_BILL.getValue(), 0);
        currentState.put(DollarBillsEnum.FIVE_DOLLAR_BILL.getValue(), 0);
        currentState.put(DollarBillsEnum.TWO_DOLLAR_BILL.getValue(), 0);
        currentState.put(DollarBillsEnum.ONE_DOLLAR_BILL.getValue(), 0);

        /** TC Scenario 1 */
        putBills = new Integer[]{1, 2, 3, 4, 5};
        billsService.put(currentState, putBills);
        currentStateResult = billsService.show(currentState);
        expectedCurrentState = currentStateResult.get(DollarBillsEnum.TWENTY_DOLLAR_BILL.getValue());
        Assertions.assertEquals(1, expectedCurrentState);
        expectedCurrentState = currentStateResult.get(DollarBillsEnum.TEN_DOLLAR_BILL.getValue());
        Assertions.assertEquals(2, expectedCurrentState);
        expectedCurrentState = currentStateResult.get(DollarBillsEnum.FIVE_DOLLAR_BILL.getValue());
        Assertions.assertEquals(3, expectedCurrentState);
        expectedCurrentState = currentStateResult.get(DollarBillsEnum.TWO_DOLLAR_BILL.getValue());
        Assertions.assertEquals(4, expectedCurrentState);
        expectedCurrentState = currentStateResult.get(DollarBillsEnum.ONE_DOLLAR_BILL.getValue());
        Assertions.assertEquals(5, expectedCurrentState);

        /** TC Scenario 2 */
        putBills2 = new Integer[]{1, 2, 3, 0, 5};
        billsService.put(currentState, putBills2);
        currentStateResult = billsService.show(currentState);
        expectedCurrentState = currentStateResult.get(DollarBillsEnum.TWENTY_DOLLAR_BILL.getValue());
        Assertions.assertEquals(2, expectedCurrentState);
        expectedCurrentState = currentStateResult.get(DollarBillsEnum.TEN_DOLLAR_BILL.getValue());
        Assertions.assertEquals(4, expectedCurrentState);
        expectedCurrentState = currentStateResult.get(DollarBillsEnum.FIVE_DOLLAR_BILL.getValue());
        Assertions.assertEquals(6, expectedCurrentState);
        expectedCurrentState = currentStateResult.get(DollarBillsEnum.TWO_DOLLAR_BILL.getValue());
        Assertions.assertEquals(4, expectedCurrentState);
        expectedCurrentState = currentStateResult.get(DollarBillsEnum.ONE_DOLLAR_BILL.getValue());
        Assertions.assertEquals(10, expectedCurrentState);

        /** TC Scenario 3 */
        takeBills = new Integer[]{1, 4, 3, 0, 10};
        billsService.take(currentState, takeBills);
        currentStateResult = billsService.show(currentState);
        expectedCurrentState = currentStateResult.get(DollarBillsEnum.TWENTY_DOLLAR_BILL.getValue());
        Assertions.assertEquals(1, expectedCurrentState);
        expectedCurrentState = currentStateResult.get(DollarBillsEnum.TEN_DOLLAR_BILL.getValue());
        Assertions.assertEquals(0, expectedCurrentState);
        expectedCurrentState = currentStateResult.get(DollarBillsEnum.FIVE_DOLLAR_BILL.getValue());
        Assertions.assertEquals(3, expectedCurrentState);
        expectedCurrentState = currentStateResult.get(DollarBillsEnum.TWO_DOLLAR_BILL.getValue());
        Assertions.assertEquals(4, expectedCurrentState);
        expectedCurrentState = currentStateResult.get(DollarBillsEnum.ONE_DOLLAR_BILL.getValue());
        Assertions.assertEquals(0, expectedCurrentState);

        /** TC Scenario 4 */
        billsService.change(currentState, 11);
        //billsService.show(currentState);
    }
}
