package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(final String[] args) {

        MyCollection<String> myCollection = new MyCollection<>();
        myCollection.add("0");
        myCollection.add(null);
        myCollection.add("0");
        myCollection.add("0");
        myCollection.add("0");
        myCollection.add("0");
        myCollection.add("0");

        System.out.println(myCollection);

        ArrayList<String> list = new ArrayList<>();
        list.add("4");
        list.add("2");
        list.add("2");
        list.add("3");
        list.add("8");

        myCollection.addAll(list);

        System.out.println(myCollection);


    }
}

