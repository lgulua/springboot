public class Main {
    public static void main(String[] args) {
        F1Car[] cars = new F1Car[3];
       cars[0] = new F1Car();
       cars[1] = new F1Car();
       cars[2] = new F1RaceCar();


        F1Car car1 = cars[0];
        F1Car car2 = cars[1];
        F1RaceCar car3 = (F1RaceCar) cars[2];
        car2.setTeamName("Mercedes");
        car1.setTeamName("BMW");
        car3.setTeamName("Ferrari");

        PitStopTeam pitTeam1 = new PitStopTeam("Mercedes Pit Crew", 5);
        PitStopTeam pitTeam2 = new PitStopTeam("BMW Pit Crew", 6);
        PitStopTeam pitTeam3 = new PitStopTeam("Ferrari Pit Crew", 4);




                car1.startEngine();
                car2.startEngine();
                car3.startEngine();
                car1.accelerate(100);
                car2.accelerate(120);
                car3.accelerate(130);
                car3.enableDRS();
                car1.brake(30);
                car2.brake(50);
                car3.accelerate(50);

                System.out.println("Pit Stops");
                pitTeam1.performPitStop(car1);
                pitTeam2.performPitStop(car2);
                pitTeam3.performPitStop(car3);

                System.out.println("Final Stats");
                car1.displayStats();
                car2.displayStats();
                car3.displayStats();

                System.out.println("Lap Times");
                car1.calculateLapTime(500);
                car2.calculateLapTime(500);
                car3.calculateLapTime(500);


            }
        }



