package combinationsWithRepetition;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Integer[] elements;
    public static Integer[] combinations;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        elements = new Integer[n];
        for (int i = 0; i < n; i++) {
            elements[i] = i + 1;
        }

        int k = Integer.parseInt(scanner.nextLine());
        combinations = new Integer[k];

        combinations(0, 0);
    }

    private static void combinations(int index, int start) {
        if (index == combinations.length) {
            print();
        } else {
            for (int i = start; i < elements.length; i++) {
                combinations[index] = elements[i];
                combinations(index + 1, i);
            }
        }
    }

    private static void print() {
        for (int i = 0; i < combinations.length; i++) {
            System.out.print(combinations[i] + " ");
        }
        System.out.println();
    }
}
