//This code is in RNG.java that I made in applied class.
import java.util.Random;

public class DartThrow 
{
    private int minimum;
    private int maximum;

    public DartThrow()
    {
        minimum = 0;
        maximum = 0;
    }

    public DartThrow (int min, int max)
    {
        minimum = min;
        maximum = max;
    }

    public int getMinimumNumber()
    {
        return minimum;
    }

    public int getMaximumNumber()
    {
        return maximum;
    }

    public void setMinimumNumber(int min)
    {
        minimum = min;
    }

    public void setMaximumNumber(int max)
    {
        maximum = max;
    }

    public double generateRandomNumber(int minimum, int maximum)
    {
        int range = (maximum - minimum) + 1;
        double random = (double)(Math.random()*range);
        random = random + minimum;
        return random; 
    }    
}

