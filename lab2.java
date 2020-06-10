/**
 * C5 = 9118 % 5 = 3      C=A⊕B дія з матрицями
 * C7 = 9118 % 7 = 4      тип індексів i та j = int
 * c11 = 9118 % 11 = 10   середнє значення елементів матриці
 */
class Mainn {
    public static void main(String[] args) {
        int [][] A = new int[][] {{1, 2},
                                  {4, 5},
                                  {7, 8}};
        int [][] B = new int[][] {{1, 4, 5},
                                  {8, 7, 6}};
        for (int i = 0; i<A.length; i++) {
            for (int j = 0; j<A[0].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("                    ");
        for (int i = 0; i<B.length; i++) {
            for (int j = 0; j<B[0].length; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("                    ");

//       C=A⊕B дія з матрицями

        int CRow = A.length+B.length;
        int CCol = A[0].length+B[0].length;
        int [][] C = new int[CRow][CCol];
        for (int i = 0; i < CRow; i++) {
            for (int j = 0; j < CCol; j++) {
                if (j < A[0].length && i < A.length) {
                    C[i][j] = A[i][j];
                }
                else if (j >= A[0].length && i >= A.length) {
                    C[i][j] = B[i - A.length][j - A[0].length];
                }
                else {
                    C[i][j] = 0;
                }
            }
        }
        for (int i = 0; i<C.length; i++) {
            for (int j = 0; j<C[0].length; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("                    ");

//       середнє значення елементів матриці
        double Count = 0;
        double Mid;
        for (int i = 0; i<C.length; i++) {
            for (int j = 0; j<C[0].length; j++) {
                Count += C[i][j];
            }
        }
        System.out.println(Count);
        System.out.println(CRow * CCol);
        Mid = (Count)/(CRow * CCol);
        System.out.println("Среднее значение елементов матрицы = " + Mid);
    }
}