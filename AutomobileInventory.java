import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AutomobileInventory {
    public static void main(String[] args) {
        try {
            Automobile car = new Automobile("Toyota", "Camry", "Blue", 2020, 25000);

            System.out.println("Initial Vehicle Info:");
            for (String info : car.listVehicleInfo()) {
                System.out.println(info);
            }

            System.out.println("\nRemoving vehicle...");
            System.out.println(car.removeVehicle());

            System.out.println("\nAdding new vehicle...");
            System.out.println(car.addVehicle("Honda", "Civic", "Red", 2022, 5000));

            System.out.println("\nUpdated Vehicle Info:");
            for (String info : car.listVehicleInfo()) {
                System.out.println(info);
            }

            System.out.println("\nUpdating vehicle attributes...");
            System.out.println(car.updateVehicle("Honda", "Accord", "Black", 2023, 3000));

            System.out.println("\nFinal Vehicle Info:");
            String[] finalInfo = car.listVehicleInfo();
            for (String info : finalInfo) {
                System.out.println(info);
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("\nWould you like to save this info to a file? (Y/N): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Y")) {
                try (FileWriter writer = new FileWriter("C:\\Temp\\Autos.txt")) {
                    for (String info : finalInfo) {
                        writer.write(info + "\n");
                    }
                    System.out.println("Vehicle information saved to C:\\Temp\\Autos.txt");
                } catch (IOException e) {
                    System.out.println("Failed to write to file: " + e.getMessage());
                }
            } else {
                System.out.println("Vehicle information was not saved to file.");
            }

            scanner.close();

        } catch (Exception e) {
            System.out.println("Error running inventory program: " + e.getMessage());
        }
    }
}