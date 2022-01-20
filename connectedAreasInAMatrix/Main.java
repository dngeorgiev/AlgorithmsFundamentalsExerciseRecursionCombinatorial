package connectedAreasInAMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static char[][] matrix;
    public static TreeSet<FoundArea> foundAreas;
    public static int currentSize;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        matrix = new char[rows][columns];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        foundAreas = new TreeSet<FoundArea>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == '-') {
                    findAreas(row, col);
                    FoundArea foundArea = new FoundArea(row, col, currentSize);
                    foundAreas.add(foundArea);
                    currentSize = 0;
                }
            }
        }

        printAreas();
    }

    private static void findAreas(int row, int col) {
        if (isOutOfBounds(row, col) || isNotTraversable(row, col)) {
            return;
        }

        matrix[row][col] = 'V';

        currentSize++;

        findAreas(row + 1, col); // Bottom
        findAreas(row, col + 1); // Right
        findAreas(row - 1, col); // Top
        findAreas(row, col - 1); // Left
    }

    private static boolean isNotTraversable(int row, int col) {
        return matrix[row][col] == 'V' || matrix[row][col] == '*';
    }

    private static boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static void printAreas() {
        System.out.printf("Total areas found: %d%n", foundAreas.size());
        int index = 1;
        for (FoundArea foundArea : foundAreas) {
            System.out.printf("Area #%d at (%d, %d), size: %d%n",
                    index++,
                    foundArea.getRow(),
                    foundArea.getColumn(),
                    foundArea.getSize());

        }
    }
}

class FoundArea implements Comparable<FoundArea> {
    int _row;
    int _column;
    int _size;

    FoundArea(int row, int col, int size) {
        _row = row;
        _column = col;
        _size = size;
    }

    public int getRow() {
        return _row;
    }

    public int getColumn() {
        return _column;
    }

    public int getSize() {
        return _size;
    }

    public void setSize(int size) {
        _size = size;
    }

    @Override
    public int compareTo(FoundArea comparableArea) {
        int comparableAreaSize = comparableArea.getSize();
        int comparableAreaRow = comparableArea.getRow();
        int comparableAreaColumn = comparableArea.getColumn();

        int sizeCompare = Integer.compare(comparableAreaSize, _size);
        if (sizeCompare != 0) {
            return sizeCompare;
        }

        int rowCompare = Integer.compare(_row, comparableAreaRow);
        if (rowCompare != 0) {
            return rowCompare;
        }

        return Integer.compare(_column, comparableAreaColumn);

//        if (comparableAreaSize == _size) {
//            if (comparableArea.getRow() == _row) {
//                return Integer.compare(comparableArea.getColumn(), _column);
//            }
//            else if (comparableArea.getRow() > _row) return 1;
//            else return -1;
//        }
//        else if (comparableAreaSize > _size) return 1;
//        else return -1;
    }
}
