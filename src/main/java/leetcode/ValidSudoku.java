package leetcode;

public class ValidSudoku {

    public static void main(String[] args) {
        String sudoku[][] = {{".",".",".","9",".",".",".",".","."},{".",".",".",".",".",".",".",".","."},{".",".",".",".",".",".",".",".","."},{".",".",".",".",".",".",".",".","."},{".",".",".",".",".",".",".",".","."},{".",".",".",".",".",".",".",".","."},{".",".",".",".",".",".",".",".","."},{".",".",".",".",".",".",".",".","."},{"8",".",".","8",".",".",".",".","."}};

        verifyValidity(sudoku);
    }

    private static void verifyValidity(String[][] sudoku) {


        for(int i=0;i<9;i++)
        {
            for (int j=0;j<9;j++) {
                String value = sudoku[i][j];
                int count = 0;
                if (value != ".") {
                    for (int k = 0; k < 9; k++) {
                        if (value == sudoku[i][k]) {
                            count++;
                        }
                        if (value == sudoku[k][j]) {
                            count++;
                        }
                        if ( (i+k) <9 && (j+k)<9 && value == sudoku[i+k][j+k]) {
                            count++;
                        }
                        if (count > 3) {
                            System.out.println("False");
                            return;
                        }
                    }

                }
            }
        }
        System.out.println("true");
    }
}
