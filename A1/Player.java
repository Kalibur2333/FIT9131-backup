public class Player
{
    //fields
    private String name;
    private int score;
    private int result;
    private int scoreVader;
    private int resultVader;

    //defualt constructor
    public Player()
    {
        name = "player";
        score = 0;
    }

    //non-defualt constructor
    public Player(String name, int score)
    {
        this.name = name;
        this.score = score;
    }

    //accessor&mutator
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    /*private boolean nameCheck(String name)
    {
        if(name.length() < 9)
        {
            for(int i = 0; i<name.length(); i ++)
            {
                if(Character.isLowerCase(name.charAt(i)))
                this.name = name;
                return true;
            }
            return false;
        }
        else
        {
            return false;
        }
    }*/

    public int getScore()
    {
        return score;
    }
    public void setScore(int score)
    {
        this.score = score;
    }
    public int getResult()
    {
        return result;
    }
    public void setResult(int result)
    {
        this.result = result;
    }
    public int getScoreVader()
    {
        return scoreVader;
    }
    public void setScoreVader(int scoreVader)
    {
        this.scoreVader = scoreVader;
    }
    public int getResultVader()
    {
        return resultVader;
    }
    public void setResultVader(int resultVader)
    {
        this.resultVader = resultVader;
    }

    //test

    public String toString()
    {
        return "Player: " + name + "\nScore: "+ score;
    }
}
