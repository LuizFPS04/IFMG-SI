import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Hash {

    public void HashMapMethod() {
        // Criar HashMap
        HashMap<Integer, String> myMap = new HashMap<>();

        // Setar valores
        myMap.put(1, "Galo");
        myMap.put(2, "Galo Doido");
        myMap.put(3, "Galão da Massa");

        // Obter valor da chave
        String keyOne = myMap.get(1);
        System.out.println("Chave 1: " + keyOne);

        // Remover chave
        myMap.remove(3);

        // Verificar se existe chave no HashMap
        if (myMap.containsKey(1)) {
            System.out.println("Chave 1 encontrada");
        }

        // Percorrer e exibir elementos da HashMap
        for (Integer key : myMap.keySet()) {
            System.out.println("Chave: " + key + ", Valor: " + myMap.get(key));
        }
    }

    public void HashTableMethod() {
        // Criar HashTable
        Hashtable<Integer, String> myTable = new Hashtable<>();

        // Setar valores
        myTable.put(1, "Galo");
        myTable.put(2, "Galo Doido");
        myTable.put(3, "Galão da Massa");

        // Obter valor da chave
        String keyOne = myTable.get(1);
        System.out.println("Chave 1: " + keyOne);

        // Remover chave
        myTable.remove(3);

        // Verifica tamanho
        myTable.size();

        // Verificar se existe chave no HashTable
        if (myTable.containsKey(1)) {
            System.out.println("Chave 1 encontrada");
        }

        // Verificar se existe valor no HashTable
        if (myTable.containsValue("Galo Doido")) {
            System.out.println("Valor encontrado");
        }

        // Limpa todas entradas
        myTable.clear();
    }

    public void HashSetMethod() {
        // Criar HashSet
        HashSet<String> mySet = new HashSet<>();

        // Setar valores
        mySet.add("Galo");
        mySet.add("Galo Doido");
        mySet.add("Galão da Massa");

        // Remover chave
        mySet.remove("Galo");

        // Verifica tamanho
        mySet.size();

        // Verificar se existe chave no HashSet
        if (mySet.contains("Galo Doido")) {
            System.out.println("Valor encontrado");
        }

        // Percorre itens do HashSet
        for (String i : mySet) {
            System.out.println(i);
        }

        // Limpa todas entradas
        mySet.clear();
    }

    public void LinkedHashMapMethod() {
        // Criar LinkedHashMap
        LinkedHashMap <Integer, String> myLinkedHash = new LinkedHashMap<Integer, String>();

        // Adicionar valores
        myLinkedHash.put(1, "Galo");
        myLinkedHash.put(2, "Galo Doido");
        myLinkedHash.put(3, "Galão da Massa");

        // Remover chave
        myLinkedHash.remove(3);

        // Retorna a visualização Set dos mapeamentos no mapa
        System.out.println(myLinkedHash.entrySet());

        // Retorna a visualização Set das chaves no mapa
        System.out.println(myLinkedHash.keySet());

        // Retorna a visualização Collection dos valores no mapa.
        System.out.println(myLinkedHash.values());

        // Verificar se existe valor no LinkedHashMap
        if (myLinkedHash.containsValue("Galo Doido")) {
            System.out.println("Valor encontrado");
        }

        // Limpa todas entradas
        myLinkedHash.clear();
    }

    public void ConcurrentHashMapMethod() {
        // Criar ConcurrentHashMap
        ConcurrentHashMap<Integer, String> myConcurrentHash = new ConcurrentHashMap<>();

        // Adicionar valores
        myConcurrentHash.put(1, "Galo");
        myConcurrentHash.put(2, "Galo Doido");
        myConcurrentHash.put(3, "Galão da Massa");

        // Remover chave
        myConcurrentHash.remove(3);

        // Retorna a visualização Set dos mapeamentos no mapa
        System.out.println(myConcurrentHash.entrySet());

        // Retorna a visualização Set das chaves no mapa
        System.out.println(myConcurrentHash.keySet());

        // Retorna a visualização Collection dos valores no mapa.
        System.out.println(myConcurrentHash.values());

        // Verificar se existe valor no ConcurrentHashMap
        if (myConcurrentHash.containsValue("Galo Doido")) {
            System.out.println("Valor encontrado");
        }

        // Limpa todas entradas
        myConcurrentHash.clear();
    }
}
