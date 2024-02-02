public class IndividualSketch extends Selfie {
    public static final String TYPE = "IndividualSketch";

    private int timeOfPose;

    public IndividualSketch() {
        super(TYPE);
        timeOfPose = new RNG().generateRandomNumber(1, 2) * 5;
    }

    public int getTimeOfPose() {
        return timeOfPose;
    }
}