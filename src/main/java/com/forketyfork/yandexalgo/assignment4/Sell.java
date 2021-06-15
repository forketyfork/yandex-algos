package com.forketyfork.yandexalgo.assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

/**
 * @see <a href="https://contest.yandex.ru/contest/27665/problems/F/">F. Продажи</a>
 */
public class Sell {

    public static void main(String[] args) throws IOException {

        Map<String, Long> map = new TreeMap<>();

        try (var reader = new BufferedReader(new InputStreamReader(System.in));
             var writer = new PrintWriter(System.out)) {

            String line;
            while ((line = reader.readLine()) != null) {

                int secondSpace = line.lastIndexOf(' ');

                String nameAndGoods = line.substring(0, secondSpace);
                int amount = Integer.parseInt(line.substring(secondSpace + 1));

                map.compute(nameAndGoods, (key, total) -> total == null ? amount : total + amount);

            }

            String currentName = null;
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                String nameAndGoods = entry.getKey();
                Long totals = entry.getValue();
                int space = nameAndGoods.indexOf(' ');
                String name = nameAndGoods.substring(0, space);
                String goods = nameAndGoods.substring(space + 1);

                if (!name.equals(currentName)) {
                    writer.print(name);
                    writer.println(':');
                    currentName = name;
                }

                writer.print(goods);
                writer.print(' ');
                writer.println(totals);
            }
        }

    }
}
