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

    public void inserMiddle(Cellule cell) {
        if (empty()) {
            head.next = cell;
        } else {
            Cellule auxCell = head.next;

            if (auxCell == head) {
                if (auxCell.value >= cell.value) {
                    insertStart(cell);
                } else {
                    insertEnd(cell);
                }
            }

            while (auxCell != head) {
                if (auxCell.value < cell.value && auxCell.next.value > cell.value) {
                    cell.next = auxCell.next;
                    auxCell.next = cell;
                } else {
                    auxCell.next = cell;
                }
                auxCell = auxCell.next;
            }
        }
    }

    public void removeStart() {
        Cellule auxCell = head.next;

        if (auxCell != head) {
            if (auxCell.next == head) {
                head.next = head;
                auxCell = head;
            } else {
                head.next = auxCell.next;
                auxCell = head;
            }
        }
    }

    public void removeEnd() {
        Cellule auxCell = head.next;

        if (auxCell != head) {
            if (auxCell.next.next != head) {
                auxCell = auxCell.next;
            }
            auxCell.next = head;
        }
        
    }

    public void removeSpecific(Cellule cell) {
        Cellule auxCell = head.next;

        while (auxCell.next.next != head) {
            auxCell = auxCell.next;
            auxCell.next = head;
            cell = head;
        }
    }

    public boolean search(int valueInformed) {
        Cellule auxCell = head.next;

        if (empty()) {
            System.out.println("N/A");
            return false;
        } else {
            if (auxCell.value == valueInformed) {
                System.out.println(auxCell.value);
                return true;
            } else {
                while (auxCell != head) {
                    if (auxCell.value == valueInformed) {
                        System.out.println(auxCell.value);
                        return true;
                    }
                    auxCell = auxCell.next;
                }
            }
            System.out.println("N/A");
            return false;
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
