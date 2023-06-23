import java.util.Random;
import java.util.Scanner;
public class Guessing{
    static int var,no_of_guess=10,userguess=0;
    Guessing()
    {
        Random rand = new Random();
        var = rand.nextInt(101);
        //System.out.println(var);
    }
    public static int verifier(int n)
    {
        if(var==n)
            return 1;
        else if (var>n) {
            return 2;
        }
        else
            return 3;
    }
    public static void main(String args[])
    {
        Guessing j = new Guessing();
        Scanner sc = new Scanner(System.in);
        int number;
        System.out.println("Guess the number!! ");
        while(no_of_guess != 0)
        {
            System.out.println("Enter your guess (1-100) :- ");
            number=sc.nextInt();
            int veri=verifier(number);
            if(veri==1)
            {
                System.out.println("Congratulations!! You are correct");
                no_of_guess--;
                userguess++;
                System.out.println("The number of guesses you required :- "+userguess);
                System.out.println("Score :- "+(no_of_guess+1)+"/10");
                break;
            }
            else if (veri==2)
            {
                System.out.println("Wrong...guess higher");
                no_of_guess--;
                userguess++;
            }
            else if(veri==3)
            {
                System.out.println("Wrong...guess lower");
                no_of_guess--;
                userguess++;
            }
        }
        if(no_of_guess==0)
            System.out.println("Game Over");
    }

}