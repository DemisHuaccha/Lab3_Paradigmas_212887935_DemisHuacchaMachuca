package TDAPlayer;


public class TDAPlayer{
    private int id;
    private String name;
    private String color;
    private int wins;
    private int losses;
    private int draws;
    private int remainingPieces;

    //Constructor

    public TDAPlayer(int id, String name, String color, int wins, int losses, int draws, int remainingPieces) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.remainingPieces = remainingPieces;
    }
    //Getter's
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public int getWins() {
        return wins;
    }
    public int getLosses() {
        return losses;
    }
    public int getDraws() {
        return draws;
    }
    public int getRemainingPieces() {
        return remainingPieces;
    }

    //setter's


    @Override
    public String toString() {
        return "Id: "+getId()+", Nombre: "+getName()+", Color: "+getColor()+", Wins: "+getWins()+ ", Losses: "+getLosses()+", Draws: "+getDraws()+", Remaining: "+getRemainingPieces();
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setWins(int wins) {
        this.wins = wins;
    }
    public void setLosses(int losses) {
        this.losses = losses;
    }
    public void setDraws(int draws) {
        this.draws = draws;
    }
    public void setRemainingPieces(int remainingPieces) {
        if(remainingPieces >= 4 && remainingPieces <= 24) {
            this.remainingPieces = remainingPieces;
        }
        else{
            System.out.println("Error: Las Piezas del jugador deben ser por lo menos 4 y maximo 24");
        }
    }


}
