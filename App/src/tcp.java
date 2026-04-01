import java.util.LinkedList;

public class tcp {

    public static void main(String[] args) {

        // UC4: LinkedList to maintain ordered bogie consist
        LinkedList<String> consist = new LinkedList<>();

        // Add bogies in train order
        consist.add("Engine");
        consist.add("Sleeper");
        consist.add("AC Chair");
        consist.add("Cargo");
        consist.add("Guard");

        System.out.println("=== Train Consist Management App ===");
        System.out.println("\n[UC4] Ordered Train Consist using LinkedList:");
        System.out.println("Initial Consist: " + consist);

        // Insert Pantry Car at position 2
        consist.add(2, "Pantry Car");
        System.out.println("\nAfter Adding Pantry Car at Position 2:");
        System.out.println("Consist: " + consist);

        // Remove first and last
        consist.removeFirst();
        consist.removeLast();
        System.out.println("\nAfter Removing First (Engine) and Last (Guard):");
        System.out.println("Final Consist: " + consist);

        System.out.println("\nTotal Bogies in Consist: " + consist.size());
    }
}