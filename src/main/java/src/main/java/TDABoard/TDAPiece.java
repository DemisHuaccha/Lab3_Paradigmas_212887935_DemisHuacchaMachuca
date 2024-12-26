package TDABoard;


/**
 * La clase Casilla representa una casilla en un tablero de juego.
 * Cada casilla tiene un identificador y un color, que indican el jugador que ocupa la casilla.
 */
public class TDAPiece {
    private int id;
    private String color;
    //constructor

    /**
     * Constructor por defecto. Inicializa la casilla con un identificador de 0 (vacio) para trabajar internamente y "Vacio" como color.
     */
    public TDAPiece(){
        this.id = 0;
        this.color="Vacio";
    }

    /**
     * Constructor que inicializa la casilla con un color específico.
     * @param color el color de la casilla (representa el jugador que ocupa la casilla).
     */
    public TDAPiece(String color){
        this.id = 0;
        this.color=color;
    }

    /**
     * Constructor que inicializa la casilla con un color y un identificador específicos.
     * @param color el color de la casilla (representa el jugador que ocupa la casilla).
     * @param identificador el identificador único de la casilla  para los jugadores.
     */
    public TDAPiece(String color, int identificador) {
        this.color=color;
        this.id=identificador;
    }

    //Getter's
    /**
     * Obtiene el identificador de la casilla.
     * @return el identificador de la casilla (0 para vacío, 1 para el jugador 1, 2 para el jugador 2).
     */
    public int getCasilla() {
        return id;
    }
    /**
     * Obtiene el color de la casilla, que representa al jugador que la ocupa.
     * @return el color de la casilla (por ejemplo, "Rojo", "Amarillo", "Vacio").
     */
    public String getColor() {
        return color;
    }

    //Setter's
    /**
     * Establece el identificador de la casilla.
     * @param id el nuevo identificador para la casilla (0 para vacío, 1 o 2 para los jugadores).
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Establece el color de la casilla.
     * @param color el nuevo color para la casilla, que representa al jugador que la ocupará.
     */
    public void setColor(String color) {
        this.color = color;
    }
    //toString()
    /**
     * Devuelve una representación en forma de String del color de la casilla.
     * @return una cadena que representa el color de la casilla.
     */
    public String toString(){
        return ""+this.getColor()+"";
    }

}
