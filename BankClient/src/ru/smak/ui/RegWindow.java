package ru.smak.ui;

import ru.smak.data.User;
import ru.smak.net.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Date;

public class RegWindow extends JFrame {
    private static int MIN_SZ = GroupLayout.PREFERRED_SIZE;
    private static int MAX_SZ = GroupLayout.DEFAULT_SIZE;

    private Client client;


    public RegWindow(JFrame parent, Client client){
        this.client = client;
        setSize(600,450);


    }
}
