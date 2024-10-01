import java.util.HashMap;

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
}
