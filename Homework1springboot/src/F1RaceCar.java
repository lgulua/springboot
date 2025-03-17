public class F1RaceCar extends F1Car implements TelemetrySystem {

    private boolean drsEnabled;

    public F1RaceCar(String teamName) {

        this.drsEnabled = false;
    }

    public F1RaceCar() {
        super();
    }

    public void enableDRS() {
        if (!drsEnabled) {
            drsEnabled = true;
            System.out.println(getTeamName() + " DRS enabled!");
        } else {
            System.out.println(getTeamName() + " DRS is already enabled.");
        }
    }

    public void disableDRS() {
        if (drsEnabled) {
            drsEnabled = false;
            System.out.println(getTeamName() + " DRS disabled.");
        } else {
            System.out.println(getTeamName() + " DRS is already disabled.");
        }
    }

    @Override
    public void accelerate(double amount) {
        if (drsEnabled&&getFuelLevel()>0) {
            amount *= 1.5;
            System.out.println(getTeamName() + " is using DRS! Acceleration boosted by 50%.");
        }
        super.accelerate(amount);

    }

    @Override
    public void printCarDetails() {
        super.printCarDetails();
        System.out.println("DRS Enabled: " + drsEnabled);
        System.out.println("=================================");
    }

    @Override
    public void sendData(String data) {
        System.out.println(getTeamName() + " sending telemetry data: " + data);
    }

    @Override
    public void receiveData() {
        String message = "Telemetry data received for " + getTeamName() + ": Speed=" + getSpeed() + " km/h, Fuel=" + getFuelLevel() + "%";
        System.out.println(message);
    }

    @Override
    public void analyzePerformance() {
        System.out.println("Analyzing performance for " + getTeamName());
        if (getSpeed() > 300) {
            System.out.println("Warning: " + getTeamName() + " is exceeding optimal speed limits!");
        } else if (getFuelLevel() < 20) {
            System.out.println(getTeamName() + " needs to refuel soon!");
        } else {
            System.out.println(getTeamName() + " everything is ok go team !" + getTeamName());
        }
    }

    public static void main(String[] args) {
        F1RaceCar ferrari = new F1RaceCar();
        ferrari.setTeamName("Ferrari");

        ferrari.startEngine();
        ferrari.accelerate(100);
        ferrari.enableDRS();
        ferrari.accelerate(150);

        ferrari.sendData("data");
        ferrari.receiveData();
        ferrari.analyzePerformance();

        ferrari.printCarDetails();
    }
}
