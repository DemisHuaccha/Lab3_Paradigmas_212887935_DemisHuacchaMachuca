package menu;
import TDAGame.History;
import TDAGame.TDAGame;
import TDAPlayer.TDAPlayer;

import java.util.ArrayList;
import java.util.LinkedList;

public interface verificar {

    boolean verificarDuplicados(LinkedList<TDAPlayer> jugadores, TDAPlayer jugador);
    void verificarTurnos(ArrayList<History> history, TDAGame g);
}
