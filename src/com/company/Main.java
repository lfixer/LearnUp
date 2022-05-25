package com.company;

import java.io.File;
import java.io.IOException;

public class Main {
            public static void main(String[] args) throws IOException, ClassNotFoundException {
                File file = new File("f.txt");
                Client client = new Client("Arina", 22);
                client.connectToFile(new File("f.txt"));
                client.save();
                Client newClient = Client.loadFromFile(file);
                newClient.save();
                System.out.println(newClient);

            }
        }
