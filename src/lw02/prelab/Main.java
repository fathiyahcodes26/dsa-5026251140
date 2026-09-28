package lw02.prelab;

import java.util.LinkedList;
import java.util.Queue; //first in first out atau FIFO
import java.util.Scanner;
import java.util.Stack; // last in first out atau LIFO

public class Main {

    public static void main(String[] args) {

        // LinkedList untuk menyimpan semua transaksi
        LinkedList<String[]> transactions = new LinkedList<>();
        // LinkedList untuk menyimpan data customer dan saldo
        LinkedList<String[]> customers = new LinkedList<>();
        // Queue untuk memproses transaksi dengan urutan FIFO
        Queue<String[]> queue = new LinkedList<>();
        // Stack untuk menyimpan transaksi withdrawal yang gagal
        Stack<String[]> failedTransactions = new Stack<>();


        Scanner scanner = new Scanner(
            Main.class.getResourceAsStream("transactions.txt")
        );


        // Membaca setiap transaksi dari file

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();

            // Memisahkan nama, tipe transaksi, dan jumlah
            String[] data = line.split("\\s+");

            String name = data[0];
            String type = data[1];
            String amount = data[2];


            // Menyimpan transaksi ke LinkedList
            transactions.add(new String[] {
                name,
                type,
                amount
            });


            // Mengecek apakah customer sudah ada
            boolean exists = false;

            for (String[] customer : customers) {
                if (customer[0].equals(name)) {
                    exists = true;
                    break;
                }
            }

            // Jika customer belum ada, tambahkan dengan saldo awal 0
            if (!exists) {
                customers.add(new String[] {
                    name,
                    "0"
                });
            }
        }

        scanner.close();

        while (!transactions.isEmpty()) { // Memindahkan transaksi dari LinkedList ke Queue

            queue.add(transactions.removeFirst());
        }

        while (!queue.isEmpty()) { // Memproses transaksi menggunakan Queue

            // Mengambil transaksi paling depan dari Queue
            String[] transaction = queue.poll();

            String name = transaction[0];
            String type = transaction[1];
            int amount = Integer.parseInt(transaction[2]);


            // Mencari customer yang sesuai
            for (String[] customer : customers) {
                if (customer[0].equals(name)) {
                    int balance = Integer.parseInt(customer[1]);  // Mengambil saldo customer
                    // Jika transaksi adalah DEPOSIT
                    if (type.equals("DEPOSIT")) {
                        balance += amount; // Menambahkan uang ke saldo
                        customer[1] = String.valueOf(balance); // Menyimpan saldo terbaru
                    }


                    // Jika transaksi adalah WITHDRAW
                    else if (type.equals("WITHDRAW")) {
                        // Jika saldo tidak mencukupi
                        if (amount > balance) {
                            failedTransactions.push(transaction); // Simpan transaksi gagal ke Stack

                        }

                        // Jika saldo mencukupi
                        else {
                            // Kurangi saldo
                            balance -= amount;
                            customer[1] = String.valueOf(balance); // Simpan saldo terbaru
                        }
                    }

                    break;
                }
            }
        }


        // Menampilkan saldo akhir setiap customer
        System.out.println("=== Final Balances ===");

        for (String[] customer : customers) {

            System.out.println(
                customer[0] + " : " + customer[1]
            );
        }


        // Menampilkan transaksi yang gagal

        System.out.println("=== Failed Transactions ===");

        while (!failedTransactions.isEmpty()) {
            // Mengambil transaksi terakhir yang masuk ke Stack
            String[] transaction = failedTransactions.pop();
            System.out.println(
                transaction[0] + " "
                + transaction[1] + " "
                + transaction[2]
            );
        }
    }
}