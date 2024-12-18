package TDABoard;

public class Casilla {
    private int id;
    private String color;
    //constructor

    public Casilla(){
        this.id = 0;
        this.color="Vacio";
    }

    public Casilla(String color, int identificador) {
        this.color=color;
        this.id=identificador;
    }

    //Getter's

    public int getCasilla() {
        return id;
    }
    public String getColor() {
        return color;
    }

    //Setter's

    public void setId(int id) {
        this.id = id;
    }
    public void setColor(String color) {
        this.color = color;
    }
    //toString()

    public String toString(){
        return ""+this.getColor()+"";
    }



    public static void main(String[] argvs){
        Casilla casilla = new Casilla();
        System.out.printf(casilla.toString());
    }


}
