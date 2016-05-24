import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthew.t.plummer on 24/05/2016.
 */
public class arrayFor {
    public static ArrayList<Integer> a = new ArrayList<Integer>();
    public static ArrayList<Integer> b = new ArrayList<Integer>();
    public static ArrayList<Integer> c = new ArrayList<Integer>();


    public static void main(String args[]) {
        for (int i = 0; i < 5; i++) {
            a.add(i,i);
            b.add(i,i);
        }
        for(int j = 0; j < a.size(); j++)
        {
            c.add(j,a.get(j) + b.get(j));
        }
        System.out.print(c);
    }

}
