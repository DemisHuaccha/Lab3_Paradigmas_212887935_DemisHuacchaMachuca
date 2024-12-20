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
}
