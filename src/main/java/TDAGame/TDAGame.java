package TDAGame;
import TDABoard.*;
import TDAPlayer.*;


import java.util.ArrayList;

public class TDAGame extends History{
    private TDAPlayer p1;
    private TDAPlayer p2;
    private TDABoard board;
    private int currentTurn;
    private ArrayList<History> history;
    int turnosMaximos;

    //Constructor
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
    public History history( int mov, int id){
        return new History(mov, id);
    }

     @Override
     public String toString() {
        return "p1=" + this.getPlayer1().getName() + ", "+ this.getPlayer1().getId() + ", " +this.getPlayer1().getColor() + ", p2=" + this.getPlayer2().getName() + ", "+ this.getPlayer2().getId() + ", " +this.getPlayer2().getColor() + ", Turno de jugador :" + this.getCurrentTurn();
     }

    //Setter's

    public void setBoard(TDABoard board) {
        this.board = board;
    }

    public void setP1(TDAPlayer p1) {
        this.p1 = p1;
    }
    public void setP2(TDAPlayer p2) {
        this.p2 = p2;
    }
    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }

    //Getter's

    public TDAPlayer getPlayer1() {
        return p1;
    }
    public TDAPlayer getPlayer2() {
        return p2;
    }
    public TDABoard getBoard() {
        return board;
    }
    public int getCurrentTurn() {
        return currentTurn;
    }
    public ArrayList<History> getHistory() {
        return history;
    }
    public int getTurnosMaximos(){
        return turnosMaximos;
    }

    //Metodos

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

    public TDAPlayer getCurrentPlayer(){
        int turn= this.getCurrentTurn();
        if(this.getPlayer1().getId()==turn){
            return this.getPlayer1();
        }
        else{
            return this.getPlayer2();
        }
    }

    public void boardGetState(){
        board.getBoard(this.board);
    }

    //End Game

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

    public void realizarMovimiento(TDAPlayer playerAct, int columna ){
        if(playerAct.getId()==this.getPlayer1().getId() && playerAct.getId()==this.getCurrentTurn()){
            Casilla aux= new Casilla(playerAct.getColor(), playerAct.getId());
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
            Casilla aux= new Casilla(playerAct.getColor(), playerAct.getId());
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
