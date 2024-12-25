package TDABoard;


import java.util.ArrayList;


//import TDAPiece.*;

public class TDABoard extends Casilla {
    private ArrayList<Casilla> C1;
    private ArrayList<Casilla> C2;
    private ArrayList<Casilla> C3;
    private ArrayList<Casilla> C4;
    private ArrayList<Casilla> C5;
    private ArrayList<Casilla> C6;
    private ArrayList<Casilla> C7;

    //Constructor

    public TDABoard() {
        this.C1 = new ArrayList<>(6);
        this.C2 = new ArrayList<>(6);
        this.C3 = new ArrayList<>(6);
        this.C4 = new ArrayList<>(6);
        this.C5 = new ArrayList<>(6);
        this.C6 = new ArrayList<>(6);
        this.C7 = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            Casilla aux1 = new Casilla();
            Casilla aux2 = new Casilla();
            Casilla aux3 = new Casilla();
            Casilla aux4 = new Casilla();
            Casilla aux5 = new Casilla();
            Casilla aux6 = new Casilla();
            Casilla aux7 = new Casilla();
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

    public ArrayList<Casilla> getC1() {
        return C1;
    }

    public ArrayList<Casilla> getC2() {
        return C2;
    }

    public ArrayList<Casilla> getC3() {
        return C3;
    }

    public ArrayList<Casilla> getC4() {
        return C4;
    }

    public ArrayList<Casilla> getC5() {
        return C5;
    }

    public ArrayList<Casilla> getC6() {
        return C6;
    }

    public ArrayList<Casilla> getC7() {
        return C7;
    }

    public ArrayList<Casilla> getColumna(int index) {
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

    public String toString(int i) {
        return "" + C1.get(i).toString() + "   " + C2.get(i).toString() + "   " + C3.get(i).toString() + "   " + C4.get(i).toString() + "   " + C5.get(i).toString() + "   " + C6.get(i).toString() + "   " + C7.get(i).toString();
    }

    //Metodos

    //Impresion en pantalla del tablero
    public void getBoard(TDABoard board) {
        System.out.println("  C1      C2      C3      C4      C5      C6      C7");
        for (int i = 0; i < 6; i++) {
            System.out.println(board.toString(i));
        }
    }

    //can-play
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

    public void playpiece(int index, Casilla casilla) {
        String coloraux = casilla.getColor();
        int idaux = casilla.getCasilla();
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

    //Para de-bug
    /*
    public static void main(String[] args) {
        TDABoard board = new TDABoard();
        Casilla a = new Casilla();
        Casilla b = new Casilla();
        a.setId(1);
        a.setColor("rojo");
        b.setId(2);
        b.setColor("verde");
        board.can_play();
        board.can_play();
        board.playpiece(0,b);
        board.playpiece(1,a);
        board.playpiece(1,b);
        board.playpiece(2,a);
        board.playpiece(3,b);
        board.playpiece(2,a);
        board.playpiece(2,b);
        board.playpiece(3,a);
        board.playpiece(3,b);
        board.playpiece(4,a);
        board.playpiece(3,b);
        System.out.println("Victoria Vertical: "+board.victoria_vertical());
        System.out.println("Victoria Horizontal: "+board.victoria_horizontal());
        System.out.println("Victoria Diagonal: "+board.victoria_diagonal());
        board.getBoard(board);
    }
    */
}
