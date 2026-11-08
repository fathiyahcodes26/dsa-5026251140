package lw04.prelab;

import java.util.*;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int n = sc.nextInt();
        int [] data = new int[n];

        for(int i=0;i<n;i++){
            data[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int [] target = new int[m];

        for(int i=0;i<m;i++){
            target[i] = sc.nextInt();
        }

        insertionSort(data);

        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();

        for(int i=0;i<m;i++){
            int result = linearSearch(target[i], data);

            if(result != -1){
                System.out.println(target[i]+": FOUND at index "+result);
            }
            else{
                System.out.println(target[i]+": NOT FOUND");
            }
        }

        sc.close();
    }

    public static void insertionSort(int [] data){
        for(int a=1;a<=3;a++){
            int temp=data[a];

            for(int b = a-1;b>=0;b--){
                if(data[b]<temp){
                    data[b+1]=data[b];
                }
                else{
                    data[b+1]=temp;
                    break;
                }

                if(b==0){
                    data[b]=temp;
                }
            }
        }
    }

    public static int linearSearch(int k, int [] data){
        for(int i=0;i<data.length;i++){
            if(data[i]==k){
                return i;
            }
        }
        return -1;
    }
}
