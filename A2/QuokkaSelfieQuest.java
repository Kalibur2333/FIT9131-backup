import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuokkaSelfieQuest {

    int totalBags;
    int totalDead;
    int totalBorn;
    int atEnd;

    int quokkaPopulation;

    public static void main(String[] args) {

        QuokkaSelfieQuest main = new QuokkaSelfieQuest();
        QuokkaArrayList quokkaArrayList = new QuokkaArrayList();
        Scanner scanner = new Scanner(System.in);

        FileIO fileIO = new FileIO();
        //welcome message
        main.welcomeMessage();
        //read tourist.txt
        ArrayList<Integer> days = fileIO.readFile();
        //Input quokka population
        int population = main.inputQuokkaPopulation();
        //Generate every quokka
        quokkaArrayList = main.generateQuokka(population);
        System.out.println("Total Quokkas: " + quokkaArrayList.numOfQuokka());
        System.out.println("Total Babies: " + quokkaArrayList.numOfBaby());
        //simulate 30 days
        for (int i = 0; i < days.size(); i++){
            int currentDay = i + 1;
            int numOfGroups = days.get(i);
            TouristGroup touristGroup = new TouristGroup();
            TouristArrayList touristArrayList = new TouristArrayList(numOfGroups);
            main.simulation(currentDay, quokkaArrayList, numOfGroups, new TouristArrayList(numOfGroups));
            System.out.println("Press Enter to next day");
            String input = scanner.nextLine();
        }
        //displayFinalSummary and write out
        main.displayFinalSummary();

    }
    //welcome message
    public void welcomeMessage()
    {
        System.out.println("Welcome Message");
    }
    //accept input for quokkas population
    public int inputQuokkaPopulation()
    {
        Validation validation = new Validation();
        Input input = new Input();
        System.out.println("Enter the number of quokka: ");
        int inputNum;
        inputNum = input.accepIntegerInput();
        while (!validation.inputValidation(inputNum))
        {
            try
            {
                System.out.println("Invalid Number. Enter a valid number: ");
                inputNum = input.accepIntegerInput();
            }
            catch ( Exception e)
            {
                System.out.println(e);
            }
        }
        quokkaPopulation = inputNum;
        return quokkaPopulation;
    }
    //generate quokkas and ArrayList
    public QuokkaArrayList generateQuokka(int population)
    {
        QuokkaArrayList quokkaArrayList = new QuokkaArrayList();
        for (int i = 0; i < population; i ++)
        {
            String id = generateId(quokkaArrayList);
            boolean hasBaby = isHasBaby();
            quokkaArrayList.generateQuokka(id, hasBaby);
        }
        return quokkaArrayList;
    }
    //generate id for each
    public String generateId(QuokkaArrayList quokkaArrayList)
    {
        int idNum = 1;
        String id = "";
        while(true)
        {
            id = String.format("Q%03d", idNum);
            boolean isExist = false;
            for (int i = 0; i < quokkaArrayList.numOfQuokka(); i ++)
            {
                if(id.equals(quokkaArrayList.getQuokkaArrayList().get(i).getId()))
                {
                    isExist = true;
                    break;
                }
            }
            if(!isExist)
                break;
            idNum ++;
        }
        return id;
    }
    //set baby 
    public boolean isHasBaby()
    {
        RNG rng = new RNG();
        int percentage = rng.generateRandomNumber(1,100);
        if (percentage <=20)
        {
            return true;
        } else {
            return false;
        }
    }
    //simulate one day
    public void simulation(int day, QuokkaArrayList quokkaArrayList, int numOfGroup,
                           TouristArrayList touristArrayList)
    {
        QuokkaSelfieQuest main = new QuokkaSelfieQuest();
        System.out.println("*** Day #" + day + "***");
        System.out.println("Current alive quokkas (incl babies): " + quokkaArrayList.numOfLives());
        System.out.println("Current total food bags: " + totalBags);
        System.out.println("Sorting the quokkas based on their level of food supply");
        quokkaArrayList.sortQuokka();
        System.out.println("Number of tourist groups: " + numOfGroup);
        System.out.println("Initialising the tourist groups");
        touristArrayList = new TouristArrayList(numOfGroup);
        System.out.println("Quokkas are now offering selfies to the tourist groups");
        System.out.println("------------------------------------------------------");
        System.out.println("Selfie Stats");
        System.out.println("============");
        System.out.println("Group Video:" + touristArrayList.countGroupVideo());
        System.out.println("Group Photo:" + touristArrayList.countGroupPhoto());
        System.out.println("individual Photo:" + touristArrayList.countPhoto());
        System.out.println("individual Video:" + touristArrayList.countVideo());
        System.out.println("individual Sketch:" + touristArrayList.countSketch());
        System.out.println("(Total selfies)" + touristArrayList.countPhoto() + touristArrayList.countVideo()
                + touristArrayList.countSketch() + ")");
        int oneDayConsume = quokkaArrayList.eatPerDay();
        int oneDayEarn = main.selfieSimulation(quokkaArrayList, touristArrayList);
        System.out.println("Earned food bags:" + oneDayEarn);
        totalBags += oneDayEarn - oneDayConsume;
        System.out.println("------------------------------------------------------");
        System.out.println("Daily Summary");
        System.out.println("=============");
        System.out.println("Live quokkas: " + quokkaArrayList.numOfLives());
        int deathNum = quokkaArrayList.checkDead();
        totalDead += deathNum;
        System.out.println("Quokkas died today: " + deathNum);
        int bornNum = quokkaArrayList.checkBorn();
        totalBorn += bornNum;
        System.out.println("New baby today: " + bornNum);
        System.out.println("Consumed food bags: " + oneDayConsume);
        System.out.println("Current food bags: " + totalBags);
        atEnd = quokkaArrayList.numOfLives();
        System.out.println("*****************************************************");
    }
    //display Summary and write out
    private void displayFinalSummary() {
        double qsqsf = (1 - ((double) totalDead / atEnd)) * 100;
        double qpsf = ((double) (atEnd - quokkaPopulation)) / quokkaPopulation;

        String msg1 = "Quokka Selfie Quest Success Factor(QSQSF): " + qsqsf;
        String msg2 = "Quokka Population Sustainability Factor (QPSF): " + qpsf;
        String msg3 = "Number of days where quokkas died through lack of food: " + totalDead;

        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println(msg3);

        try {
            String outFileName = "populationFinal.txt";
            new File(outFileName).createNewFile();
            FileWriter writer = new FileWriter(outFileName);
            writer.write(msg1 + "\n");
            writer.write(msg2 + "\n");
            writer.write(msg3 + "\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //return Earned food, set each quokka food, set each group isSelfieTaken.
    public int selfieSimulation(QuokkaArrayList quokkaArrayList, TouristArrayList touristArrayList)
    {
        int bags = 0;
        RNG rng = new RNG();
        int time;
        int pose;
        QuokkaSelfieQuest main = new QuokkaSelfieQuest();
        TouristGroup touristGroup = new TouristGroup();
        Quokka quokka = new Quokka();
        if (quokkaArrayList.numOfQuokka() >= touristArrayList.getNumOfGroup()) {
            for (int i = 0; i < quokkaArrayList.numOfQuokka(); i++) {
                for (int j = 0; j < touristArrayList.getNumOfGroup(); j++) {
                    if (!touristArrayList.getOne(j).isSelfieTaken()) {
                        if (touristArrayList.getOne(j).getSize() == 1) {
                            if (IndividualPhoto.TYPE.equals(touristArrayList.getOne(j).getType())) {
                                bags += 1;
                                quokkaArrayList.getQuokkaInArrayList(i).getPayment(1);
                                touristArrayList.getOne(j).setSelfieTaken(true);
                            } else if (IndividualVideo.TYPE.equals(touristArrayList.getOne(j).getType())) {
                                time = rng.generateRandomNumber(1,60);
                                bags += time / 20;
                                quokkaArrayList.getQuokkaInArrayList(i).getPayment(time / 20);
                                touristArrayList.getOne(j).setSelfieTaken(true);
                            } else {
                                pose = rng.generateRandomNumber(1,2);
                                if (pose == 1)
                                {
                                    bags += 6;
                                    quokkaArrayList.getQuokkaInArrayList(i).getPayment(6);
                                    touristArrayList.getOne(j).setSelfieTaken(true);
                                }
                                else {
                                    bags += 10;
                                    quokkaArrayList.getQuokkaInArrayList(i).getPayment(10);
                                    touristArrayList.getOne(j).setSelfieTaken(true);
                                }
                            }
                        } else {
                            if (GroupPhoto.TYPE.equals(touristArrayList.getOne(j).getType())) {
                                bags += 2;
                                quokkaArrayList.getQuokkaInArrayList(i).getPayment(2);
                                touristArrayList.getOne(j).setSelfieTaken(true);
                            } else if (GroupVideo.TYPE.equals(touristArrayList.getOne(j).getType())) {
                                time = rng.generateRandomNumber(1,60);
                                bags += time / 20 * 2;
                                quokkaArrayList.getQuokkaInArrayList(i).getPayment(time / 20 * 2);
                                touristArrayList.getOne(j).setSelfieTaken(true);
                            }
                        }
                    }
                }
            }
        } else {
            int i = 0;
            for (int j = 0; j < touristArrayList.getNumOfGroup(); j++)
            {
                if (i < quokkaArrayList.numOfQuokka())
                {
                    if (!touristArrayList.getOne(j).isSelfieTaken()) {
                        if (touristArrayList.getOne(j).getSize() == 1) {
                            if (IndividualPhoto.TYPE.equals(touristArrayList.getOne(j).getType())) {
                                bags += 1;
                                quokkaArrayList.getQuokkaInArrayList(i).getPayment(1);
                                touristArrayList.getOne(j).setSelfieTaken(true);
                            } else if (IndividualVideo.TYPE.equals(touristArrayList.getOne(j).getType())) {
                                time = rng.generateRandomNumber(1,60);
                                bags += time / 20;
                                quokkaArrayList.getQuokkaInArrayList(i).getPayment(time / 20);
                                touristArrayList.getOne(j).setSelfieTaken(true);
                            } else {
                                pose = rng.generateRandomNumber(1,2);
                                if (pose == 1)
                                {
                                    bags += 6;
                                    quokkaArrayList.getQuokkaInArrayList(i).getPayment(6);
                                    touristArrayList.getOne(j).setSelfieTaken(true);
                                }
                                else {
                                    bags += 10;
                                    quokkaArrayList.getQuokkaInArrayList(i).getPayment(10);
                                    touristArrayList.getOne(j).setSelfieTaken(true);
                                }
                            }
                        } else {
                            if (GroupPhoto.TYPE.equals(touristArrayList.getOne(j).getType())) {
                                bags += 2;
                                quokkaArrayList.getQuokkaInArrayList(i).getPayment(2);
                                touristArrayList.getOne(j).setSelfieTaken(true);
                            } else if (GroupVideo.TYPE.equals(touristArrayList.getOne(j).getType())) {
                                time = rng.generateRandomNumber(1,60);
                                bags += time / 20 * 2;
                                quokkaArrayList.getQuokkaInArrayList(i).getPayment(time / 20 * 2);
                                touristArrayList.getOne(j).setSelfieTaken(true);
                            }
                        }
                    }
                    i ++;
                }
                else i = 0;
            }
        }
        return bags;
    }

}
