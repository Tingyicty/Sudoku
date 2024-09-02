public class Main {
    public static void main(String[] args) {

        int[][] problem = {                 // Problem to solve
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        Solver solver = new Solver();
        Generator generator = new Generator();

        solver.solve(problem); // Solving the board
        solver.viewBoard(problem); // Displaying the solved board

        System.out.println("----------------------------------------");

        solver.viewBoard(generator.generateProblem(2)); //Generating a level 2 (medium) sudoku problem
                                           // Can choose from level 1 (easy) to 3 (hard)

        // new GUI(); GUI feature coming soon
    }
}