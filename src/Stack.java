public class Stack {
    Node top;
    int amount;

    public Stack() {
        top = null;
        amount = 0;
    }

    public boolean empty() {
        return top == null;
    }

    public void stackUp(Node cell) {
        cell.next = top;
        top = cell;
        amount++;
    }

    public Node unstack() {
        if (empty()) {
            System.out.println("There are no items to unstack.");
            return null;
        } else {
            Node auxCell = top;
            top = top.next;
            auxCell.next = null;
            amount--;

            return auxCell;
        }
    }

    public void removeAll() {
        top = null;
    }

    public void showAll() {
        if (empty()) {
            System.out.println("There are no items to be shown.");
        } else {
            Node auxCell = top;
            while (auxCell != null) {
                System.out.printf("Valor: %s\n", auxCell.value);
                auxCell = auxCell.next;
            }
        }
    }
}