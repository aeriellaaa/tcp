import java.util.HashSet;

public class tcp {

    public static void main(String[] args) {

        // UC3: HashSet to track unique bogie IDs
        HashSet<String> bogieIds = new HashSet<>();

        // Add bogie IDs including duplicates
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        // Display results
        System.out.println("=== Train Consist Management App ===");
        System.out.println("\n[UC3] Tracking Unique Bogie IDs using HashSet:");
        System.out.println("\nBogie IDs Registered (Duplicates Ignored): " + bogieIds);
        System.out.println("Total Unique Bogies: " + bogieIds.size());
    }
}