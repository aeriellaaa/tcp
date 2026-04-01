import java.util.LinkedHashSet;

public class tcp {

    public static void main(String[] args) {

        // UC5: LinkedHashSet to preserve insertion order with uniqueness
        LinkedHashSet<String> trainFormation = new LinkedHashSet<>();

        // Add bogies in attachment order
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");
        trainFormation.add("Sleeper"); // duplicate - will be ignored

        System.out.println("=== Train Consist Management App ===");
        System.out.println("\n[UC5] Train Formation using LinkedHashSet:");
        System.out.println("\nFinal Train Formation (Insertion Order Preserved): " + trainFormation);
        System.out.println("Total Bogies in Formation: " + trainFormation.size());
    }
}