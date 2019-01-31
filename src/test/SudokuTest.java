import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SudokuTest {

    Sudoku sudoku = new Sudoku();

    @Test
    public void shouldGenerateGrid() {
        assertThat(sudoku.printGrid()).isEqualTo
                ("0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n");
    }

    @Test
    public void shouldShowValidPlay(){
        assertThat(sudoku.playNumber(1, 0, 0)).isTrue();
        assertThat(sudoku.printGrid()).isEqualTo(
                "1 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n");
    }

    @Test
    public void  checkInputLessThanFive(){
        assertThat(sudoku.playNumber(5, 0, 0)).isFalse();
    }

    @Test
    public void checkInputGreaterThanZero() {
        assertThat(sudoku.playNumber(0, 0, 0)).isFalse();
    }

    @Test
    public void validateRow(){
        sudoku.playNumber(1, 0, 0);
        assertThat(sudoku.playNumber(1, 0, 1)).isFalse();
    }

    @Test
    public void validateColumn() {
        sudoku.playNumber(1, 0, 0);
        assertThat(sudoku.playNumber(1, 1, 0)).isFalse();
    }

    @Test
    public void sameLocationMultipleTimes() {
        sudoku.playNumber(1,0,0);
        assertThat(sudoku.playNumber(2,0,0)).isFalse();
    }

    @Test
    public void validateQuadrant1(){
        sudoku.playNumber(1, 0, 0);
        assertThat(sudoku.playNumber(1, 1, 1)).isFalse();
    }

    @Test
    public void validateQuadrant2(){
        sudoku.playNumber(1, 0, 2);
        assertThat(sudoku.playNumber(1, 1, 3)).isFalse();
    }

    @Test
    public void validateQuadrant3(){
        sudoku.playNumber(1, 2, 0);
        assertThat(sudoku.playNumber(1, 3, 1)).isFalse();
    }

    @Test
    public void validateQuadrant4(){
        sudoku.playNumber(1, 2, 2);
        assertThat(sudoku.playNumber(1, 3, 3)).isFalse();
    }
}
