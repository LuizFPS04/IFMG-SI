public class DEList {

    Cellule firstCell;

    public DEList() {
        firstCell = null;
    }

    public boolean empty() {
        return firstCell == null;
    }

    public void insertEnd(Cellule cell) {
        if (empty()) {
            firstCell = cell;
        } else {
            Cellule auxCell = firstCell;

            while (auxCell.next != null) {
                auxCell = auxCell.next;
            }

            auxCell.next = cell;
            cell.last = auxCell;
        }
    }

    public void insertStart(Cellule cell) {
        if (empty()) {
            firstCell = cell;
        } else {
            cell.next = firstCell;
            firstCell.last = cell;
        }
    }

    public Cellule search(int value) {
        if (empty()) {
            return null;
        } else {
            Cellule auxCell = firstCell;
            while (auxCell.next != null && auxCell.value != value) {
                auxCell = auxCell.next;
            }
            return auxCell;
        }
    }

    public boolean removeStart() {
        if (empty()) {
            return false;
        } else {
            Cellule auxCell = firstCell;
            if (auxCell.next == null) {
                firstCell = null;
            } else {
                firstCell = auxCell.next;
                firstCell.last = null;
                auxCell.next = null;
            }
            return true;
        }
    }

    public boolean removeEnd() {
        if (empty()) {
            return false;
        } else {
            Cellule auxCell = firstCell;
            while (auxCell.next != null) {
                auxCell = auxCell.next;
            }

            if (auxCell.last != null) {
                (auxCell.last).next = null;
            }
            auxCell.last = null;
            return true;
        }
    }

    public void show() {
        Cellule auxCell = firstCell;

        while (auxCell.next != null) {
            System.out.printf("Valor: %s\n", auxCell.value);
            auxCell = auxCell.next;
        }
    }
}