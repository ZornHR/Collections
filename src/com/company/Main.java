package com.company;

public class Main {

    public static void main(final String[] args) {
        MyCollection<String> myCollection = new MyCollection<>();
        myCollection.add("1");
        myCollection.add(null);
        myCollection.add("3");
        System.out.println(myCollection);
        System.out.println(myCollection.contains(null));

        System.out.println(myCollection.contains("1"));

        System.out.println(myCollection.contains("3"));

        System.out.println(myCollection.remove(null));
        System.out.println(myCollection);
        System.out.println(myCollection.contains(null));
    }
}

