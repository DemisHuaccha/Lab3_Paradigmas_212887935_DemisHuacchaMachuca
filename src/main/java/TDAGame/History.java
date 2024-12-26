package TDAGame;

/**
 * La clase History representa un registro de un movimineto realizado.
 * Cada instancia de esta clase almacena el identificador del jugador y la columna donde se realizo la jugada.
 */
public class History {
    private int id;
    private int column;

    //Constructor
    /**
     * Constructor que inicializa un registro del movimiento realizado.
     * @param id el identificador del jugador.
     * @param column la columna en la que se realizó la jugada.
     */
    public History(int id, int column) {
        this.id = id;
        this.column = column;
    }

    /**
     * Constructor por defecto que inicializa un registro de acción sin valores asignados.
     */
    public History() {
    }

    //Getter's
    public int getId() {
        return id;
    }
    public int getColumn() {
        return column;
    }

    /**
     * Devuelve una representación en forma de String del movimiento registrado.
     * @return un String con el identificador del jugador y la columna donde se realizo la jugada.
     */
    public String toString() {
        return "id: " + this.id + ", column: " + this.column;
    }
}
