//from applied workshop
public class RNG {
    private int minimum;
    private int maximum;

    public RNG() {
        minimum = 0;
        maximum = 0;
    }

    public RNG (int min, int max) {
        minimum = min;
        maximum = max;
    }

    public int getMinimumNumber() {
        return minimum;
    }

    public int getMaximumNumber() {
        return maximum;
    }

    public void setMinimumNumber(int min) {
        minimum = min;
    }

    public void setMaximumNumber(int max) {
        maximum = max;
    }

    public int generateRandomNumber(int minimum, int maximum) {
        int range = (maximum - minimum) + 1;
        int random = (int)(Math.random()*range);
        random = random + minimum;
        return random;
    }
}

