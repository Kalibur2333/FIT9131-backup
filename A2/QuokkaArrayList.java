import java.util.ArrayList;

public class QuokkaArrayList {

    private ArrayList<Quokka> quokkaArrayList;
    //constructor
    public QuokkaArrayList()
    {
        quokkaArrayList = new ArrayList<>();
    }
    //get ArrayList
    public ArrayList<Quokka> getQuokkaArrayList()
    {
        return quokkaArrayList;
    }
    //add new quokka to ArrayList
    public void generateQuokka(String id, boolean hasBaby)
    {
        Quokka quokka = new Quokka(id, hasBaby);
        quokkaArrayList.add(quokka);
    }
    //get the quokka number (not include babies)
    public int numOfQuokka()
    {
        return quokkaArrayList.size();
    }
    //get live quokka number
    public int numOfLives()
    {
        int i = 0;
        for (Quokka each : quokkaArrayList)
        {
            if (each.isAlive())
            {
                i ++;
                if (each.hasBaby())
                    i++;
            }
        }
        return i;
    }
    //swap the quokka sequence by food 
    public void sortQuokka() 
    {
        int n = quokkaArrayList.size();
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (quokkaArrayList.get(j).getFoodSupply() < quokkaArrayList.get(min_idx).getFoodSupply())
                    min_idx = j;
            Quokka temp = quokkaArrayList.get(min_idx);
            quokkaArrayList.set(min_idx, quokkaArrayList.get(i));
            quokkaArrayList.set(i, temp);
        }
    }
    //get number of babies
    public int numOfBaby()
    {
        int baby = 0;
        for (Quokka each : quokkaArrayList)
        {
            if (each.hasBaby())
                baby ++;
        }
        return baby;
    }
    //return consumed food, check food status for dying quokka, set 0 food incase below 0
    public int eatPerDay() 
    {
        int food = 0;
        for (Quokka each : quokkaArrayList) 
        {
            if (each.hasBaby()) 
            {
                if (each.getFoodSupply() == 0) {
                    each.setNoFoodDays(each.getNoFoodDays() + 1);
                } else if (each.getFoodSupply() > 0 && each.getFoodSupply() < 3) {
                    each.setNoEnoughFoodDays(each.getNoEnoughFoodDays() + 1);
                    each.setFoodSupply(0);
                    food += each.getFoodSupply();
                } else {
                    each.setFoodSupply(each.getFoodSupply() - 3);
                    food += 3;
                }
            } 
            else 
            {
                if (each.getFoodSupply() == 0) {
                    each.setNoFoodDays(each.getNoFoodDays() + 1);
                } else if (each.getFoodSupply() == 1) {
                    each.setNoEnoughFoodDays(each.getNoEnoughFoodDays() + 1);
                    each.setFoodSupply(0);
                    food += each.getFoodSupply();
                } else {
                    each.setFoodSupply(each.getFoodSupply() - 2);
                    food += 2;
                }
            }
        }
        return food;
    }
    //get death number
    public int checkDead()
    {
        int death = 0;
        for (int i = 0; i < quokkaArrayList.size(); i ++)
        {
            if (quokkaArrayList.get(i).getNoFoodDays() >= 2 || quokkaArrayList.get(i).getNoEnoughFoodDays() >=5)
            {
                if (quokkaArrayList.get(i).hasBaby()){
                    quokkaArrayList.remove(i);
                    death += 2;
                } else {
                    quokkaArrayList.remove(i);
                    death ++;
                }
                i --;
            }
        }
        return death;
    }
    //get new born number
    public int checkBorn() 
    {
        int born = 0;
        for (Quokka each : quokkaArrayList) {
            if (!each.hasBaby()) {
                if (Math.random() <= 0.05) {
                    each.setHasBaby(true);
                    born++;
                }
            }
        }
        return born;
    }
    //get one to Quokka
    public Quokka getQuokkaInArrayList(int i)
    {
        return quokkaArrayList.get(i);
    }
}
