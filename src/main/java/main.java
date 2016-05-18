import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;


public class main {
    /*
    Everything gets called through this process when the alarm is triggered at the time set.
    Possible mode select via user input of easy/ hard. Use if statements to change random number range depending on what is picked.
    */
    private static String question;
    private static int answer;
    private static Random random = new Random();

    public static void main(String[] args) throws IOException
    {
        generateQuestion(1, 200);
    }


    private static String readInAnswer() throws IOException{
        /*
        This method should read the users answer from the text box and it will be submitted when they press the button to turn off the alarm.
        */
        BufferedReader takeAnswerProvided = new BufferedReader(new InputStreamReader(System.in));
        String userAnswer = takeAnswerProvided.readLine();
        return userAnswer;
    }
    private static void generateQuestion(int min, int max) throws IOException
    {
        int number1 = random.nextInt(max - min + 1) + min;
        int number2 = random.nextInt(max - min + 1) + min;
        int equationChooser = random.nextInt(max - min + 1) + min;
        System.out.println("X is:" + number1 + " Y is:" + number2 + " Z is: " + equationChooser);

        if(number1%number2 == 0 || number2%number1 == 0)
        {
            if(number1%number2 == 0)
            {
                question = number1 + "/" + number2 + "=";
                System.out.print(question);

                if (readInAnswer().equals(Integer.toString(number1 / number2)))
                {
                    correctAnswer();
                    /*
                    Insert code to turn off the alarm here.
                     */

                }
                else
                {
                    answer = number1 / number2;
                    incorrectAnswer();
                    /*
                    Generates new question (question select may need altering.)
                    */
                }
            }
            else if (number2%number1 == 0) {
                question = number2 + "/" + number1 + "=";
                System.out.print(question);

                if (readInAnswer().equals(Integer.toString(number2 / number1)))
                {
                    correctAnswer();
                    /*
                    Insert code to turn off the alarm here.
                     */
                } else
                {
                    answer = number2/number1;
                    incorrectAnswer();
                    /*
                    Generates new question (question select may need altering.)
                     */
                }
            }
        }
        else if (number2 >= number1 && equationChooser > 50 && equationChooser <= 100)
        {
            question = number2 + "-" + number1 + "=";
            System.out.print(question);
            if(readInAnswer().equals(Integer.toString(number2 - number1)))
            {
                correctAnswer();
                /*
                Insert code to turn off the alarm here.
                */
            }
            else
            {
                answer = number2 - number1;
                incorrectAnswer();
                /*
                Generates new question (question select may need altering.)
                 */
            }
        }
        else if(number2<=20)
        {
            question = number2 + "*" + number1 + "=";
            System.out.print(question);
            if(readInAnswer().equals(Integer.toString(number2 * number1)))
            {
                correctAnswer();
                /*
                Insert code to turn off the alarm here.
                */
            }
            else
            {
                answer = number2 * number1;
                incorrectAnswer();
                /*
                Generates new question (question select may need altering.)
                 */
            }
        }
        else if(equationChooser>100 && equationChooser <= 150)
        {
            question = number2 + "+" + number1 + "=";
            System.out.print(question);
            if(readInAnswer().equals(Integer.toString(number2 + number1)))
            {
                correctAnswer();
                /*
                Insert code to turn off the alarm here.
                */
            }
            else
            {
                answer = number2 + number1;
                incorrectAnswer();
                /*
                Generates new question (question select may need altering.)
                 */
            }
        }
        else
        {
            generateQuestion(1, 200);
        }
    }

    public static void correctAnswer()
    {
        System.out.print("Correct!");
        /*
        Turn off the alarm at this point.
         */
        System.exit(1);

    }

    public static void incorrectAnswer() throws IOException
    {
        System.out.println("Incorrect! The answer was " + answer + ". Here's another.");
        /*
        Do not turn off the alarm and generate a new question.
         */
        generateQuestion(1, 200);
    }
}
