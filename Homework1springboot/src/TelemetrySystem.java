public interface TelemetrySystem {
    void sendData(String data);
    void receiveData();
    void analyzePerformance();
}
