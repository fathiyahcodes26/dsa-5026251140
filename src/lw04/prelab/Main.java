package lw04.prelab;
import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        sortBranches(sc);
        sortBranches(sc);
        sc.close();
    }
    public static void sortBranches(Scanner sc) {
        int totalSemuaBranches = sc.nextInt();
        int[] branches = new int[totalSemuaBranches];
        
        for (int i = 0; i < totalSemuaBranches; i++) {
            branches[i] = sc.nextInt();
        }

        int totalTarget = sc.nextInt();
        int[] target = new int[totalTarget];

        for (int i = 0; i < totalTarget; i++) {
            target[i] = sc.nextInt();
        }

        for (int i = 1; i <= 3; i++) {
            int branch = branches[i];
            
            for (int j = i; j > 0; j--) {
                if (branches[j - 1] < branch) {
                    branches[j] = branches[j - 1];
                    branches[j - 1] = branch;
                }
            }
        }

        for (int branch: branches) {
            System.out.print(branch + " ");
        }
        System.out.println();

        for (int i = 0; i < target.length; i++){
            int index = -1;
            int targetnya = target[i];
            for (int j = 0; j < branches.length; j++) {
                if (targetnya == branches[j]) {
                    index = j;
                    break;
                }
            }
            if (index != -1) {
                System.out.println(targetnya + ": FOUND at index " + index);
            } else {
                System.out.println(targetnya + ": NOT FOUND");
            }
        }
        System.out.println();
    }
}