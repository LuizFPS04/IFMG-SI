public class DECList {
    Cellule head;

    public DECList() {
        Cellule head = new Cellule(-1);
        head.next = head;
        head.last = head;
    }

    public boolean empty() {
        return head.next == head;
    }

    public void insertEnd(Cellule cell) {
        if (empty()) {
            head.next = cell;
            cell.last = head;
            cell.next = head;
            head.last = cell;
        } else {
            Cellule auxCell = head.last;
            
            auxCell.next = cell;
            head.last = cell;
            cell.next = head;
            cell.last = auxCell;
        }
    }

    public void insertStart(Cellule cell) {
        Cellule auxCell = head.next;
        head.next = cell;
        cell.next = head;
        head.last = cell;
        cell.last = head;
    }

    public Cellule search(int value) {
        if (empty()) {
            return null;
        } else {
            int differenceLast = (head.last).value - value;
            int differenceNext = (head.next).value - value;
            if (differenceLast < differenceNext) {
                Cellule auxCell = head.last;

                while (auxCell != head && auxCell.value != value) {
                    auxCell = auxCell.last;
                }

                return auxCell;
            } else {
                Cellule auxCell = head.next;

                while (auxCell != head && auxCell.value != value) {
                    auxCell = auxCell.next;
                }

                return auxCell;
            }
        }
    }

    public void show() {
        Cellule auxCell = head.next;

        while (auxCell != head) {
            System.out.printf("Valor: %s\n", auxCell.value);
            auxCell = auxCell.next;
        }
    }
}