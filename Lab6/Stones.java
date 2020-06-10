package lab6;

public class Stones {

    private double weight, clarity;
    private int price;
    private String name;

    public Stones(String name, double weight, int price, double clarity){
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.clarity = clarity;
    }

    public String getName(){
        return name;
    }

    public double getWeight(){
        return weight;
    }


    public int getPrice(){
        return price;
    }

    public double getClarity(){
        return clarity;
    }
}
