import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTableq1 {
    private static final int firstLevelSize = 10;
    private static final int secondLevelSize = 10;
    private List<List<List<String>>> table;

    public HashTableq1() {
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
        table.get(firstIndex).get(secondIndex).add(name);
    }

    public boolean find(int key, String name) {
        int firstIndex = firstLevelHash(key);
        int secondIndex = secondLevelHash(key);
        List<String> list = table.get(firstIndex).get(secondIndex);
        return list.contains(name);
    }

    public void remove(int key, String name) {
        int firstIndex = firstLevelHash(key);
        int secondIndex = secondLevelHash(key);
        List<String> list = table.get(firstIndex).get(secondIndex);

        if (list.remove(name)) {
            System.out.println(name + " removido com sucesso.");
        } else {
            System.out.println(name + " não encontrado na tabela.");
        }
    }

    public static void main(String[] args) {
        HashTableq1 hashTable = new HashTableq1();

        // inserindo elementos
        hashTable.insert(1, "João");
        hashTable.insert(2, "Maria");
        hashTable.insert(3, "Pedro");

        // verificando se um elemento está na tabela
        System.out.println("Encontrou Maria: " + hashTable.find(2, "Maria"));

        // removendo um elemento da tabela
        hashTable.remove(2, "Maria");

        // verificando se um elemento está na tabela
        System.out.println("Encontrou Maria: " + hashTable.find(2, "Maria"));
    }
}

