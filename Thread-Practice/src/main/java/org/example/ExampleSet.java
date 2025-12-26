package org.example;


import java.util.HashSet;
import java.util.Set;

public class ExampleSet {

    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();

        Person p1 = new Person("John", 20);
        Person p2 = new Person("John", 20);
        Person p3 = new Person("Jane", 40);
        System.out.println("p1: " + p1.hashCode());
        System.out.println("p2: " + p2.hashCode());
        System.out.println("p3: " + p3.hashCode());


        set.add(p1);
        set.add(p2);
        set.add(p3);

        System.out.println(set.size());
    }
}
