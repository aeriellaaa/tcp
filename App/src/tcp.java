import java.util.ArrayList;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // UC2: ArrayList Operations for Passenger Bogies
        ArrayList<String> passengerBogies = new ArrayList<>();

        // Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Display after insertion
        System.out.println("=== Train Consist Management App ===");
        System.out.println("\n[UC2] Passenger Bogies Added to Train:");
        System.out.println("Passenger Bogies: " + passengerBogies);

        // Remove a bogie
        passengerBogies.remove("AC Chair");
        System.out.println("\nAfter Removing AC Chair:");
        System.out.println("Passenger Bogies: " + passengerBogies);

        // Check existence
        boolean sleeperExists = passengerBogies.contains("Sleeper");
        System.out.println("\nIs Sleeper bogie present? " + sleeperExists);

        // Final list state
        System.out.println("\nFinal Consist:");
        System.out.println("Passenger Bogies: " + passengerBogies);
    }
}