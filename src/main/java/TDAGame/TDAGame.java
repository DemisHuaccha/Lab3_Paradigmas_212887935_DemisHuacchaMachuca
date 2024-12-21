package TDAGame;
import TDABoard.*;
import TDAPlayer.*;
import TDAGame.History;

import java.util.ArrayList;

public class TDAGame {
    private TDAPlayer p1;
    private TDAPlayer p2;
    private TDABoard board;
    private int currentTurn;
    private ArrayList<History> history;

    //Constructor
    public TDAGame(TDAPlayer p1, TDAPlayer p2, TDABoard board, int currentTurn) {
        int turns = p1.getRemainingPieces();
        this.p1 = p1;
        this.p2 = p2;
        this.board = board;
        this.currentTurn = currentTurn;
        this.history = new ArrayList<History>(2*turns);
    }

    //History
    public void history(){
        //int aux = p1.getRemainingPieces();
        System.out.println(this.history);
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
            this.getPlayer1().setDraws(this.getPlayer1().getDraws()+1);
            this.getPlayer2().setDraws(this.getPlayer2().getDraws()+1);
            System.out.println(" Empate ");
        }
        else if(this.getPlayer1().getId()==this.getBoard().entregarGanador()){
            this.getPlayer1().setWins((this.getPlayer1().getWins())+1);
            this.getPlayer2().setWins((this.getPlayer2().getLosses())+1);
            System.out.println("Victoria del jugador: " + this.getPlayer1().getId());
        }
        else if(this.getPlayer2().getId()==this.getBoard().entregarGanador()){
            this.getPlayer1().setWins((this.getPlayer1().getLosses())+1);
            this.getPlayer2().setWins((this.getPlayer2().getWins())+1);
            System.out.println("Victoria del jugador: " + this.getPlayer2().getId());
        }
        else if(this.getPlayer1().getId()==this.getBoard().entregarGanador()){
            this.getPlayer2().setWins((this.getPlayer2().getDraws())+1);
            this.getPlayer1().setWins((this.getPlayer1().getDraws())+1);
            System.out.println(" Empate ");
        }
    }

    public void realizarMovimiento(TDAPlayer playerAct, int columna ){
        if(playerAct.getId()==this.getPlayer1().getId() && playerAct.getId()==this.getCurrentTurn()){
            Casilla aux= new Casilla(playerAct.getColor(), playerAct.getId());
            board.playpiece(columna,aux);
            this.setCurrentTurn(this.getPlayer2().getId());
            this.getPlayer1().setRemainingPieces(this.getPlayer1().getRemainingPieces()-1);
            History movimiento= new History(playerAct.getId(), columna);
            this.history.add(movimiento);
            if(!this.board.can_play()){
                this.endGame();
            }
            else if (this.board.entregarGanador()!=0){
                this.endGame();
            }
            this.boardGetState();
        }
        else if(playerAct.getId()==this.getPlayer2().getId() && playerAct.getId()==this.getCurrentTurn()){
            Casilla aux= new Casilla(playerAct.getColor(), playerAct.getId());
            board.playpiece(columna,aux);
            this.setCurrentTurn(this.getPlayer1().getId());
            this.getPlayer2().setRemainingPieces(this.getPlayer2().getRemainingPieces()-1);
            History movimiento= new History(playerAct.getId(), columna);
            this.history.add(movimiento);
            if(!this.board.can_play()){
                this.endGame();
            }
            else if (this.board.entregarGanador()!=0){
                this.endGame();
            }
            this.boardGetState();
        }
    }

    /*
    public static void main(String[] args){
        TDABoard b0 = new TDABoard();
        TDAPlayer p1 = new TDAPlayer(1, "alex","rojo",0,0,0,20);
        TDAPlayer p2 = new TDAPlayer(2, "fer","verde",0,0,0,20);
        TDAGame g1 = new TDAGame(p1, p2, b0,2);
        g1.realizarMovimiento(p2, 0);
        g1.realizarMovimiento(p1, 1);
        g1.realizarMovimiento(p2, 1);
        g1.realizarMovimiento(p1, 2);
        g1.realizarMovimiento(p2, 2);
        g1.realizarMovimiento(p1, 3);
        g1.realizarMovimiento(p2, 2);
        g1.realizarMovimiento(p1, 3);
        g1.realizarMovimiento(p2,3);
        g1.realizarMovimiento(p1,5);
        g1.realizarMovimiento(p2,3);
    }
    */
}
