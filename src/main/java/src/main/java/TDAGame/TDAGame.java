package TDAGame;
import TDABoard.*;
import TDAPlayer.*;


import java.util.ArrayList;

/**
 * La clase  TDAGame representa a un juego.
 * Contiene dos jugadores p1 y p2, un tablero, un int que representa el turno correspondiente al jugador que debe jugar,
 * un ArrayList<History> que almacena todos los movimientos realizados y un int turnosMaximos, que representan los turnos
 * Maximos que pueden haber en el juego por jugador
 */

public class TDAGame extends History{
    private TDAPlayer p1;
    private TDAPlayer p2;
    private TDABoard board;
    private int currentTurn;
    private ArrayList<History> history;
    int turnosMaximos;

    /**
     * Constructor de la clase TDAGame.
     *
     * @param p1 El primer jugador.
     * @param p2 El segundo jugador.
     * @param board El tablero en el que se juega.
     * @param currentTurn El turno actual del juego.
     */

    public TDAGame(TDAPlayer p1, TDAPlayer p2, TDABoard board, int currentTurn) {
        super();
        int turns = p1.getRemainingPieces();
        this.p1 = p1;
        this.p2 = p2;
        this.board = board;
        this.currentTurn = currentTurn;
        this.history = new ArrayList<History>(2*turns);
        this.turnosMaximos = turns;
    }

    //History
    /**
     * Crea una instancia de la clase History para registrar un movimiento.
     *
     * @param mov La columna escogida para colocar la pieza.
     * @param id El identificador del jugador que realizó el movimiento.
     * @return Un objeto History que representa el movimiento realizado.
     */
    public History history( int mov, int id){
        return new History(mov, id);
    }

     @Override
     /**
      * Representa el estado del juego como una cadena de texto, sin imprimir en pantalla el tablero.
      *
      * @return un String con la información del juego.
      */
     public String toString() {
        return "p1=" + this.getPlayer1().getName() + ", "+ this.getPlayer1().getId() + ", " +this.getPlayer1().getColor() + ", p2=" + this.getPlayer2().getName() + ", "+ this.getPlayer2().getId() + ", " +this.getPlayer2().getColor() + ", Turno de jugador :" + this.getCurrentTurn() + ", Estado (Victorio): "+ this.getBoard().entregarGanador() + ", Tablero(se puede jugar): "+this.getBoard().can_play();
     }

    //Setter's

    /**
     *  Se obtinee el tablero del juego.
     *
     * @param board el tablero del juego.
     */
    public void setBoard(TDABoard board) {
        this.board = board;
    }

    /**
     * Establece el turno actual.
     *
     * @param currentTurn El turno actual.
     */
    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }

    //Getter's
    /**
     * Obtiene el primer jugador.
     *
     * @return El primer jugador.
     */
    public TDAPlayer getPlayer1() {
        return p1;
    }
    /**
     * Obtiene el segundo jugador.
     *
     * @return el segundo jugador.
     */
    public TDAPlayer getPlayer2() {
        return p2;
    }
    /**
     * Obtiene el tablero del juego.
     *
     * @return el tablero.
     */
    public TDABoard getBoard() {
        return board;
    }
    /**
     * Obtiene el turno actual.
     *
     * @return El turno actual.
     */
    public int getCurrentTurn() {
        return currentTurn;
    }
    /**
     * Obtiene el historial de movimientos realizados en el juego.
     *
     * @return El historial de movimientos.
     */
    public ArrayList<History> getHistory() {
        return history;
    }
    /**
     * Obtiene el número máximo de turnos en el juego.
     *
     * @return El número máximo de turnos.
     */
    public int getTurnosMaximos(){
        return turnosMaximos;
    }

    //Metodos
    /**
     * Verifica si el juego ha terminado en empate.
     *
     * @return True si el juego terminó en empate, false si no.
     */
    public boolean isDraw(){
        if(getBoard().can_play()) {
            return false;
        }
        else if (getPlayer1().getRemainingPieces() == getPlayer2().getRemainingPieces() && getPlayer1().getRemainingPieces() == 0) {
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * Obtiene el jugador que debe realizar el siguiente movimiento.
     *
     * @return El jugador cuyo turno es el siguiente.
     */
    public TDAPlayer getCurrentPlayer(){
        int turn= this.getCurrentTurn();
        if(this.getPlayer1().getId()==turn){
            return this.getPlayer1();
        }
        else{
            return this.getPlayer2();
        }
    }
    /**
     * Muestra el estado actual del tablero.
     */
    public void boardGetState(){
        board.getBoard(this.board);
    }

    //End Game

    /**
     * Finaliza el juego y actualiza las estadísticas de los jugadores.
     */

    public void endGame(){
        if(!this.board.can_play()){
            this.getPlayer1().actualizarEstadisticas(0);
            this.getPlayer2().actualizarEstadisticas(0);
            System.out.println(" Empate ");
        }
        else if(this.getPlayer1().getId()==this.getBoard().entregarGanador()){
            this.getPlayer1().actualizarEstadisticas(1);
            this.getPlayer2().actualizarEstadisticas(2);
            System.out.println("Victoria del jugador: " + this.getPlayer1().getId());
        }
        else if(this.getPlayer2().getId()==this.getBoard().entregarGanador()){
            this.getPlayer1().actualizarEstadisticas(2);
            this.getPlayer2().actualizarEstadisticas(1);
            System.out.println("Victoria del jugador: " + this.getPlayer2().getId());
        }
        else if(this.getBoard().entregarGanador()==0){
            this.getPlayer2().actualizarEstadisticas(0);
            this.getPlayer1().actualizarEstadisticas(0);
            System.out.println(" Empate ");
        }
    }


    /**
     * Realiza un movimiento realizado por un jugador, y verifica si el juego a terminado por empate o victorio.
     *
     * @param playerAct El jugador que realiza el movimiento.
     * @param columna La columna donde se realiza el movimiento.
     */

    public void realizarMovimiento(TDAPlayer playerAct, int columna ){
        if(playerAct.getId()==this.getPlayer1().getId() && playerAct.getId()==this.getCurrentTurn()){
            TDAPiece aux= new TDAPiece(playerAct.getColor(), playerAct.getId());
            board.playpiece(columna,aux);
            this.setCurrentTurn(this.getPlayer2().getId());
            this.getPlayer1().setRemainingPieces(this.getPlayer1().getRemainingPieces()-1);
            this.history.add(history(playerAct.getId(), columna));
            if(!this.board.can_play()){
                this.endGame();
            }
            else if (this.board.entregarGanador()!=0){
                this.endGame();
            }
            //this.boardGetState();
        }
        else if(playerAct.getId()==this.getPlayer2().getId() && playerAct.getId()==this.getCurrentTurn()){
            TDAPiece aux= new TDAPiece(playerAct.getColor(), playerAct.getId());
            board.playpiece(columna,aux);
            this.setCurrentTurn(this.getPlayer1().getId());
            this.getPlayer2().setRemainingPieces(this.getPlayer2().getRemainingPieces()-1);
            this.history.add(history(playerAct.getId(), columna));
            if(!this.board.can_play()){
                this.endGame();
            }
            else if (this.board.entregarGanador()!=0){
                this.endGame();
            }
            //this.boardGetState();
        }
    }

}
