public class Stack {
    Cellule top;
    int amount;

    public Stack() {
        top = null;
        amount = 0;
    }

    public boolean empty() {
        return top == null;
    }

    public void stackUp(Cellule cell) {
        cell.next = top;
        top = cell;
        amount++;
    }

    public Cellule unstack() {
        if (empty()) {
            System.out.println("There are no items to unstack.");
            return null;
        } else {
            Cellule auxCell = top;
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
            Cellule auxCell = top;
            while (auxCell != null) {
                System.out.printf("Valor: %s\n", auxCell.value);
                auxCell = auxCell.next;
            }
        }
    }
}