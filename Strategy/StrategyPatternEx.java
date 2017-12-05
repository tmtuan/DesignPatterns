import java.io.IOException;
import java.util.Scanner;

// IChoice.java
interface IChoice 
{
    void myChoice(String s1, String s2);
}

// FirstChoice.java
class FirstChoice implements IChoice
{
    public void myChoice(String s1, String s2)
    {
        System.out.println("You want to add the number");
        int int1, int2, sum;
        int1 = Integer.parseInt(s1);
        int2 = Integer.parseInt(s2);
        sum = int1 + int2;
        System.out.println("The result of the addition is: " + sum);
        System.out.println("*** End of the strategey ***");
    }
}

// SecondChoice.java
class SecondChoice implements IChoice
{
    public void myChoice(String s1, String s2)
    {
        System.out.println("You wanted to concatenate the numbers."); 
        System.out.println(" The result of the addition is:"+s1+s2); 
        System.out.println("***End of the strategy***");
    }
}

// Context.java
class Context 
{
    IChoice myC;

    // Set a strategy or algorithm in the Context
    public void SetChoice(IChoice ic)
    {
        myC = ic;
    }
    public void ShowChoices(String s1, String s2)
    {
        myC.myChoice(s1, s2);
    }
}

// StrategyPatternEx.java
class StrategyPatternEx 
{
    public static void main(String[] args)
    {
        System.out.println("***Strategy Pattern ***\n");
        Scanner in = new Scanner(System.in); // To take input from user
        IChoice ic = null;
        Context cxt = new Context();
        String input1, input2;

        try
        {
            for(int i = 0; i <= 2; i++)
            {
                System.out.println("Enter an integer: ");
                input1 = in.nextLine();
                System.out.println("Enter another integer: ");
                input2 = in.nextLine();
                System.out.println("Enter your choice (1 or 2)");
                System.out.println("Press 1 for Addition, 2 for Concatenation");
                String c = in.nextLine();

                if(c.equals("1"))
                {
                    /* Strategy 1 */
                    ic = new FirstChoice();
                }
                else 
                {
                    /* Strategy 2 */
                    ic = new SecondChoice();
                }
                cxt.SetChoice(ic);
                cxt.ShowChoices(input1, input2);
            }
        }
        finally
        {
            in.close();
        }
        System.out.println("End of Strategy");
    }
    
}