package lab6;

import java.util.Comparator;

public class Sort implements Comparator<Stones> {
    @Override
    public int compare(Stones obj1, Stones obj2){
        return obj2.getPrice() - obj1.getPrice();
    }
}

