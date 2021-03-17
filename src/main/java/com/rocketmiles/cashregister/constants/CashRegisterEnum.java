package com.rocketmiles.cashregister.constants;

public enum CashRegisterEnum {
    CASH_REGISTER_BILLS_SLOTS(5);

    private Integer value;

    private CashRegisterEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
