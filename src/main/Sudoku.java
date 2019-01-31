public class Sudoku {

    static final int GRID_LENGTH = 4;
    public static final int BOX_LENGTH = (int)Math.sqrt(GRID_LENGTH);
    int[][] grid = new int[GRID_LENGTH][GRID_LENGTH];


    public String printGrid() {
        StringBuilder gridOutput = new StringBuilder();

        for (int i = 0; i < GRID_LENGTH; i++) {
            for (int j = 0; j < GRID_LENGTH; j++) {
                gridOutput.append(grid[i][j] + " ");
            }
            gridOutput.append("\n");
        }

        return gridOutput.toString();
    }

    public boolean playNumber(int number, int x, int y) {
        if(isValidNumber(number, x,y)){

            if (isRowOrColumnInvalid(number, x, y)) return false;

            if (checkQuadrantIsInvalid(number, calculateBoxStartingPoint(x), calculateBoxStartingPoint(y))) {
                return false;
            }

            grid[x][y] = number;
            return true;
        }
        return false;
    }

    private int calculateBoxStartingPoint(int x) {
        return (x / BOX_LENGTH) * BOX_LENGTH;
    }

    private boolean checkQuadrantIsInvalid(int number, int horizontal,  int vertical) {
        for (int i = horizontal; i < horizontal + BOX_LENGTH; i++) {
            for (int j = vertical; j < vertical + BOX_LENGTH; j++) {
                if (grid[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isRowOrColumnInvalid(int number, int x, int y) {
        for (int i = 0; i < GRID_LENGTH; i++) {
            if (grid[x][i] == number || grid[i][y] == number) {
                return true;
            }

        }
        return false;
    }

    private boolean isValidNumber(int number, int x, int y) {
        return number > 0 && number <= GRID_LENGTH && grid [x][y] == 0;
    }
}
