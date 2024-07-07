public class SEList {

    private Cellule firstCell;

    SEList() {
        firstCell = null;
    }

    public boolean empty() {
        return firstCell == null;
    }

    public void insertStart(Cellule cell) {
        cell.next = firstCell;
        firstCell = cell;
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
        }
    }

    public void inserMiddle(Cellule cell) {
        if (empty()) {
            firstCell = cell;
        } else {
            Cellule auxCell = firstCell;

            if (auxCell.next == null) {
                if (auxCell.value >= cell.value) {
                    insertStart(cell);
                } else {
                    insertEnd(cell);
                }
            }

            while (auxCell.next != null) {
                if (auxCell.value < cell.value && auxCell.next.value > cell.value) {
                    cell.next = auxCell.next;
                    auxCell.next = cell;
                }
                if (auxCell.next == null) {
                    auxCell.next = cell;
                }
                auxCell = auxCell.next;
            }

            auxCell.next = cell;
        }
    }

    public void removeEnd() {
        Cellule auxCellule = firstCell;

        if (auxCellule.next.next != null) {
            auxCellule = auxCellule.next;
        }

        auxCellule.next = null;
    }

    public void removeSpecific(Cellule cell) {
        Cellule auxCellule = firstCell;

        if (auxCellule.next.next != null) {
            auxCellule = auxCellule.next;
        }

        auxCellule.next = null;
        cell = null;
    }

    public void show() {
        Cellule auxCell = firstCell;

        while (auxCell != null) {
            System.out.printf("Valor: %s\n", auxCell.value);
            auxCell = auxCell.next;
        }
    }
}