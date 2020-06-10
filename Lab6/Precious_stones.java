package lab6;

public class Precious_stones extends Stones {
    private int rare;
    public Precious_stones(String name, double weight, int price, double clarity, int rare){
        super(name, weight, price, clarity);
        this.rare = rare;
    }
}

