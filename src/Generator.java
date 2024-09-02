import java.util.Random;

public class Generator {

    Random random = new Random();
    Solver solver = new Solver();
    private final int BOARDMAX = 9;

    private int[] removeFromArray(int[] array, int element) { // Assuming unique occurrence
        int[] newArray = new int[array.length - 1];
            for (int i = 0, j = 0; i < array.length; i++) {
                if (array[i] != element) {
                    newArray[j] = array[i];
                    j++;
                }
            }
        return newArray;
    }

    public int[][] generateFilled() {

        int[][] empty = new int[BOARDMAX][BOARDMAX];
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int randomNum;

        for (int i = 0; i < BOARDMAX; i ++) {
            randomNum = random.nextInt(numbers.length);
            empty[0][i] = numbers[randomNum];
            numbers = removeFromArray(numbers, numbers[randomNum]);
        }
        if (solver.solve(empty)) {
            return empty;
        } else {
            return null; // not really reachable
        }
    }

    public int[] takeAway(int howMany, int[] array) {

        int randomNum;
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < howMany; i ++) {
            randomNum = random.nextInt(numbers.length);
            array[numbers[randomNum] - 1] = 0;
            numbers = removeFromArray(numbers, numbers[randomNum]);
        }
        return array;
    }

    public int[][] generateProblem(int level) {

        int level1 = 3, level2 = 4, level3 = 5;
        int randomNum;
        int[][] filled = generateFilled();
        int[][] problem = new int[9][9];

        if (level != 1 && level != 2 && level != 3) {
            return null;
        }

        if (level == 1) {
            for (int i = 0; i < BOARDMAX; i ++) {
                randomNum = random.nextInt(3) + level1;
                problem[i] = takeAway(randomNum, filled[i]);
            }
        } else if (level == 2) {
            for (int i = 0; i < BOARDMAX; i ++) {
                randomNum = random.nextInt(3) + level2;
                problem[i] = takeAway(randomNum, filled[i]);
            }
        } else {
            for (int i = 0; i < BOARDMAX; i ++) {
                randomNum = random.nextInt(3) + level3;
                problem[i] = takeAway(randomNum, filled[i]);
            }
        }
        return problem;
    }
}
