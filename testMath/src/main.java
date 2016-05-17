import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;


public class main {

    private static Random random = new Random();

    public static void main(String[] args) throws IOException
    {
        getRandomInt(1,100);
    }

    public static String getAnswer() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("=");
        String input = br.readLine();
        return input;
    }
    public static void getRandomInt(int min, int max) throws IOException
    {
        String question;
        int x = random.nextInt(max - min + 1) + min;
        int y = random.nextInt(max - min + 1) + min;
        System.out.println("X is:" + x + " Y is:" + y);
        if(x%y == 0)
        {
            question = x + "/" + y;
            System.out.print(question);
            if(getAnswer().equals(Integer.toString(x/y)))
            {
                System.out.print("Correct!");
            }
            else
            {
                getRandomInt(1,100);
            }
        }
        else if (y%x == 0)
        {
            question = y + "/" + x;
            System.out.print(question);
            if(getAnswer().equals(Integer.toString(y/x)))
            {
                System.out.print("Correct!");
            }
            else
            {
                getRandomInt(1,100);
            }
        }
        else if (y >= x)
        {
            question = y + "-" + x;
            System.out.print(question);
            if(getAnswer().equals(Integer.toString(y - x)))
            {
                System.out.print("Correct!");
            }
            else
            {
                getRandomInt(1,100);
            }
        }
        else
        {
            question = y + "+" + x;
            System.out.print(question);
            if(getAnswer().equals(Integer.toString(y + x)))
            {
                System.out.print("Correct!");
            }
            else
            {
                getRandomInt(1,100);
            }
        }
    }
}
