package ocp;

import java.util.*;

public class HashMap {
    public static void main(String[] args) {
        MiniHashMap<Student, String> map = new MiniHashMap<>(8);

        map.put(new Student(1, "Tuan Anh", 27), "A");
        map.put(new Student(2, "Quang", 27), "B");
        map.put(new Student(2, "Quang", 27), "C");



        for (Map.Entry<Student, String> entry : map.entrySet()) {
            Student key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }

    }
}

class Entry<K,V> implements Map.Entry<K, V>{
    K key;
    V value;
    Entry<K, V> next;

    Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V old = this.value;
        this.value = value;
        return old;
    }
}

class MiniHashMap<K, V> {
    private Entry<K, V> [] table;
    private int capacity;

    @SuppressWarnings("unchecked")
    MiniHashMap(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MiniHashMap<?, ?> that = (MiniHashMap<?, ?>) o;
        return capacity == that.capacity && Objects.deepEquals(table, that.table);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(table), capacity);
    }


    private  int hash(K key) {
        int h = key.hashCode();
        return h ^ (h >>> 16);
    }

    private int index(int hash) {
        return hash & (capacity - 1);
    }

    void put(K key, V value) {
        int hash = hash(key);
        int index = index(hash);

        System.out.println("PUT key=" + key +
                ", hash=" + hash +
                ", index=" + index);

        Entry<K, V> head = table[index];

        // If bucket chưa có thì tạo bucket mới
        if (head == null) {
            table[index] = new Entry<>(key, value);
            return;
        }

        //Collision -> linked list (Xử lý va chạm hash)
        Entry<K, V> curr = head;
        while (true) {
            // trùng key thì ghi đè
            if (curr.key.equals(key)) {
                curr.value = value;
                return;
            }

            // node tiếp null dừng
            if (curr.next == null) break;
            curr = curr.next;
        }
        curr.next = new Entry<>(key, value);

    }

    // get
    V get (K key) {
        int hash = hash(key);
        int index = index(hash);

        Entry<K, V> curr = table[index];

        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr.value;
            }
            // Dịch con trỏ sang node tiếp theo.
            curr = curr.next;
        }
        return null;
    }

    Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();

        for (int i = 0; i < table.length; i++) {
            Entry<K, V> curr = table[i];

            while (curr != null) {
                set.add(curr);
                curr = curr.next;
            }
        }
        return set;
    }
}


class Student {
    private Integer id;
    private String name;
    private Integer age;

    public Student(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

}
