import java.lang.reflect.Type;

public class TouristGroup {
    private int size;
    private String type;
    private boolean selfieTaken;
    //defualt constructor, set defualt selfie taken as false.
    public TouristGroup() 
    {
        this.size = groupSize();
        this.type = selfieType();
        selfieTaken = false;
    }
    //generate size for each group
   public int groupSize()
   {
       RNG rng = new RNG();
       int random = rng.generateRandomNumber(1, 10);
       if (random <= 3) {
           size = 1;
       } else if (random <= 6) {
           size = 2;
       } else if (random <= 7) {
           size = 3;
       } else if (random <= 8) {
           size = 4;
       } else if (random <= 9) {
           size = 5;
       } else {
           size = 6;
       }
       return size;
   }
    //generate selfie types.
   public String selfieType()
   {
       RNG rng = new RNG();
       int random = rng.generateRandomNumber(1, 100);
       if (size == 1)
       {
           if (random <= 60)
               type = "IndividualPhoto";

           else if (random <= 96)
               type = "IndividualVideo";

           else
               type = "IndividualSketch";

       } else {
           boolean regenerate = true;
           while (regenerate)
           {
               if (random <= 60){
                   type = "GroupPhoto";
                   regenerate = false;
               }
               else if (random <= 95) {
                   type = "GroupVideo";
                   regenerate = false;
               }
               else {
                   random = rng.generateRandomNumber(1, 100);
               }
           }
       }
       return type;
   }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public boolean isSelfieTaken() {
        return selfieTaken;
    }

    public void setSelfieTaken(boolean selfieTaken) {
        this.selfieTaken = selfieTaken;
    }
}
