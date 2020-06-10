package lab6;

public class Main {
    public static void main(String[] args){

        int sNumber = 6;
        Necklace n = new Necklace(sNumber);

        n.addStone(new Stones ("Rubin", 3.95, 600, 2.1));
        n.addStone(new Semiprecious_stones("Agate", 5.89, 200, 1.7, 82));
        n.addStone(new Artificial_stones("Quartz ", 10.2, 573, 5.3, 0.17));
        n.addStone(new Precious_stones("Diamond", 2.72, 11830, 15.1, 28));
        n.addStone(new Semiprecious_stones("Hyacinth", 3.91, 167, 2.56, 52));
        n.addStone(new Artificial_stones("Onyx", 8.34, 720, 4.21, 3.57));

        System.out.println("Weight of the necklace: "+n.totalW()+" ct.");

        System.out.println("Weight of the necklace: "+n.totalP()+" grn.");

        double start = 2;
        double finish = 16;
        Stones[] chooseClarity = n.searchStone(start,finish);
        System.out.println('\n'+"Stones with the defined clarity (from "+start+" to "+finish+"): ");
        for(int i = 0;chooseClarity[i] != null && i<chooseClarity.length;i++){
            System.out.println("Name: "+chooseClarity[i].getName());
            System.out.println("Clarity of the stone: "+chooseClarity[i].getClarity());
        }
        n.sortPrice();
        System.out.println(n);
    }
}

