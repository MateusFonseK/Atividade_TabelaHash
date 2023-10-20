import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTableq2 {
    private static final int firstLevelSize = 10;
    private static final int secondLevelSize = 10;
    private List<List<List<Pair<Integer, String>>> > table;

    public HashTableq2() {
        table = new ArrayList<>(firstLevelSize);
        for (int i = 0; i < firstLevelSize; i++) {
            table.add(new ArrayList<>(secondLevelSize));
            for (int j = 0; j < secondLevelSize; j++) {
                table.get(i).add(new LinkedList<>());
            }
        }
    }

    public int firstLevelHash(int key) {
        return key % firstLevelSize;
    }

    public int secondLevelHash(int key) {
        return key % secondLevelSize;
    }

    public void insert(int key, String name) {
        int firstIndex = firstLevelHash(key);
        int secondIndex = secondLevelHash(key);
        table.get(firstIndex).get(secondIndex).add(new Pair<>(key, name));
    }

    public String find(int key) {
        int firstIndex = firstLevelHash(key);
        int secondIndex = secondLevelHash(key);

        for (Pair<Integer, String> item : table.get(firstIndex).get(secondIndex)) {
            if (item.getKey() == key) {
                return item.getValue();
            }
        }

        return null;
    }

    public static void main(String[] args) {
        HashTableq2 hashTable = new HashTableq2();

        // inserindo elementos
        hashTable.insert(1, "João");
        hashTable.insert(2, "Maria");
        hashTable.insert(3, "Pedro");

        // recuperando elementos
        String name1 = hashTable.find(1);
        String name2 = hashTable.find(2);
        String name4 = hashTable.find(4);

        if (name1 != null) {
            System.out.println("chave 1: " + name1);
        } else {
            System.out.println("chave 1 nao encontrada.");
        }

        if (name2 != null) {
            System.out.println("chave 2: " + name2);
        } else {
            System.out.println("chave 2 nao encontrada.");
        }

        if (name4 != null) {
            System.out.println("chave 4: " + name4);
        } else {
            System.out.println("chave 4 nao encontrada.");
        }
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
