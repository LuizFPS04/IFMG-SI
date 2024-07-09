public class SECList {

    private Cellule head;

    SECList() {
        head = new Cellule(-1);
        head.next = head;
    }

    public boolean empty() {
        return head.next == head;
    }

    public void insertStart(Cellule cell) {
        Cellule auxCell = head.next;
        head.next = cell;
        cell.next = auxCell;
    }
    
    public void insertEnd(Cellule cell) {
        if (empty()) {
            head.next = cell;
            cell.next = head;
        } else {
            Cellule auxCell = head.next;

            while (auxCell != head) { 
                auxCell = auxCell.next;
                auxCell.next = cell;
                cell.next = head;
            }
        }
        
    }
}
