public class Quokka {

    private String id;
    private boolean hasBaby;
    private int foodSupply;
    private boolean isAlive;
    private int noFoodDays;
    private int noEnoughFoodDays;

    //defualt constructor
    public Quokka()
    {}

    //constructor
    public Quokka (String id, boolean hasBaby)
    {
        this.id = "";
        this.hasBaby = hasBaby;
        if(hasBaby)
            foodSupply = 3;
        else
            foodSupply = 2;
        this.isAlive = true;
    }
    //add food 
    public void getPayment (int payment)
    {
        if (hasBaby)
        {
            this.foodSupply += payment * 2;
        }
        this.foodSupply += payment;
    }
    
    public String getId() {
        return id;
    }

    public boolean hasBaby() {
        return hasBaby;
    }

    public void setHasBaby(boolean hasBaby) {
        this.hasBaby = hasBaby;
    }

    public int getFoodSupply() {
        return foodSupply;
    }

    public void setFoodSupply(int foodSupply) {
        this.foodSupply = foodSupply;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getNoFoodDays() {
        return noFoodDays;
    }

    public void setNoFoodDays(int noFoodDay) {
        this.noFoodDays = noFoodDay;
    }

    public int getNoEnoughFoodDays() {
        return noEnoughFoodDays;
    }

    public void setNoEnoughFoodDays(int noEnoughFood) {
        this.noEnoughFoodDays = noEnoughFood;
    }

    public String toString()
    {
        return id + hasBaby + foodSupply + isAlive;
    }
}
