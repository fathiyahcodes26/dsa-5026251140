package lw03.Unguided;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("====Enrollment Checks====");
        System.out.println();
        Scanner sc = new Scanner(Main.class.getResourceAsStream("Enrollment.txt"));
        Map<String, Integer> enrollment = new LinkedHashMap<>();
        int nothing =0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            String type = parts[0];
            String code = parts[1];
            

            if (type.equals("REGISTER")) {
                int count = Integer.parseInt(parts[2]);

                if (enrollment.containsKey(code)) {
                    int record = enrollment.get(code);
                    enrollment.put(code, record + count);
                } else {
                    enrollment.put(code, count);
                }

            } else if (type.equals("WITHDRAW")) {
                int count = Integer.parseInt(parts[2]);
                if (enrollment.containsKey(code)
                        && enrollment.get(code) >= count) {

                    int record = enrollment.get(code);
                    enrollment.put(code, record - count);

                } else {
                    nothing++;
                }
            } else if (type.equals("CHECK")){ //
                
                if (enrollment.containsKey(code)) {
                    System.out.println(code + ": " + enrollment.get(code) + " students");
                } else {
                    System.out.println(code + ": 0 students");
                }
            } else {
                System.out.println("Invalid operation: " + type);

            }
        }

        sc.close();
        System.out.println("");
        System.out.println("===== Final Enrollment =====");

        for (Map.Entry<String, Integer> entry : enrollment.entrySet()) {
            System.out.println(
                    entry.getKey() + ": " + entry.getValue() + " students");
        }

        System.out.println();

        System.out.println("Rejected operations: " + nothing);

       
    }
    
}
