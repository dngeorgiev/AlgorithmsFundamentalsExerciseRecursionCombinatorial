package reverseArray;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split("\\s+");

        printReversedArray(elements, elements.length - 1);
    }

    private static void printReversedArray(String[] elements, int index) {
        if (index < 0) {
            return;
        }

        System.out.print(elements[index] + " ");

        printReversedArray(elements, index - 1);
    }
}
