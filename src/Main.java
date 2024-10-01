public class Main {
    public static void main(String[] args) throws Exception {

        // Declara nós para árvore
        Node rootOne = new Node(10);
        Node rootTwo = new Node(5);
        Node rootThree = new Node(20);
        Node rootFour = new Node(15);
        Node rootFive = new Node(17);

        BinaryTree tree = new BinaryTree();

        // Insere os nós nas árvores
        tree.insert(rootOne);
        tree.insert(rootTwo);
        tree.insert(rootThree);
        tree.insert(rootFour);
        tree.insert(rootFive);

        // 1) N° de nós da Árvore
        System.out.println("1) N° de nós: " + tree.amountNode());



        // tree.showPreOrder();

        tree.showOnOrder();
        System.out.println("--------------------------------------");
        tree.onOrderStack();
    }
}
