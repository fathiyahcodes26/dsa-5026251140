package lw01.prelab;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<PrintJob> jobs = new ArrayList<>();

        Scanner input = new Scanner(Main.class.getResourceAsStream("jobs.txt"));

        while (input.hasNext()) {
            String type = input.next();
            String id = input.next();
            int pages = input.nextInt();
            // PrintJob job;
            //
            if (type.equals("MONO")) {
                jobs.add(new MonoPrint(id, pages));
            } else if (type.equals("COLOUR")) {
                jobs.add(new ColourPrint(id, pages));
            }
        }

        input.close();

        for (PrintJob job : jobs) {
            System.out.println(job.summary());
        }
    }
}