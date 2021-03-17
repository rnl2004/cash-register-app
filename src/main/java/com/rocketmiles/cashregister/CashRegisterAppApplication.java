package com.rocketmiles.cashregister;

import com.rocketmiles.cashregister.constants.CashRegisterEnum;
import com.rocketmiles.cashregister.constants.DollarBillsEnum;
import com.rocketmiles.cashregister.service.CashRegisterBillsService;
import com.rocketmiles.cashregister.service.CashRegisterBillsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SpringBootConfiguration
public class CashRegisterAppApplication {
    private static final Logger logger = LoggerFactory.getLogger(CashRegisterAppApplication.class);
    private static final String CASH_REGISTER_MSG0 = ">>> Ready...";
    private static final String CASH_REGISTER_MSG1 = ">>> Please enter a cash register command(s) below <<<";
    private static final String CASH_REGISTER_MSG2 = "! show = show bills, put = add bills, take = take out bills, change = get change bills and quit (q)";
    private static final String CASH_REGISTER_MSG3 = ">>> ";
    private static final String CASH_REGISTER_MSG4 = ">>> Cash register is closed. Thank you. <<<";
    private static final String CASH_REGISTER_MSG5 = ">>> Oops! Wrong command. Please try again. <<<";
    private static Map<Integer, Integer> initCashRegister;

    public static void main(String[] args) {
        SpringApplication.run(CashRegisterAppApplication.class, args);
        logger.info(CASH_REGISTER_MSG0);
        CashRegisterBillsService billsService = new CashRegisterBillsServiceImpl();
        Scanner scanner;
        Integer[] billsArgsCount;
        int argsCountLimit;
        initCashRegisterBills();

        while(true) {
            logger.info(CASH_REGISTER_MSG1);
            logger.info(CASH_REGISTER_MSG2);
            logger.info(CASH_REGISTER_MSG3);
            String commands;
            String command;
            scanner = new Scanner(System.in);
            commands = scanner.nextLine();

            String[] strOfCommands = commands.split(" ");
            command = strOfCommands[0];
            argsCountLimit = CashRegisterEnum.CASH_REGISTER_BILLS_SLOTS.getValue() + 1;
            if (strOfCommands.length > argsCountLimit) {
                logger.info(CASH_REGISTER_MSG5);
                scanner.next();
            }
            billsArgsCount = billsService.splitCommandArgs(strOfCommands);
            if (command.equalsIgnoreCase("show")) {
                billsService.show(getInitCashRegister());
            } else if (command.equalsIgnoreCase("put")) {
                setInitCashRegister(billsService.put(getInitCashRegister(), billsArgsCount));
                billsService.show(getInitCashRegister());
            } else if (command.equalsIgnoreCase("take")) {
                setInitCashRegister(billsService.take(getInitCashRegister(), billsArgsCount));
                billsService.show(getInitCashRegister());
            } else if (command.equalsIgnoreCase("change")) {
                setInitCashRegister(billsService.change(getInitCashRegister(), billsArgsCount[0]));
                //billsService.domination(getInitCashRegister(),11);
            } else if (command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("q")) {
                logger.info(CASH_REGISTER_MSG4);
                break;
            } else {
                logger.info(CASH_REGISTER_MSG5);
            }
        }
    }

    /** Initial cash register bills from count zero's */
    private static void initCashRegisterBills() {
        Map<Integer, Integer> initialCashRegisterBills = new HashMap<>();
        initialCashRegisterBills.put(DollarBillsEnum.TWENTY_DOLLAR_BILL.getValue(), 0); //$20 dollar bill of 0 count
        initialCashRegisterBills.put(DollarBillsEnum.TEN_DOLLAR_BILL.getValue(), 0); //$10 dollar bill of 0 count
        initialCashRegisterBills.put(DollarBillsEnum.FIVE_DOLLAR_BILL.getValue(), 0);  //$5 dollar bill of 0 count
        initialCashRegisterBills.put(DollarBillsEnum.TWO_DOLLAR_BILL.getValue(), 0);  //$2 dollar bill of 0 count
        initialCashRegisterBills.put(DollarBillsEnum.ONE_DOLLAR_BILL.getValue(), 0);  //$1 dollar bill of 0 count
        setInitCashRegister(initialCashRegisterBills);
    }

    public static Map<Integer, Integer> getInitCashRegister() {
        return initCashRegister;
    }

    public static void setInitCashRegister(Map<Integer, Integer> initCashRegister) {
        CashRegisterAppApplication.initCashRegister = initCashRegister;
    }
}
