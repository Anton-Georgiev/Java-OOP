package WorkingWithAbstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int[] dimestions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = dimestions[0];
            int y = dimestions[1];

            int[][] matrix = new int[x][y];

        fillMatrix(x, y, matrix);

        String command = scanner.nextLine();
            long sum = 0;
            while (!command.equals("Let the Force be with you"))
            {
                int[] playerPosition = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] evilPosition = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int evilRow = evilPosition[0];
                int evilCow = evilPosition[1];

                while (evilRow >= 0 && evilCow >= 0)
                {
                    if (isInRange(matrix, evilRow, evilCow))
                    {
                        matrix[evilRow][evilCow] = 0;
                    }
                    evilRow--;
                    evilCow--;
                }

                int xI = playerPosition[0];
                int yI = playerPosition[1];

                while (xI >= 0 && yI < matrix[1].length)
                {
                    if (isInRange(matrix, xI, yI))
                    {
                        sum += matrix[xI][yI];
                    }

                    yI++;
                    xI--;
                }

                command = scanner.nextLine();
            }

        System.out.println(sum);


    }

    private static boolean isInRange(int[][] matrix, int evilRow, int evilCow) {
        return evilRow >= 0 && evilRow < matrix.length && evilCow >= 0 && evilCow < matrix[0].length;
    }

    private static void fillMatrix(int x, int y, int[][] matrix) {
        int value = 0;
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                matrix[i][j] = value++;
            }
        }
    }
}
