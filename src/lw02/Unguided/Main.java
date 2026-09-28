package lw02.Unguided;
import java.util.*;
public class Main {

    Scanner scanner = new Scanner(
            Main.class.getResourceAsStream("borrowing.txt")
        );
        LinkedList<String[]> requests  = new LinkedList<>();
        
        LinkedList<String[]> books = new LinkedList<>();
        
        LinkedList<String[]> member = new LinkedList<>();
        
        Queue<String[]> queue = new LinkedList<>();
        
        Stack<String[]> failedRequests = new Stack<>();
    
        while (scanner.hasNext()) {

            String[] request = new String[2];

            request[0] = scanner.next(); 
            request[1] = scanner.next(); 
        // jumlah transaksi

            // Menyimpan transaksi ke LinkedList
            requests.add(request);
        }

        scanner.close();

         queue.addAll(requests);


        // Memproses transaksi menggunakan Queue

        while (!queue.isEmpty()) {

            String[] request = queue.poll();

            String name = request[0];
            String bookTitle = request[1];
            int kalkulus = 2;
            int fisika = 1;
            int statistika = 2;

    
            String[] book = null;
            for (String[] data : books) {

                if (data[0].equals(bookTitle)) {

                    book = data;
                    break;
                }
            }
            if (member == null) {

                member = new String[]{name, "0"};

                members.add(member);
            }


            int stock = Integer.parseInt(bookTitle)


            // Jika transaksi adalah DEPOSIT

            if (type.equals("DEPOSIT")) {

                stock += amount;

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

        System.out.println("=== Final Requests ===");

        for (String[] customer : customers) {

            System.out.println(
                customer[0] + " : " + customer[1]
            );
        }


        // Menampilkan transaksi yang gagal

        System.out.println("=== Failed Requests ===");

        while (!failedRequests.isEmpty()) {

            String[] request = failedRequests.pop();

            System.out.println(
                request[0] + " "
                + request[1] 
            );
        }
    }
        


