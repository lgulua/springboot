public class F1Car extends F1Vehicle {

    private double speed;
    private double fuelLevel;
    private boolean engineOn;
    private String tireCondition;

    public F1Car() {
        this.fuelLevel = 100.0;
        this.speed = 0.0;
        this.engineOn = false;
        this.tireCondition = "Perfect";
    }



    public String getTireCondition() {
        return tireCondition;
    }
    public double getSpeed() {
        return speed;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }
    public String getTeamName() {
   return super.teamName;    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void startEngine() {

        if (fuelLevel == 0) {
            System.out.println(teamName + " cannot start the engine. Fuel is empty.");
            return;
        }
        if (!engineOn) {
            engineOn = true;
            System.out.println(teamName + " engine started.");
        } else {
            System.out.println(teamName + " engine is already running.");
        }
    }

    public void stopEngine() {
        if (engineOn) {
            engineOn = false;
            speed = 0.0;
            System.out.println(teamName + " engine stopped.");
        } else {
            System.out.println(teamName + " engine is already off.");
        }
    }

    public void accelerate(double amount) {
        if (fuelLevel <= 0) {
            System.out.println(teamName + " has no fuel left. Can't accelerate.");
            return;
        }
        if (!engineOn) {
            System.out.println(teamName + " engine is off. Start the engine first.");
            return;
        }

        if (fuelLevel <= 0) {
            System.out.println(teamName + " has no fuel left. Can't accelerate.");
            return;
        }

        speed += amount;

        if (speed > maxSpeed) {
            speed = maxSpeed;
            System.out.println(teamName + " has reached max speed: " + maxSpeed + " km/h.");
        }

        fuelLevel -= amount * 0.5;

        if (fuelLevel < 0) {
            fuelLevel = 0;
        }
        if (fuelLevel == 0) {
            System.out.println(teamName + " has run out of fuel. The engine shuts down.");
            speed = 0;
            stopEngine();
        }
        System.out.println(teamName + " accelerated by " + amount + " km/h. Current speed: " + speed + " km/h. Fuel level: " + fuelLevel + "%");
    }

    public void brake(double amount) {
        if (!engineOn) {
            System.out.println(teamName + " cannot brake. The engine is off.");
            return;
        }
        speed -= amount;

        if (speed < 0) {
            speed = 0;
        }

        System.out.println(teamName + " braked by " + amount + " km/h. Current speed: " + speed + " km/h.");
    }



    public void calculateLapTime(double trackLength) {
        try {
            if (speed == 0) {
                throw new ArithmeticException("Speed is zero, cannot calculate lap time.");
            } else {
                double lapTime = trackLength / speed;
                System.out.println(teamName + " lap time: " + lapTime + " hours for track length " + trackLength + " km.");
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }



    public void refuel() {
        fuelLevel = 100.0;
        System.out.println(teamName + " has been refueled to 100%.");
    }
    public void resetTireCondition() {
        tireCondition = "Perfect";
        System.out.println(teamName + "'s tire condition reset perfect.");
    }
    public void printCarDetails() {
        System.out.println("= CAR DETAILS =");
        System.out.println("Team Name: " + teamName);
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Fuel Level: " + fuelLevel + "%");
        System.out.println("IS Engine On: " + engineOn);
        System.out.println("==");
    }

    @Override
    public void displayStats() {
        System.out.println("==== F1Car STATS =====");
        System.out.println("Team Name: " + teamName);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Current Speed: " + speed + " km/h");
        System.out.println("Fuel Level: " + fuelLevel + "%");
        System.out.println("====");
    }

    public static void main(String[] args) {
        F1Car ferrariCar = new F1Car();
ferrariCar.setTeamName("Ferrari");
        ferrariCar.startEngine();
        ferrariCar.accelerate(100);
        ferrariCar.brake(50);
        ferrariCar.startEngine();
        ferrariCar.accelerate(100);
        ferrariCar.brake(50);
        ferrariCar.startEngine();
        ferrariCar.accelerate(100);
        ferrariCar.brake(50);
        ferrariCar.startEngine();
        ferrariCar.accelerate(100);
        ferrariCar.brake(50);
        ferrariCar.displayStats();
    }
}
