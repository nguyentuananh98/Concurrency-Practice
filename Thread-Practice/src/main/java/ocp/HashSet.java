package ocp;

import java.io.Serializable;
import java.util.*;
import java.util.HashMap;

public class HashSet <E> extends AbstractSet<E>
        implements Set<E>, Cloneable, Serializable {
    private transient HashMap<E, Object> map;
    private static final Object PRESENT = new Object();

    public HashSet() {
        map = new HashMap<>();
    }

    public HashSet(int initialCapacity, float loadFactor) {
        map = new LinkedHashMap<>(initialCapacity, loadFactor);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    public boolean add (E e) {
        return map.put(e, PRESENT) == null;
    }
}
