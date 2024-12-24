package TDAGame;

public class History {
    private int id;
    private int column;

    //Constructor
    public History(int id, int column) {
        this.id = id;
        this.column = column;
    }
    //Getter's
    public int getId() {
        return id;
    }
    public int getColumn() {
        return column;
    }

    public String toString() {
        return "id: " + this.id + ", column: " + this.column;
    }
}
