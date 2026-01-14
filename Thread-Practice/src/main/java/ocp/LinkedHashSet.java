package ocp;


import java.util.Set;

public class LinkedHashSet <E>
        extends HashSet<E>
        implements Set<E> {
    public LinkedHashSet() {
        super();
    }

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("B");
        set.add("A");
        set.add("C");

        System.out.println(set);
    }
}


