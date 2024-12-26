package menu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import TDABoard.*;
import TDAGame.*;
import TDAPlayer.*;

//Linea de comando para ejecutar el programa
//java -cp build/classes/java/main menu.Main

/**
 * La clase Main contiene la lógica principal de un juego interactivo,
 * permitiendo la creación y visualización de jugadores y juegos, así como
 * la gestión de turnos y la verificación de duplicados. Implementa la interfaz verificar para manejar
 * la verificación de jugadores y el control de turnos.
 * Esta clase contiene un menú interactivo que permite al usuario realizar
 * diversas acciones relacionadas con los jugadores y juegos, incluyendo la
 * creación de jugadores, la visualización de estadísticas generales y la
 * gestión del flujo de un juego.
 */
public class Main implements verificar {


    /**
     * Verifica si un jugador con un identificador o color específico ya existe en la lista de jugadores.
     *
     * @param lista La lista de jugadores donde se busca la existencia de duplicados.
     * @param p El jugador que se desea verificar.
     * @return  true si el jugador no está duplicado, y false si ya existe un jugador con el mismo identificador o color.
     */
    @Override
    public boolean verificarDuplicados(LinkedList<TDAPlayer> lista, TDAPlayer p) {
        int largo = lista.size();
        for (int i = 0; i < largo; i++) {
            if (p.getId() == lista.get(i).getId() || p.getColor().equals(lista.get(i).getColor())){
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica y ajusta la cantidad de piezas restantes para cada jugador basado en el número de turnos
     * registrados en el historial y los turnos maximos registrados en un juego .
     *
     * @param history El historial de jugadas realizado en un juego.
     * @param g El objeto TDAJuegos que contiene los jugadores y el número máximo de turnos.
     */
    @Override
    public void verificarTurnos(ArrayList<History> history, TDAGame g){
        if(history.size() == g.getTurnosMaximos()){
            g.getPlayer1().setRemainingPieces(0);
            g.getPlayer2().setRemainingPieces(0);
        }
        else if((history.size()%2) !=0){
            g.getPlayer1().setRemainingPieces(g.getTurnosMaximos()-(history.size()/2));
            g.getPlayer2().setRemainingPieces(g.getTurnosMaximos()-(history.size()/2)+1);
        }
        else{
            g.getPlayer1().setRemainingPieces(g.getTurnosMaximos()-history.size()/2);
            g.getPlayer2().setRemainingPieces(g.getTurnosMaximos()-history.size()/2);
        }
    }

    /**
     * Método principal que ejecuta el menú interactivo del juego.
     * Permite la creación y visualizacion de los jugadores,y de los juegos,
     * ademas de la gestión de turnos para jugar.
     *
     * @param args Los argumentos de la línea de comandos (no utilizados en este caso).
     */

    public static void main(String[] args) {

        LinkedList<TDAPlayer> players = new LinkedList<TDAPlayer>();
        LinkedList<TDAGame> juegos= new LinkedList<TDAGame>();
        Main app=new Main(); //main instanciado para usar los metodos de la interface

        int selectorPrincipal=0;
        String input;
        Scanner scannerPrincipal = new Scanner(System.in);

        while(selectorPrincipal!=5) {

            System.out.println();

            try {
                System.out.println(" Menu de Inicio ");
                System.out.println(" 1. Crear o ver Jugador");
                System.out.println(" 2. Crear o ver Juegos");
                System.out.println(" 3. Ver Estadisticas generales");
                System.out.println(" 4. Jugar");
                System.out.println(" 5. Salir");
                System.out.println(" ----- DEBEN EXISTIR POR LO MENOS 2 JUGADORES PARARA JUGAR -----");

                System.out.println("Ingrese una opcion: ");
                input = scannerPrincipal.nextLine();
                selectorPrincipal = Integer.parseInt(input);
            }
            catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero entero.");
            }

            if (selectorPrincipal == 1) {
                System.out.println("Jugadores");
                System.out.println(" 1. Crear Jugador");
                System.out.println(" 2. Ver Jugadores");
                System.out.println(" 3. Anterior");
                System.out.println("----- LOS JUGADORES NO DEBEN TENER UN ID O COLOR IGUAL -----");
                int selectorAux1 = 0;
                try {
                    System.out.println("Ingrese una opcion: ");
                    input = scannerPrincipal.nextLine();
                    selectorAux1 = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Debes ingresar un numero entero.");
                }

                if (selectorAux1 == 1) {
                    System.out.println("Nombre del Jugador:");
                    String nombreJugador;
                    nombreJugador = scannerPrincipal.nextLine();
                    System.out.println("Color del Jugador:");
                    String colorJugador;
                    colorJugador = scannerPrincipal.nextLine();
                    int identificador = players.size()+1;
                    TDAPlayer playeraux = new TDAPlayer(identificador, nombreJugador, colorJugador, 0, 0, 0, 20);
                    players.add(playeraux);

                }
                else if (selectorAux1 == 2) {
                    int largo = players.size();
                    if (largo < 1) {
                        System.out.println("No hay jugadores creados");
                        System.out.println();
                    }
                    else {
                        System.out.println("Jugadores:");
                        for (int i = 0; i < largo; i++) {
                            System.out.println("jugador " + (i + 1) + "  =" + players.get(i).toString());
                        }
                    }
                }
            }
            else if (selectorPrincipal == 2) {
                System.out.println("Crear Juego");
                System.out.println(" 1. Crear Juego");
                System.out.println(" 2. Ver Juegos guardados");
                System.out.println(" 3. Anterior");
                System.out.println(" Seleccione una opcion");
                int selectorAux2 = 0;
                try {
                    input = scannerPrincipal.nextLine();
                    selectorAux2 = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Debes ingresar un numero entero.");
                    System.out.println();
                }

                if (players.size() < 2) {
                    System.out.println("No hay suficientes jugadores creados, se necesitan por lo menos 2 jugadores creados");
                    System.out.println();
                }
                else if (selectorAux2 == 1) {
                    int largo = players.size();
                    int auxPlayer1;
                    int auxPlayer2;
                    int auxPiezas;
                    System.out.println("Jugadores:");
                    for (int i = 0; i < largo; i++) {
                        System.out.println((i + 1) + ": " + players.get(i).toString());
                    }

                    System.out.println("Seleccione Jugador 1: ");
                    try {
                        input = scannerPrincipal.nextLine();
                        auxPlayer1 = Integer.parseInt(input);
                        System.out.println("Seleccione Jugador 2: ");
                        try {
                            input = scannerPrincipal.nextLine();
                            auxPlayer2 = Integer.parseInt(input);
                            if(auxPlayer2==auxPlayer1){
                                System.out.println("Selecione 2 jugadores distintos");
                            }
                            else {
                                System.out.println("Cantidad de piezas por jugador: ");
                                System.out.println("---- Fichas recomendadas para un juego ----");
                                System.out.println("----- 10 <= Cantidad de fichas <= 21 -----");
                                try {
                                    input = scannerPrincipal.nextLine();
                                    auxPiezas = Integer.parseInt(input);
                                    TDABoard auxboard = new TDABoard();
                                    players.get(auxPlayer1 - 1).setRemainingPieces(auxPiezas);
                                    players.get(auxPlayer2 - 1).setRemainingPieces(auxPiezas);
                                    TDAGame newgame = new TDAGame(players.get(auxPlayer1 - 1), players.get(auxPlayer2 - 1), auxboard, players.get(auxPlayer1 - 1).getId());
                                    juegos.add(newgame);
                                } catch (NumberFormatException e) {
                                    System.out.println("Debes ingresar un numero entero.");
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Debes ingresar un numero entero.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Debes ingresar un numero entero.");
                    }
                }
                else if (selectorAux2 == 2) {
                    System.out.println("Juegos");
                    int largo = juegos.size();
                    for (int i = 0; i < largo; i++) {
                        System.out.println("Juego " + (i + 1) + ": " + juegos.get(i).toString());
                        for(int j = 0; j < juegos.get(i).getHistory().size(); j++ ){
                            System.out.println("Historial de juego " + (i + 1) + ": " + juegos.get(i).getHistory().get(j).toString());
                        }
                    }
                    System.out.println();
                }
            }


            else if (selectorPrincipal == 3) {
                System.out.println("Estadisticas Generales");
                int largo = players.size();
                for (int i = 0; i < largo; i++) {
                    System.out.println("Jugador " + (i + 1) + ": " + players.get(i).toString());
                }
                System.out.println();
            }


            else if (selectorPrincipal == 4) {
                if(juegos.size()>0) {
                    System.out.println("Juegos");
                    int largo = juegos.size();
                    for (int i = 0; i < largo; i++) {
                        System.out.println("Juego "+(i + 1) + " :");
                        System.out.println("Jugador 1: " + juegos.get(i).getPlayer2());
                        System.out.println("Jugador 2: " + juegos.get(i).getPlayer1());
                    }
                    System.out.println("Seleccione un juego: ");
                    int auxJuego;

                    try {
                        System.out.println("Ingrese una opcion: ");
                        input = scannerPrincipal.nextLine();
                        auxJuego = Integer.parseInt(input);

                        TDABoard auxboard = juegos.get(auxJuego - 1).getBoard();
                        int aux;
                        app.verificarTurnos(juegos.get(auxJuego-1).getHistory(), juegos.get(auxJuego-1));
                        if(juegos.get(auxJuego-1).getBoard().entregarGanador()!=0) {
                            System.out.println("Juego Terminado");
                            System.out.println("Id Ganador :"+ juegos.get(auxJuego-1).getBoard().entregarGanador());
                        }
                        while ( auxboard.entregarGanador() == 0 && !juegos.get(auxJuego-1).isDraw()){
                            System.out.println("Turno del jugador: " + juegos.get(auxJuego - 1).getCurrentPlayer());
                            System.out.println("Estado del juego (Victoria) : " + juegos.get(auxJuego - 1).getBoard().entregarGanador());
                            System.out.println(juegos.get(auxJuego - 1).getBoard().toString());
                            System.out.println("Columna donde colocar pieza: ");
                            System.out.println("  0   -   1   -   2   -   3   -   4   -   5   -  6  ");
                            juegos.get(auxJuego-1).boardGetState();
                            try {
                                input = scannerPrincipal.nextLine();
                                aux = Integer.parseInt(input);
                                if(auxboard.entregarGanador() != 0 || juegos.get(auxJuego-1).isDraw()){
                                    break;
                                }

                                juegos.get(auxJuego - 1).realizarMovimiento(juegos.get(auxJuego - 1).getCurrentPlayer(), aux);
                                System.out.println("Continuar juego? (S = 1 o cualquier palabra / N = Numero distinto de 1");
                                int auxfin;
                                try {
                                    System.out.println("Ingrese una opcion: ");
                                    input = scannerPrincipal.nextLine();
                                    auxfin = Integer.parseInt(input);
                                    if (auxfin!=1){
                                        break;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Debes ingresar un numero entero.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Debes ingresar un numero entero.");
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Debes ingresar un numero entero.");
                    }
                }
                else{
                    System.out.println("No existe un juegos creados");
                }
            }
            else if (selectorPrincipal == 5) {
                System.out.println("Fin del juego");
                break;
            }
            System.out.println();
        }

        scannerPrincipal.close();
    }
}





