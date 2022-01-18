package combinationsWithoutRepetition;

import java.util.Scanner;

public class Main {
    public static Integer[] combinations;
    public static Integer n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());
        combinations = new Integer[k];

        generateCombinationsWithoutRepetition(0, 1);
    }

    private static void generateCombinationsWithoutRepetition(int index, int start) {
        if (index == combinations.length) {
            print();
        } else {
            for (int i = start; i <= n; i++) {
                combinations[index] = i;
                generateCombinationsWithoutRepetition(index + 1, i + 1);
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
