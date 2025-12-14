class Solution {
    static void swapDiagonal(int[][] mat) {
        int size = mat.length;
        int[] majorDia = new int[size];
        int[] minorDia = new int[size];

        // Store major and minor diagonal elements
        for (int i = 0; i < size; i++) {
            majorDia[i] = mat[i][i];
            minorDia[i] = mat[i][size - i - 1];
        }

        // Swap the diagonals by placing stored values
        for (int i = 0; i < size; i++) {
            mat[i][i] = minorDia[i];
            mat[i][size - i - 1] = majorDia[i];
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8}
        };

        swapDiagonal(mat);
         for (int[] row : mat) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}
