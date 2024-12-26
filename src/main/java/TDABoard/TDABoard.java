package TDABoard;


import java.util.ArrayList;


/**
 * La clase TDABoard representa el tablero del juego "Conecta 4", donde el tablero tiene 7 columnas y cada una tiene 6
 * casillas representadas por los objetos Casilla.
 * Permite realizar acciones como colocar piezas en las columnas, mostrar el estado del tablero y verificar si hay un
 * ganador, empate o si se puede continuar jugando en el tablero
 */
public class TDABoard extends TDAPiece {
    private ArrayList<TDAPiece> C1;
    private ArrayList<TDAPiece> C2;
    private ArrayList<TDAPiece> C3;
    private ArrayList<TDAPiece> C4;
    private ArrayList<TDAPiece> C5;
    private ArrayList<TDAPiece> C6;
    private ArrayList<TDAPiece> C7;

    //Constructor

    /**
     * Constructor que crea un nuevo tablero de juego con 7 columnas, cada una con 6 celdas vacías.
     * Inicializa cada columna con un objeto Casilla vacío.
     */
    public TDABoard() {
        this.C1 = new ArrayList<>(6);
        this.C2 = new ArrayList<>(6);
        this.C3 = new ArrayList<>(6);
        this.C4 = new ArrayList<>(6);
        this.C5 = new ArrayList<>(6);
        this.C6 = new ArrayList<>(6);
        this.C7 = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            TDAPiece aux1 = new TDAPiece();
            TDAPiece aux2 = new TDAPiece();
            TDAPiece aux3 = new TDAPiece();
            TDAPiece aux4 = new TDAPiece();
            TDAPiece aux5 = new TDAPiece();
            TDAPiece aux6 = new TDAPiece();
            TDAPiece aux7 = new TDAPiece();
            C1.add(aux1);
            C2.add(aux2);
            C3.add(aux3);
            C4.add(aux4);
            C5.add(aux5);
            C6.add(aux6);
            C7.add(aux7);
        }
    }

    //Getter's

    /**
     * Obtiene la primera columna (C1) del tablero de juego.
     * @return la primera columna (C1).
     */
    // lo mismo para los siguientes getC*

    public ArrayList<TDAPiece> getC1() {
        return C1;
    }

    public ArrayList<TDAPiece> getC2() {
        return C2;
    }

    public ArrayList<TDAPiece> getC3() {
        return C3;
    }

    public ArrayList<TDAPiece> getC4() {
        return C4;
    }

    public ArrayList<TDAPiece> getC5() {
        return C5;
    }

    public ArrayList<TDAPiece> getC6() {
        return C6;
    }

    public ArrayList<TDAPiece> getC7() {
        return C7;
    }

    /**
     * Obtiene la columna en la posición especificada por el índice.
     * @param index el índice de la columna (de 0 a 6).
     * @return la columna correspondiente al índice especificado, o  null si el índice no es válido.
     */
    public ArrayList<TDAPiece> getColumna(int index) {
        if (index == 0) {
            return getC1();
        }
        if (index == 1) {
            return getC2();
        }
        if (index == 2) {
            return getC3();
        }
        if (index == 3) {
            return getC4();
        }
        if (index == 4) {
            return getC5();
        }
        if (index == 5) {
            return getC6();
        }
        if (index == 6) {
            return getC7();
        } else {
            return null;
        }
    }

    //ToString()

    /**
     * Convierte el índice de una fila en una representación en forma de String del tablero.
     * Cada columna se representa por su objeto  Casilla correspondiente.
     * @param i el índice de la fila (de 0 a 5).
     * @return un String que representa las celdas de todas las columnas en la fila especificada.
     */
    public String toString(int i) {
        return "" + C1.get(i).toString() + "   " + C2.get(i).toString() + "   " + C3.get(i).toString() + "   " + C4.get(i).toString() + "   " + C5.get(i).toString() + "   " + C6.get(i).toString() + "   " + C7.get(i).toString();
    }

    //Metodos

    /**
     * Muestra el estado del tablero en la consola.
     * Imprime las columnas del tablero en pantalla.
     * @param board el objeto  TDABoard que se va a mostrar.
     */
    public void getBoard(TDABoard board) {
        System.out.println("  C1      C2      C3      C4      C5      C6      C7");
        for (int i = 0; i < 6; i++) {
            System.out.println(board.toString(i));
        }
    }

    //can-play
    /**
     * Verifica si hay espacio disponible para jugar en alguna de las columnas.
     * @return  true si hay espacio disponible, false si no lo hay.
     */
    public boolean can_play() {
        if (getC1().get(0).getCasilla() == 0) {
            return true;
        } else if (getC2().get(0).getCasilla() == 0) {
            return true;
        } else if (getC3().get(0).getCasilla() == 0) {
            return true;
        } else if (getC4().get(0).getCasilla() == 0) {
            return true;
        } else if (getC5().get(0).getCasilla() == 0) {
            return true;
        } else if (getC6().get(0).getCasilla() == 0) {
            return true;
        } else if (getC7().get(0).getCasilla() == 0) {
            return true;
        } else {
            return false;
        }
    }


    //play_piece
    /**
     * Coloca una pieza en la columna especificada, si la columna está llena muestra un mensaje de error.
     * @param index el índice de la columna en la que se va a colocar la pieza (de 0 a 6).
     * @param TDAPiece el objeto Casilla que representa la pieza que se va a colocar.
     */
    public void playpiece(int index, TDAPiece TDAPiece) {
        String coloraux = TDAPiece.getColor();
        int idaux = TDAPiece.getCasilla();
        if (index == 0) {
            if (this.getC1().get(0).getCasilla() != 0) {
                System.out.println("Columna Llena");
            } else {
                int i = 5;
                while (this.getC1().get(i).getCasilla() != 0 && i >= 0) {
                    i = i - 1;
                }
                this.getC1().get(i).setColor(coloraux);
                this.getC1().get(i).setId(idaux);
            }
        } else if (index == 1) {
            if (this.getC2().get(0).getCasilla() != 0) {
                System.out.println("Columna Llena");
            } else {
                int i = 5;
                while (this.getC2().get(i).getCasilla() != 0 && i >= 0) {
                    i = i - 1;
                }
                this.getC2().get(i).setColor(coloraux);
                this.getC2().get(i).setId(idaux);
            }
        } else if (index == 2) {
            if (this.getC3().get(0).getCasilla() != 0) {
                System.out.println("Columna Llena");
            } else {
                int i = 5;
                while (this.getC3().get(i).getCasilla() != 0 && i >= 0) {
                    i = i - 1;
                }
                this.getC3().get(i).setColor(coloraux);
                this.getC3().get(i).setId(idaux);
            }
        } else if (index == 3) {
            if (this.getC4().get(0).getCasilla() != 0) {
                System.out.println("Columna Llena");
            } else {
                int i = 5;
                while (this.getC4().get(i).getCasilla() != 0 && i >= 0) {
                    i = i - 1;
                }
                this.getC4().get(i).setColor(coloraux);
                this.getC4().get(i).setId(idaux);
            }
        } else if (index == 4) {
            if (this.getC5().get(0).getCasilla() != 0) {
                System.out.println("Columna Llena");
            } else {
                int i = 5;
                while (this.getC5().get(i).getCasilla() != 0 && i >= 0) {
                    i = i - 1;
                }
                this.getC5().get(i).setColor(coloraux);
                this.getC5().get(i).setId(idaux);
            }
        } else if (index == 5) {
            if (this.getC6().get(0).getCasilla() != 0) {
                System.out.println("Columna Llena");
            } else {
                int i = 5;
                while (this.getC6().get(i).getCasilla() != 0 && i >= 0) {
                    i = i - 1;
                }
                this.getC6().get(i).setColor(coloraux);
                this.getC6().get(i).setId(idaux);
            }
        } else if (index == 6) {
            if (this.getC7().get(0).getCasilla() != 0) {
                System.out.println("Columna Llena");
            } else {
                int i = 5;
                while (C7.get(i).getCasilla() != 0 && i >= 0) {
                    i = i - 1;
                }
                this.getC7().get(i).setColor(coloraux);
                this.getC7().get(i).setId(idaux);
            }
        } else {
            System.out.println("Columna inexistente");
        }
    }

    /**
     * Verifica si hay un objeto Casilla  que se repita 4 veces en alguna columna.
     * @return el ID del jugador 1 o 2 si hay un ganador, o 0 si no hay ganador.
     */
    public int victoria_vertical() {
        int ganador = 0;
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j < 3; j++) {
                int a = this.getColumna(i).get(j).getCasilla();
                int b = this.getColumna(i).get(j + 1).getCasilla();
                int c = this.getColumna(i).get(j + 2).getCasilla();
                int d = this.getColumna(i).get(j + 3).getCasilla();
                if (a != 0 && a == b && b == c && c == d ){
                    ganador = a;
                    return ganador;
                }
            }
        }

        return ganador;
    }

    /**
     * Verifica si hay un objeto Casilla que se repita 4 veces en alguna fila.
     * @return el ID del jugador 1 o 2 si hay un ganador, o 0 si no hay ganador.
     */
    public int victoria_horizontal() {

        int ganador = 0;
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j < 4; j++) {
                int a = this.getColumna(j).get(i).getCasilla();
                int b = this.getColumna(j + 1).get(i).getCasilla();
                int c = this.getColumna(j + 2).get(i).getCasilla();
                int d = this.getColumna(j + 3).get(i).getCasilla();
                if (a != 0 && a == b && b == c && c == d){
                    ganador = a;
                    return ganador;
                }
            }
        }
        return ganador;
    }

    /**
     * Verifica si hay un objeto Casilla que se repita 4 veces en alguna dirección diagonal.
     * @return el ID del jugador 1 o 2 si hay un ganador, o 0 si no hay ganador.
     */
    public int victoria_diagonal() {
        int ganador = 0;

        for (int i = 3; i <= 5; i++) {
            for (int j = 0; j <= 3; j++) {
                int a = this.getColumna(j).get(i).getCasilla();
                int b = this.getColumna(j + 1).get(i - 1).getCasilla();
                int c = this.getColumna(j + 2).get(i - 2).getCasilla();
                int d = this.getColumna(j + 3).get(i - 3).getCasilla();

                if ((a != 0 && a == b && b == c && c == d)) {
                    ganador = a;
                    return ganador;
                }
            }
        }


        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 3; j++) {
                int a = this.getColumna(j).get(i).getCasilla();
                int b = this.getColumna(j + 1).get(i + 1).getCasilla();
                int c = this.getColumna(j + 2).get(i + 2).getCasilla();
                int d = this.getColumna(j + 3).get(i + 3).getCasilla();


                if ((a != 0 && a == b && b == c && c == d)) {
                    ganador = a;
                    return ganador;
                }
            }
        }

        return ganador;
    }

    /**
     * Verifica si hay un objeto Casilla que se repita 4 veces en las direcciónes horizontal, vertical o diagonal.
     * @return el ID del jugador 1 o 2 si hay un ganador, o 0 si no hay ganador.
     */
    public int entregarGanador(){
        if(this.victoria_vertical()!=0){
            return this.victoria_vertical();
        }
        else if (this.victoria_horizontal()!=0) {
            return this.victoria_horizontal();
        }
        else if (this.victoria_diagonal()!=0) {
            return this.victoria_diagonal();
        }
        else{
            return 0;
        }
    }
}

