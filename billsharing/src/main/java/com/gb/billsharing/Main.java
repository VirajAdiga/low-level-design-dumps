package com.gb.billsharing;

import com.gb.billsharing.model.*;
import com.gb.billsharing.service.ExpenseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseService expenseService = new ExpenseService();

        expenseService.addUser(new User("u1", "User1", "gaurav@workat.tech", "9876543210"));
        expenseService.addUser(new User("u2", "User2", "sagar@workat.tech", "9876543210"));
        expenseService.addUser(new User("u3", "User3", "hi@workat.tech", "9876543210"));
        expenseService.addUser(new User("u4", "User4", "mock-interviews@workat.tech", "9876543210"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            String commandType = commands[0];

            switch (commandType) {
                case "SHOW":
                    if (commands.length == 1) {
                        expenseService.showBalances();
                    } else {
                        expenseService.showBalance(commands[1]);
                    }
                    break;
                case "EXPENSE":
                    String paidBy = commands[1];
                    double amount = Double.parseDouble(commands[2]);
                    int noOfUsers = Integer.parseInt(commands[3]);
                    String expenseType = commands[4 + noOfUsers];
                    List<Split> splits = new ArrayList<>();
                    switch (expenseType) {
                        case "EQUAL":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new EqualSplit(expenseService.userMap.get(commands[4 + i])));
                            }
                            expenseService.addExpense(ExpenseType.EQUAL, amount, paidBy, splits, null);
                            break;
                        case "EXACT":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new ExactSplit(expenseService.userMap.get(commands[4 + i]), Double.parseDouble(commands[5 + noOfUsers + i])));
                            }
                            expenseService.addExpense(ExpenseType.EXACT, amount, paidBy, splits, null);
                            break;
                        case "PERCENT":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new PercentSplit(expenseService.userMap.get(commands[4 + i]), Double.parseDouble(commands[5 + noOfUsers + i])));
                            }
                            expenseService.addExpense(ExpenseType.PERCENT, amount, paidBy, splits, null);
                            break;
                    }
                    break;
            }
        }
    }
}
