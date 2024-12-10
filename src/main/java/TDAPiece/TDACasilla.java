package TDAPiece;

public class TDACasilla extends TDAPiece {
    private int id;

    //constructor

    public TDACasilla(){
        this.id = 0;
        this.setColor("Vacio");
    }

    public TDACasilla(String color) {
        super(color);
    }

    //Getter's

    public int getCasilla() {
        return id;
    }

    //Setter's

    public void setId(int id) {
        this.id = id;
    }

    //toString()

    public String toString(){
        return ""+this.getColor()+"";
    }



     public static void main(String[] argvs){
       TDACasilla casilla = new TDACasilla();
        System.out.printf(casilla.toString());
     }

}

