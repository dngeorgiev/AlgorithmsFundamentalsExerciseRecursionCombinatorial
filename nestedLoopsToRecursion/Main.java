package nestedLoopsToRecursion;

import java.util.Scanner;

public class Main {
    public static int[] elements;
    public static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());

        elements = new int[n];

        permute(0);
    }

    private static void permute(int index) {
        if (index == elements.length) {
            print();
        } else {
            for (int i = 1; i <= n; i++) {
                elements[index] = i;
                permute(index + 1);
            }
        }
    }

    private static void print() {
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + " ");
        }

        System.out.println();
    }
}
