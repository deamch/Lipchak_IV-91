package lab6;

public class Semiprecious_stones extends Stones{
    private int durability;
    public Semiprecious_stones(String name, double weight, int price, double clarity, int durability){
        super(name, weight, price, clarity);
        this.durability = durability;
    }

}

