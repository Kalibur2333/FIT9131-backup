import java.util.Scanner;
import java.lang.Math;

public class DartGame 
{


    public static void main(String[] args) 
    {
        //Player player = new Player();
        //System.out.println(player);
        Input input = new Input();
        Validation validation = new Validation();
        DartGame dartGame = new DartGame();       

        Player player = new Player();
        Player dartVader = new Player("Dart Vader", 0);
        DartThrow dartThrow = new DartThrow();

        //###Display the welcome message###
        dartGame.displayWeclomeMessage();
        //DartGame.inputPlayerName();
        String name = "";
        //###Require player name###
        System.out.println("Your Name Should Contain Only LowerCase.");
        System.out.println("Your Name Should Contain Only 8 Characters.");
        System.out.println("Enter name:");
        name = input.accepStringInput();
        //###Validate the name input###
        while (!validation.isValidName(name))
        {
            System.out.println("Enter valid name:");
            name = input.accepStringInput();
        }
        //System.out.println("Enter name:");
        //name = input.accepStringInput();
        //###Set player###
        System.out.println("Welcome, " + name);
        player.setName(name);
        
        //###Start game###
        //###Check if player continue or not###
        boolean anotherRound = false;
        while (!anotherRound) 
        {
            //###Choose number of throws###
            int round = dartGame.roundChoose();

            //###Start one round###
            dartGame.playRound(round);

            //###After game ask if to quit###
            System.out.println("--------------------------");
            System.out.println("Enter Q to Quit the game.");
            System.out.println("Enter Any Key to Continue.");
            Scanner scanner = new Scanner(System.in);
            String playerInput = scanner.nextLine();

            if (playerInput.equals("Q")|| playerInput.equals("q"))
            {
                System.out.println("@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("      GameOver");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@");
                anotherRound = true;
                break;
            }
            
        }
    }

    private void displayWeclomeMessage()
    {
        System.out.println("@@@ Welcome to Dart Game @@@");
    }

    /*private void inputPlayerName()
    {

    }*/
    //###Choose number of throws###
    private int roundChoose()
    {
        Input input = new Input();
        Validation validation = new Validation();
        String roundChooseS = "";
        int roundChoose = 0;
        /*while (!validation.isValidThrow(throwNum))
        {
            int round = input.accepIntegerInput();
        }*/
        System.out.println("Please Enter the Number of Throws: ");
        System.out.println("The Input Must be Integer from 1-5. ");
        //###This method is searched online###
        //###Using accepIntegerInput will cause crush when input characters###
        roundChooseS = input.accepStringInput();
        try
        {
            roundChoose = Integer.parseInt(roundChooseS);
        } 
        catch (NumberFormatException e) 
        {
            System.out.println("Enter Valid Integer");
        }
        while (!validation.isValidThrow(roundChoose))
        {
            System.out.println("Enter Valid Number:");
            roundChooseS = input.accepStringInput();
            try
            {
                roundChoose = Integer.parseInt(roundChooseS);
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Enter Valid Integer");
            }
        }
        return roundChoose;
    }

    //###Start a new game###
    private void playRound(int round)
    {
        Player player = new Player();
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        int resultVader = 0;
        player.setResult(0);
        player.setScore(0);
        //###Check if abandon this game###
        boolean abandonGame = false;
        while (!abandonGame)
        {
            for (int roundNum = 1; roundNum <= round; roundNum ++)
            {
                System.out.println("------------------------------");
                System.out.println("Press Any Key to Start Throw.");
                System.out.println("Press 'A' to Abandon the Game.");
                System.out.println("------------------------------");
                String input = scanner.nextLine();
                if (input.equals('A')|| input.equals("a"))
                {
                abandonGame = true;
                break;
                }
                result += currentRound(round);
                player.setResult(result);
                resultVader += currentRoundVader(round);
                player.setResultVader(resultVader);
            }
            break;
        }

        System.out.println("@@@ Your Final Result:  " + result + " Points. @@@");
        System.out.println("@@@ DartVader's Result: " + resultVader + " Points. @@@");
        if (result > resultVader)
        {
            System.out.println("$$$$$ YOU WIN $$$$$");
        }
        else if (result < resultVader)
        {
            System.out.println("$$$$$ *Loser* $$$$$");
        }
        else
        {
            System.out.println("$$$$$ *DRAW* $$$$$");
        }
    }

    //###One throw for player###
    private int currentRound(int round)
    {
        Player player = new Player();
        DartGame dartGame = new DartGame(); 
        int score = dartGame.playGame();
        System.out.println("@@@@@ You Got:       " + score + " Points. @@@@@");
        player.setScore(score);
        return score;
    }

    //###One throw for dartVader###
    //###Include random abandon###
    private int currentRoundVader(int round)
    {
        DartThrow dartThrow = new DartThrow();
        double vaderAbandom = dartThrow.generateRandomNumber(0,100);
        int scoreVader = 0;
        if (vaderAbandom <=5)
        {
            System.out.println("@@@@@ DartVader Abandoned the Game. @@@@@");
        }
        else
        {
            Player player = new Player();
            DartGame dartGame = new DartGame(); 
            scoreVader = dartGame.playGame();
            player.setScoreVader(scoreVader);
            System.out.println("@@@@@ DartVader Got: " + scoreVader + " Points. @@@@@");
        }
        return scoreVader;
    }

    //###Rules of score###
    private int playGame()
    {
        boolean onBoard = false;
        DartThrow dartThrow = new DartThrow();
        int score = 0;
        double onBoardChance = dartThrow.generateRandomNumber(0,100);
        if (onBoardChance <= Math.PI/4*100)
        {
            score = 0;
        }
        else
        {
            double landChance = dartThrow.generateRandomNumber(0,100);
            if (landChance <= 4)
            {
                score = 5;
            }
            else if (landChance > 4 && landChance <= (4+16))
            {
                score = 2;
            }
            else
            {
                score = 1;
            }
        }
        return score;
    }
}

