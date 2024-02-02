public class IndividualVideo extends Selfie {
    public static final String TYPE = "IndividualVideo";

    private int time;

    public IndividualVideo() {
        super(TYPE);
        time = new RNG().generateRandomNumber(1, 60);
    }

    public int getTime() {
        return time;
    }
}