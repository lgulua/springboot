public abstract class F1Vehicle {

    protected String teamName;
    protected double maxSpeed=350;

    public F1Vehicle() {
        this.maxSpeed = maxSpeed;
    }



    public String getTeamName() {
        return teamName;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public abstract void displayStats();
}
