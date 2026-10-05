import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // problem 1
        System.out.println("===== Problem 1 =====");

        Scanner sc1 = new Scanner(
                Main.class.getResourceAsStream("playlist.txt")
        );

        List<String> playlist = new ArrayList<>();

        while (sc1.hasNextLine()) {
            String line = sc1.nextLine();
            String parts[] = line.split(" ", 2);

            String operation = parts[0];
            String code = parts[1];

            if (operation.equals("REGISTER")) {
                playlist.add(code);

            } else if (operation.equals("CHECK")) {
                String insertData[] = song.split(" ", 2);

                int index = Integer.parseInt(insertData[0]);
                String songName = insertData[1];

                playlist.add(index, songName);

            } else if (operation.equals("REMOVE")) {
                playlist.remove(song);
            }
        }

        sc1.close();

        System.out.println("Total songs: " + playlist.size());

        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }


        // problem 2
        System.out.println("===== Problem 2 =====");

        Scanner sc2 = new Scanner(
                Main.class.getResourceAsStream("participants.txt")
        );

        // LinkedHashSet digunakan agar tidak ada duplikat
        // dan urutan data tetap sesuai kemunculan pertama
        Set<String> participants = new LinkedHashSet<>();

        int duplicateRegistrations = 0;

        while (sc2.hasNextLine()) {
            String name = sc2.nextLine();

            if (!participants.contains(name)) {
                participants.add(name);
            } else {
                duplicateRegistrations++;
            }
        }

        sc2.close();

        System.out.println(
                "Unique participants: " + participants.size()
        );

        int number = 1;

        // Set tidak memiliki index seperti List,
        // sehingga digunakan enhanced for loop
        for (String name : participants) {
            System.out.println(number + ". " + name);
            number++;
        }

        System.out.println(
                "Duplicate registrations: "
                + duplicateRegistrations
        );


        // problem 3
        System.out.println("===== Problem 3 =====");

        Scanner sc3 = new Scanner(
                Main.class.getResourceAsStream("inventory.txt")
        );

        // Map digunakan untuk menyimpan:
        // nama produk -> jumlah stok
        Map<String, Integer> inventory = new LinkedHashMap<>();

        int failedSales = 0;

        while (sc3.hasNextLine()) {
            String line = sc3.nextLine();

            String parts[] = line.split(" ");

            String type = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            if (type.equals("ADD")) {

                if (inventory.containsKey(product)) {
                    int currentStock = inventory.get(product);

                    inventory.put(
                            product,
                            currentStock + quantity
                    );

                } else {
                    inventory.put(product, quantity);
                }

            } else if (type.equals("SELL")) {

                if (inventory.containsKey(product)
                        && inventory.get(product) >= quantity) {

                    int currentStock = inventory.get(product);

                    inventory.put(
                            product,
                            currentStock - quantity
                    );

                } else {
                    failedSales++;
                }
            }
        }

        sc3.close();

        for (String product : inventory.keySet()) {
            System.out.println(
                    product + ": " + inventory.get(product)
            );
        }

        System.out.println("Failed sales: " + failedSales);
    }
}