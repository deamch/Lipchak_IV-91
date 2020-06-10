package lab7;

import lab6.*;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyList n = new MyList();
        n.add(new Stones("Rubin", 3.95, 600, 2.1));
        n.add(new Semiprecious_stones("Agate", 5.89, 200, 1.7, 82));
        n.add(new Artificial_stones("Quartz ", 10.2, 573, 5.3, 0.17));
        n.add(new Precious_stones("Diamond", 2.72, 11830, 15.1, 28));
        n.add(new Semiprecious_stones("Hyacinth", 3.91, 167, 2.56, 52));
        n.add(new Artificial_stones("Onyx", 8.34, 720, 4.21, 3.57));

        Iterator iterator = n.iterator();
        System.out.println("\nfirst list:");
        while (iterator.hasNext()){
            Stones st = (Stones) iterator.next();
            System.out.println(st.getName());
        }
        MyList n1 = new MyList(n);
        Iterator iterator1 = n1.iterator();
        System.out.println("\nsecond list(testing function addAll):");
        while (iterator1.hasNext()){
            Stones st = (Stones) iterator1.next();
            System.out.println(st.getName());
        }
        n1.clear();
        Iterator iterator2 = n1.iterator();
        System.out.println("\nsecond list after clear(it is empty):");
        while (iterator2.hasNext()){
            Stones st = (Stones) iterator2.next();
            System.out.println(st.getName());
        }
    }
}
