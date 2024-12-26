package menu;
import TDAGame.History;
import TDAGame.TDAGame;
import TDAPlayer.TDAPlayer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Interfaz para verificar si existe un jugador con id o color ya existente en el juego, y un verificador
 * que gestiona los turnos durante el juego.
 */
public interface verificar {

    boolean verificarDuplicados(LinkedList<TDAPlayer> jugadores, TDAPlayer jugador);
    void verificarTurnos(ArrayList<History> history, TDAGame g);
}
