import java.util.ArrayList;
import java.util.List;

public class tcp {

    static abstract class Bogie {
        protected String bogieId;
        protected String bogieType;

        public Bogie(String bogieId, String bogieType) {
            this.bogieId = bogieId;
            this.bogieType = bogieType;
        }

        public String getBogieId() {
            return bogieId;
        }

        public String getBogieType() {
            return bogieType;
        }

        public abstract String getSummary();
    }

    static abstract class PassengerBogie extends Bogie {
        protected int totalSeats;
        protected int bookedSeats;

        public PassengerBogie(String bogieId, String bogieType, int totalSeats) {
            super(bogieId, bogieType);
            this.totalSeats = totalSeats;
            this.bookedSeats = 0;
        }

        public int getAvailableSeats() {
            return totalSeats - bookedSeats;
        }

        @Override
        public String getSummary() {
            return String.format("  [%s] Type: %-12s | Seats: %d Total, %d Booked, %d Available",
                    bogieId, bogieType, totalSeats, bookedSeats, getAvailableSeats());
        }
    }

    static class SleeperBogie extends PassengerBogie {
        public SleeperBogie(String bogieId) {
            super(bogieId, "Sleeper", 72);
        }
    }

    static class ACChairBogie extends PassengerBogie {
        public ACChairBogie(String bogieId) {
            super(bogieId, "AC Chair", 78);
        }
    }

    static class FirstClassBogie extends PassengerBogie {
        public FirstClassBogie(String bogieId) {
            super(bogieId, "First Class", 18);
        }
    }

    static abstract class GoodsBogie extends Bogie {
        protected String cargoType;
        protected double maxLoadCapacityTons;
        protected double currentLoadTons;

        public GoodsBogie(String bogieId, String bogieType, String cargoType, double maxLoadCapacityTons) {
            super(bogieId, bogieType);
            this.cargoType = cargoType;
            this.maxLoadCapacityTons = maxLoadCapacityTons;
            this.currentLoadTons = 0.0;
        }

        public boolean isSafelyLoaded() {
            return currentLoadTons <= maxLoadCapacityTons;
        }

        @Override
        public String getSummary() {
            return String.format("  [%s] Type: %-14s | Cargo: %-12s | Load: %.1f / %.1f tons | Safe: %s",
                    bogieId, bogieType, cargoType, currentLoadTons, maxLoadCapacityTons,
                    isSafelyLoaded() ? "YES" : "NO");
        }
    }

    static class RectangularBogie extends GoodsBogie {
        public RectangularBogie(String bogieId, String cargoType) {
            super(bogieId, "Rectangular", cargoType, 60.0);
        }
    }

    static class CylindricalBogie extends GoodsBogie {
        public CylindricalBogie(String bogieId, String cargoType) {
            super(bogieId, "Cylindrical", cargoType, 45.0);
        }
    }

    static class Train {
        private String trainNumber;
        private String trainName;
        private String engineId;
        private List<Bogie> consist;

        public Train(String trainNumber, String trainName, String engineId) {
            this.trainNumber = trainNumber;
            this.trainName = trainName;
            this.engineId = engineId;
            this.consist = new ArrayList<>();
        }

        public void addBogie(Bogie bogie) {
            consist.add(bogie);
        }

        public void displayConsistSummary() {
            System.out.println("╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║          TRAIN CONSIST MANAGEMENT APP                        ║");
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
            System.out.printf("%nTrain Number : %s%n", trainNumber);
            System.out.printf("Train Name   : %s%n", trainName);
            System.out.printf("Engine ID    : %s%n", engineId);
            System.out.printf("Total Bogies : %d%n%n", consist.size());

            System.out.println("── PASSENGER BOGIES ──────────────────────────────────────────");
            int totalSeats = 0, totalBooked = 0;
            boolean hasPassenger = false;
            for (Bogie b : consist) {
                if (b instanceof PassengerBogie pb) {
                    System.out.println(pb.getSummary());
                    totalSeats += pb.totalSeats;
                    totalBooked += pb.bookedSeats;
                    hasPassenger = true;
                }
            }
            if (!hasPassenger) System.out.println("  (none)");
            System.out.printf("%nTotal Passenger Seats : %d%n", totalSeats);
            System.out.printf("Total Booked          : %d%n", totalBooked);
            System.out.printf("Total Available       : %d%n%n", totalSeats - totalBooked);

            System.out.println("── GOODS BOGIES ──────────────────────────────────────────────");
            boolean hasGoods = false, overallSafe = true;
            for (Bogie b : consist) {
                if (b instanceof GoodsBogie gb) {
                    System.out.println(gb.getSummary());
                    if (!gb.isSafelyLoaded()) overallSafe = false;
                    hasGoods = true;
                }
            }
            if (!hasGoods) System.out.println("  (none)");
            System.out.printf("%nOverall Safety Compliance: %s%n",
                    hasGoods ? (overallSafe ? "COMPLIANT" : "NON-COMPLIANT") : "N/A");
            System.out.println("──────────────────────────────────────────────────────────────");
        }
    }

    public static void main(String[] args) {
        Train train = new Train("12345", "Rajdhani Express", "ENG-001");

        train.addBogie(new SleeperBogie("B1"));
        train.addBogie(new SleeperBogie("B2"));
        train.addBogie(new ACChairBogie("B3"));
        train.addBogie(new FirstClassBogie("B4"));
        train.addBogie(new RectangularBogie("G1", "Electronics"));
        train.addBogie(new CylindricalBogie("G2", "Chemicals"));

        train.displayConsistSummary();
    }
}