package lw01.Unguided;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Rental> rentals = new ArrayList<>();

        Scanner input = new Scanner(Main.class.getResourceAsStream("rentals.txt"));

        while (input.hasNext()) {
            String type = input.next();
            String id = input.next();
            int days = input.nextInt();
            // Rental rental;
            //
            if (type.equals("Laptop")) {
                rentals.add(new LaptopRental(id, days));
            } else if (type.equals("Projector")) {
                rentals.add(new ProjectorRental(id, days));
            }
        }

        input.close();

        for (Rental rental : rentals) {
            System.out.println(rental.summary(1));
        }
    }
}
