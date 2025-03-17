public class PitStopTeam extends F1RaceCar{

    private final String teamName;
    private int pitStopTime;

    public PitStopTeam(String teamName, int pitStopTime) {
        this.teamName = teamName;
        this.pitStopTime = pitStopTime;
    }

    public void performPitStop(F1Car car) {
        car.refuel();
        car.resetTireCondition();
        System.out.println("Pit stop completed for " + teamName + " in " + pitStopTime + " seconds.");
    }

    public String getTeamName() {
        return teamName;
    }

    public int getPitStopTime() {
        return pitStopTime;
    }

    public void setPitStopTime(int pitStopTime) {
        this.pitStopTime = pitStopTime;
    }


}
