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
                if (auxCell.value < cell.value && auxCell.next.value >= cell.value) {
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
        Cellule auxCell = firstCell;

        if (auxCell != null) {
            if (auxCell.next == null) {
                firstCell = null;
            } else {
                firstCell = auxCell.next;
                auxCell = null;
            }
        }
    }

    public void removeEnd() {
        Cellule auxCell = firstCell;

        if (auxCell.next == null) {
            firstCell = null;
        } else {
            if (auxCell.next.next != null) {
                auxCell = auxCell.next;
            }
            auxCell.next = null;
        }
        
    }

    public void removeSpecific(Cellule cell) {
        Cellule auxCell = firstCell;

        if (auxCell.next.next != null) {
            auxCell = auxCell.next;
        }

        auxCell.next = null;
        cell = null;
    }

    public boolean search(int valueInformed) {
        Cellule auxCell = firstCell;

        if (empty()) {
            System.out.println("N/A");
            return false;
        } else {
            if (auxCell.value == valueInformed) {
                System.out.println(auxCell.value);
                return true;
            } else {
                while (auxCell.next != null) {
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
        Cellule auxCell = firstCell;

        while (auxCell != null) {
            System.out.printf("Valor: %s\n", auxCell.value);
            auxCell = auxCell.next;
        }
    }
}