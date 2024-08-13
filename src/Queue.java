public class Queue {
    private Cellule frontCellule;
    private Cellule behindCellule;

    Queue() {
        this.frontCellule = new Cellule(-1);
        this.behindCellule = this.frontCellule;
        this.frontCellule.next = null;
    }

    public boolean isEmpty() {
        return this.frontCellule == this.behindCellule;
    }

    public void push(Cellule cell) {
        this.behindCellule.next = cell;
        this.behindCellule = this.behindCellule.next;
        this.behindCellule.next = null;
    }

    public Cellule pop() {
        if (isEmpty()) {
            System.out.println("Error - Queue is empty.");
            return null;
        }

        Cellule auxCell = this.frontCellule.next;

        this.frontCellule.next = auxCell.next;

        if (this.behindCellule == auxCell) {
            this.behindCellule = this.frontCellule;
        }

        return auxCell;
    }
    
    public Cellule getBehindCellule(){
        return behindCellule;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("There are no elements in the Queue");
        } else {
            Cellule queueAux = frontCellule.next;

            while (queueAux != null) {
                System.out.print(queueAux.value + " ");
                queueAux = queueAux.next;
            }
        }
    }
}