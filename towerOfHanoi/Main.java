package towerOfHanoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static StringBuilder out = new StringBuilder();

    public static Deque<Integer> source = new ArrayDeque<>();
    public static Deque<Integer> spare = new ArrayDeque<>();
    public static Deque<Integer> destination = new ArrayDeque<>();

    public static int currentStep = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfDisks = Integer.parseInt(reader.readLine());

        for (int i = numberOfDisks; i >= 1; i--) {
            source.push(i);
        }

        printRods();
        solve(numberOfDisks, source, destination, spare);

        System.out.print(out.toString());
    }

    private static void solve(int disk, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if (disk == 1) {
            destination.push(source.pop());

            out
                .append(String.format("Step #%d: Moved disk", currentStep++))
                .append(System.lineSeparator());

            printRods();
        } else {
            solve(disk - 1, source, spare, destination);
            solve(1, source, destination, spare);
            solve(disk - 1, spare, destination, source);
        }
    }

    private static void printRods() {
        out
            .append(
                String.format("Source: %s", formatRod(source))
            )
            .append(System.lineSeparator())
            .append(
                String.format("Destination: %s", formatRod(destination))
            )
            .append(System.lineSeparator())
            .append(
                String.format("Spare: %s", formatRod(spare))
            )
            .append(System.lineSeparator())
            .append(System.lineSeparator());
    }

    private static String formatRod(Deque<Integer> stack) {
        return stack.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
