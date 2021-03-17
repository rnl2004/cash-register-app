package com.rocketmiles.cashregister.constants;

public enum DollarBillsEnum {
    TWENTY_DOLLAR_BILL(20),
    TEN_DOLLAR_BILL(10),
    FIVE_DOLLAR_BILL(5),
    TWO_DOLLAR_BILL(2),
    ONE_DOLLAR_BILL(1);

    private Integer value;

    private DollarBillsEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
