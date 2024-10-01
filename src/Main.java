public class Main {
    public static void main(String[] args) throws Exception {
        
        /*Instance cellules */
        /*Cellule cellOne = new Cellule(10);
        Cellule cellTwo = new Cellule(25);
        Cellule cellThree = new Cellule(30); */

        /*Instance SEList */
        /*SEList seList = new SEList();
        seList.insertStart(cellThree);
        seList.insertStart(cellTwo);
        seList.insertStart(cellOne);
        seList.removePair();

        seList.show(); */

        Node rootOne = new Node(10);
        Node rootTwo = new Node(5);
        Node rootThree = new Node(20);
        Node rootFour = new Node(15);
        Node rootFive = new Node(17);

        BinaryTree tree = new BinaryTree();

        tree.insert(rootOne);
        tree.insert(rootTwo);
        tree.insert(rootThree);
        tree.insert(rootFour);
        tree.insert(rootFive);

        // tree.showPreOrder();

        tree.showOnOrder();
        System.out.println("--------------------------------------");
        tree.onOrderStack();
    }
}
