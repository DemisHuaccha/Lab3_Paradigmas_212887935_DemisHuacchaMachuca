package TDAPlayer;


/**
 * La clase  TDAPlayer representa a un jugador.
 * Contiene información sobre su identificador, nombre, color, estadísticas de victorias, derrotas y empates,
 * así como la cantidad de piezas restantes que tiene.
 */
public class TDAPlayer{
    private int id;
    private String name;
    private String color;
    private int wins;
    private int losses;
    private int draws;
    private int remainingPieces;

    //Constructor
    /**
     * Constructor que inicializa un jugador con los valores proporcionados.
     * @param id el identificador único del jugador.
     * @param name el nombre del jugador.
     * @param color el color que representa al jugador.
     * @param wins la cantidad de victorias del jugador.
     * @param losses la cantidad de derrotas del jugador.
     * @param draws la cantidad de empates del jugador.
     * @param remainingPieces la cantidad de piezas restantes del jugador.
     */
    public TDAPlayer(int id, String name, String color, int wins, int losses, int draws, int remainingPieces) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.remainingPieces = remainingPieces;
    }
    //Getter's
    /**
     * Obtiene el identificador del jugador.
     * @return el identificador del jugador.
     */
    public int getId() {
        return id;
    }
    /**
     * Obtiene el nombre del jugador.
     * @return el nombre del jugador.
     */
    public String getName() {
        return name;
    }
    /**
     * Obtiene el color del jugador.
     * @return el color del jugador.
     */
    public String getColor() {
        return color;
    }
    /**
     * Obtiene las victorias del jugador.
     * @return las victorias del jugador.
     */
    public int getWins() {
        return wins;
    }
    /**
     * Obtiene las derrotas del jugador.
     * @return las derrotas del jugador.
     */
    public int getLosses() {
        return losses;
    }
    /**
     * Obtiene los empates del jugador.
     * @return los empates del jugador.
     */
    public int getDraws() {
        return draws;
    }
    /**
     * Obtiene las piezas restantes del jugador.
     * @return las piezas restantes del jugador.
     */
    public int getRemainingPieces() {
        return remainingPieces;
    }

    //setter's


    @Override
    public String toString() {
        return "Id: "+getId()+", Nombre: "+getName()+", Color: "+getColor()+", Wins: "+getWins()+ ", Losses: "+getLosses()+", Draws: "+getDraws()+", Remaining: "+getRemainingPieces();
    }

    /**
     * Establece el identificador del jugador.
     * @param id es el nuevo identificador del jugador.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Establece el nombre del jugador.
     * @param name es el nuevo nombre del jugador.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Establece el color del jugador.
     * @param color es el  color del jugador.
     */
    public void setColor(String color) {
        this.color = color;
    }
    /**
     * Establece las victorias del jugador.
     * @param wins el nuevo numero de victorias del jugador.
     */
    public void setWins(int wins) {
        this.wins = wins;
    }
    /**
     * Establece las derrotas del jugador.
     * @param losses el nuevo numero de derrotas del jugador.
     */
    public void setLosses(int losses) {
        this.losses = losses;
    }
    /**
     * Establece la cantidad de empates del jugador.
     * @param draws es el nuevo número de empates del jugador.
     */
    public void setDraws(int draws) {
        this.draws = draws;
    }
    /**
     * Establece las piezas que le quedan al jugador.
     * @param remainingPieces el nuevo numero de piezas restantes del jugador.
     */
    public void setRemainingPieces(int remainingPieces) {
            this.remainingPieces = remainingPieces;
    }

    /**
     * Actualiza las estadísticas del jugador en función del resultado de una partida.
     * @param resultado el resultado de la partida (0 = empate, 1 = victoria, 2 = derrota).
     */

    public void actualizarEstadisticas(int resultado) {
        if(resultado == 0){
            this.setDraws(this.getDraws()+1);
            System.out.println(" Empate ");
        }
        else if(resultado == 1){
            this.setWins((this.getWins())+1);
            System.out.println("Victoria del jugador: " + this.getId());
        }
        else if(resultado == 2){
            this.setLosses((this.getLosses())+1);
            System.out.println("Victoria del jugador: " + this.getId());
        }
    }


}
