package com.company;

import java.io.*;

public class Client implements Serializable {
    private String name;
    private int age;
    private transient File file;

    public Client(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void connectToFile(File file) {
        this.file = file;
    }

    public void save() {
        try (ObjectOutputStream objectOutputStream= new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(this);
        } catch (IOException e) {
        }
    }

    public static Client loadFromFile(File file) {
        Client client = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            client = (Client) objectInputStream.readObject();
            client.connectToFile(file);
        } catch (IOException | ClassNotFoundException e) {

        }
        return client;
    }

    @Override
    public String toString() {
        return ("Client: " +
                "name: " + this.name +
                ", age: " + this.age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

