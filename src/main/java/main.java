import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;


public class main {

    private static Random random = new Random();

    @PostConstruct
    public void setRandomRange() throws IOException
    {
        generateQuestion(1, 200);
    }

    public static String readInAnswer() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("=");
        String input = br.readLine();
        return input;
    }
    public static void generateQuestion(int min, int max) throws IOException
    {
        String question;
        int number1 = random.nextInt(max - min + 1) + min;
        int number2 = random.nextInt(max - min + 1) + min;
        int equationChooser = random.nextInt(max - min + 1) + min;
        System.out.println("X is:" + number1 + " Y is:" + number2 + " Z is: " + equationChooser);

        if(number1%number2 == 0 || number2%number1 == 0)
        {
            if(number1%number2 == 0)
            {
                question = number1 + "/" + number2;
                System.out.print(question);

                if (readInAnswer().equals(Integer.toString(number1 / number2)))
                {
                    System.out.print("Correct!");
                    System.exit(1);
                }
                else
                {
                    System.out.print("Incorrect!");
                    generateQuestion(1, 200);
                }
            }
            else if (number2%number1 == 0) {
                question = number2 + "/" + number1;
                System.out.print(question);

                if (readInAnswer().equals(Integer.toString(number2 / number1))) {
                    System.out.print("Correct!");
                    System.exit(1);
                } else {
                    System.out.print("Incorrect!");
                    generateQuestion(1, 200);
                }
            }
        }
        else if (number2 >= number1 && equationChooser > 50 && equationChooser <= 100)
        {
            question = number2 + "-" + number1;
            System.out.print(question);
            if(readInAnswer().equals(Integer.toString(number2 - number1)))
            {
                System.out.print("Correct!");
                System.exit(1);
            }
            else
            {
                System.out.print("Incorrect!");
                generateQuestion(1, 200);
            }
        }
        else if(number2<=20)
        {
            question = number2 + "*" + number1;
            System.out.print(question);
            if(readInAnswer().equals(Integer.toString(number2 * number1)))
            {
                System.out.print("Correct!");
                System.exit(1);
            }
            else
            {
                System.out.print("Incorrect!");
                generateQuestion(1, 200);
            }
        }
        else if(equationChooser>100 && equationChooser <= 150)
        {
            question = number2 + "+" + number1;
            System.out.print(question);
            if(readInAnswer().equals(Integer.toString(number2 + number1)))
            {
                System.out.print("Correct!");
                System.exit(1);
            }
            else
            {
                System.out.print("Incorrect!");
                generateQuestion(1, 200);
            }
        }
        else
        {
            generateQuestion(1, 200);
        }
    }
}
