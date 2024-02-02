public class GroupVideo extends Selfie {
    public static final String TYPE = "GroupVideo";

    private int time;

    public GroupVideo() {
        super(TYPE);
        time = new RNG().generateRandomNumber(1, 60);
    }

    public int getTime() {
        return time;
    }
}
