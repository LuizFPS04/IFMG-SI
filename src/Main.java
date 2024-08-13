public class Main {
    public static void main(String[] args) throws Exception {
        
        /*Instance cellules */
        Cellule cellOne = new Cellule(10);
        Cellule cellTwo = new Cellule(20);
        Cellule cellThree = new Cellule(30);

        /*Instance SEList */
        SEList seList = new SEList();
        SECList secList = new SECList();

        secList.insertStart(cellThree);
        secList.insertStart(cellTwo);
        secList.insertStart(cellOne);

        secList.show();
        
        secList.removeSpecific(cellTwo);

        secList.show();
    }
}
