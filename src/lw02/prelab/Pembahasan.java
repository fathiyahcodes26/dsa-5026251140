package lw02.prelab;

import java.util.*; 

public class Pembahasan {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(
            Main.class.getResourceAsStream("transactions.txt")
        );

        // LinkedList untuk menyimpan semua transaksi
        LinkedList<String[]> transactions = new LinkedList<>();

        // LinkedList untuk menyimpan data customer dan saldo
        LinkedList<String[]> customers = new LinkedList<>();
        ArrayList<String> stock = new ArrayList<>();
        stock.add ("Kalkulus");
        

        // Queue untuk memproses transaksi dengan urutan FIFO
        Queue<String[]> queue = new LinkedList<>();

        // Stack untuk menyimpan transaksi withdrawal yang gagal
        Stack<String[]> failedTransactions = new Stack<>();


        // Membaca setiap transaksi dari file

        while (scanner.hasNext()) {

            String[] transaction = new String[3];

            transaction[0] = scanner.next(); // nama customer
            transaction[1] = scanner.next(); // tipe transaksi
            transaction[2] = scanner.next(); // jumlah transaksi

            // Menyimpan transaksi ke LinkedList
            transactions.add(transaction);
        }

        scanner.close();


        // Memindahkan semua transaksi ke Queue

        queue.addAll(transactions);


        // Memproses transaksi menggunakan Queue

        while (!queue.isEmpty()) {

            String[] transaction = queue.poll();

            String name = transaction[0];
            String type = transaction[1];
            int amount = Integer.parseInt(transaction[2]);


            // Mengecek apakah customer sudah ada

            String[] customer = null;

            for (String[] data : customers) {

                if (data[0].equals(name)) {

                    customer = data;
                    break;
                }
            }


            // Jika customer belum ada,
            // tambahkan dengan saldo awal 0

            if (customer == null) {

                customer = new String[]{name, "0"};

                customers.add(customer);
            }


            int balance = Integer.parseInt(customer[1]);


            // Jika transaksi adalah DEPOSIT

            if (type.equals("DEPOSIT")) {

                balance += amount;

                customer[1] = String.valueOf(balance);
            }


            // Jika transaksi adalah WITHDRAW

            else if (type.equals("WITHDRAW")) {

                if (balance >= amount) {

                    balance -= amount;

                    customer[1] = String.valueOf(balance);

                } else {

                    // Jika saldo tidak cukup,
                    // masukkan transaksi ke Stack

                    failedTransactions.push(transaction);
                }
            }
        }


        // Menampilkan saldo akhir

        System.out.println("=== Final Balances ===");

        for (String[] customer : customers) {

            System.out.println(
                customer[0] + " : " + customer[1]
            );
        }


        // Menampilkan transaksi yang gagal

        System.out.println("=== Failed Transactions ===");

        while (!failedTransactions.isEmpty()) {

            String[] transaction = failedTransactions.pop();

            System.out.println(
                transaction[0] + " "
                + transaction[1] + " "
                + transaction[2]
            );
        }
    }
}