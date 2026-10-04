package lw03.prelab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // =========================
        // Problem 1 - Playlist
        // =========================

        // List digunakan karena lagu harus berurutan dan boleh duplicate
        List<String> playlist = new ArrayList<>();

        Scanner scanner = new Scanner(
                Main.class.getResourceAsStream("playlist.txt")
        );

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.startsWith("ADD")) {
                String[] parts = line.split(" ", 2);
                playlist.add(parts[1]);

            } else if (line.startsWith("INSERT")) {
                String[] parts = line.split(" ", 3);

                int index = Integer.parseInt(parts[1]);
                String song = parts[2];

                playlist.add(index, song);

            } else if (line.startsWith("REMOVE")) {
                String[] parts = line.split(" ", 2);
                playlist.remove(parts[1]);
            }
        }

        scanner.close();

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());

        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }


        // =========================
        // Problem 2 - Participants
        // =========================

        // LinkedHashSet digunakan agar data unik dan urutan tetap dipertahankan
        Set<String> participants = new LinkedHashSet<>();

        int duplicateRegistrations = 0;

        Scanner participantScanner = new Scanner(
                Main.class.getResourceAsStream("participants.txt")
        );

        while (participantScanner.hasNextLine()) {
            String name = participantScanner.nextLine();

            if (participants.contains(name)) {
                duplicateRegistrations++;
            } else {
                participants.add(name);
            }
        }

        participantScanner.close();

        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());

        int number = 1;

        for (String name : participants) {
            System.out.println(number + ". " + name);
            number++;
        }

        System.out.println("Duplicate registrations: "
                + duplicateRegistrations);


        // =========================
        // Problem 3 - Inventory
        // =========================

        // Map digunakan untuk menghubungkan nama produk dengan jumlah stok
        // LinkedHashMap menjaga urutan produk pertama kali muncul
        Map<String, Integer> inventory = new LinkedHashMap<>();

        int failedSales = 0;

        Scanner inventoryScanner = new Scanner(
                Main.class.getResourceAsStream("inventory.txt")
        );

        while (inventoryScanner.hasNextLine()) {
            String line = inventoryScanner.nextLine();

            String[] parts = line.split(" ");

            String type = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            if (type.equals("ADD")) {

                if (inventory.containsKey(product)) {
                    int currentStock = inventory.get(product);
                    inventory.put(product, currentStock + quantity);
                } else {
                    inventory.put(product, quantity);
                }

            } else if (type.equals("SELL")) {

                // Penjualan hanya berhasil jika produk ada dan stok mencukupi
                if (inventory.containsKey(product)
                        && inventory.get(product) >= quantity) {

                    int currentStock = inventory.get(product);
                    inventory.put(product, currentStock - quantity);

                } else {
                    failedSales++;
                }
            }
        }

        inventoryScanner.close();

        System.out.println("===== Problem 3 =====");

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(
                    entry.getKey() + ": " + entry.getValue()
            );
        }

        System.out.println("Failed sales: " + failedSales);
    }
}