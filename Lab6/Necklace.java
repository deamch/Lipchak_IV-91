package lab6;

import java.util.Arrays;

public class Necklace {

    private Stones[] stone;

    public Necklace(int number){
        stone = new Stones[number];
    }

    public void addStone(Stones stn){
        int k = 0;
        boolean t = true;
        for(int i=0;(i<stone.length)&&t;i++){
            if (stone[i] == null){
                k = i;
                t = false;
            }
        }
        if (k != stone.length)
            stone[k] = stn;
    }

    public double totalW(){
        double total_weight=0.0;
        for(int i=0; i<stone.length; i++){
            total_weight+=stone[i].getWeight();
        }
        return total_weight;
    }

    public double totalP(){
        double total_price=0.0;
        for(int i=0; i<stone.length; i++){
            total_price+=stone[i].getPrice();
        }
        return total_price;
    }

    public void sortPrice(){
        Arrays.sort(stone, new Sort());
    }

    public Stones[] searchStone(double start, double finish){
        Stones[] stn = new Stones[stone.length];
        int k = 0;
        for(int i = 0; i<stone.length;i++){
            if(stone[i].getClarity()>=start && stone[i].getClarity()<=finish){
                stn[k] = stone[i];
                k++;
            }
        }
        return stn;
    }
    @Override
    public String toString(){
        String s = '\n'+"Stones sorted by price:";
        for(int i = 0;i<stone.length;i++){
            s += '\n'+"Name: "+stone[i].getName()+'\n'+"Price: "+stone[i].getPrice();
        }
        return s;
    }
}

