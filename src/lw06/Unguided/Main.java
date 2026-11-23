package lw06.Unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));
        String number = read.nextLine();
        Scanner in = new Scanner(number);

        BinarySearchTree bst = new BinarySearchTree();
        while (in.hasNextInt()) {
            int data = in.nextInt();
            bst.insert(data);
        }
        System.out.print("Preorder : ");
        bst.preOrder();
        System.out.print("Inorder: ");
        bst.inOrder();
        System.out.print("Postorder: ");
        bst.postOrder();
        System.out.println("Search  50 : " + bst.search(50));

        System.out.println("Minimum : " + bst.findMin());
        System.out.println("Maximum : " + bst.findMax());

    }
}
       