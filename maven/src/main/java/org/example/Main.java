package org.example;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;

public class Main {
    public static void main(String[] args) throws  IOException {
        Scanner in = new Scanner(System.in);

        String answer = "1";
        while (answer.equals("1")) {
            System.out.println("\nВведите дату в формате dd/MM/yyyy, например, 21/02/2019: ");
            String data = in.nextLine();
            System.out.println("Введите идентификатор валюты, например, USD: ");
            String currencyValue = in.nextLine();

            try {
                API currency = new API(data, currencyValue);
                currency.getRate();
            } catch (DataNotFoundException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
            System.out.print("\nЕсли хотите выйти, нажмите 0, иначе 1");
            answer = in.nextLine();
        }
    }
}
