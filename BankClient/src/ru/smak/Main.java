package ru.smak;

import ru.smak.net.Client;
import ru.smak.ui.AuthWindow;
import ru.smak.ui.RegWindow;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Client client = new Client("localhost",5003);
            var w = new AuthWindow(client);
            w.setVisible(true);
        } catch (IOException e) {
            System.out.println("Ошибка");
        }


    }
}
