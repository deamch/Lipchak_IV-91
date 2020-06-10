package lab6;

public class Artificial_stones extends Stones{
    private double number_of_defects;
    public Artificial_stones(String name, double weight, int price, double clarity, double number_of_defects){
        super(name, weight, price, clarity);
        this.number_of_defects =number_of_defects ;
    }
}

