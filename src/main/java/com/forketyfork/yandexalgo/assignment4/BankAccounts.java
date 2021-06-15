package com.forketyfork.yandexalgo.assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://contest.yandex.ru/contest/27665/problems/G/">G. Банковские счета</a>
 */
public class BankAccounts {

    private static final Map<String, Long> ACCOUNTS = new HashMap<>();

    public static void main(String[] args) throws IOException {

        var tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        try (var writer = new PrintWriter(System.out)) {

            while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {

                String name1, name2;
                int value;

                String operation = tokenizer.sval;
                switch (operation) {
                    case "DEPOSIT":
                        tokenizer.nextToken();
                        name1 = tokenizer.sval;
                        tokenizer.nextToken();
                        value = (int) tokenizer.nval;
                        deposit(name1, value);
                        break;
                    case "WITHDRAW":
                        tokenizer.nextToken();
                        name1 = tokenizer.sval;
                        tokenizer.nextToken();
                        value = (int) tokenizer.nval;
                        withdraw(name1, value);
                        break;
                    case "BALANCE":
                        tokenizer.nextToken();
                        name1 = tokenizer.sval;
                        balance(writer, name1);
                        break;
                    case "TRANSFER":
                        tokenizer.nextToken();
                        name1 = tokenizer.sval;
                        tokenizer.nextToken();
                        name2 = tokenizer.sval;
                        tokenizer.nextToken();
                        value = (int) tokenizer.nval;
                        transfer(name1, name2, value);
                        break;
                    case "INCOME":
                        tokenizer.nextToken();
                        value = (int) tokenizer.nval;
                        income(value);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }
    }

    private static void deposit(String name, int value) {
        ACCOUNTS.compute(name, (key, balance) -> balance == null ? value : balance + value);
    }

    private static void withdraw(String name, int value) {
        ACCOUNTS.compute(name, (key, balance) -> balance == null ? -value : balance - value);
    }

    private static void balance(PrintWriter writer, String name) {
        Long balance = ACCOUNTS.get(name);
        if (balance != null) {
            writer.println(balance);
        }
        else {
            writer.println("ERROR");
        }
    }

    private static void transfer(String name1, String name2, int value) {
        withdraw(name1, value);
        deposit(name2, value);
    }

    private static void income(int value) {
        ACCOUNTS.forEach((name, balance) -> {
            if (balance > 0) {
                ACCOUNTS.put(name, balance + (long) Math.floor(balance * (value / 100.0)));
            }
        });
    }
}
