//This code is in rollingproject sample with changes by myself
public class Validation
{
    public Validation()
    {

    }

    public boolean isValidName(String name) 
    {
        boolean isValidName = false;
        if (name.matches("[a-z]{1,8}"))
        {
            isValidName = true;
        }

        return isValidName;
    }

    public boolean isValidThrow(int throwNum)
    {
        boolean isValidThrow = false;
        if (throwNum > 0 && throwNum <= 5)
        {
            isValidThrow = true;
        }

        return isValidThrow;
    }
}
