package ru.mirea.fedoseev.practice41.task4;

public class MatrixTester {
    public static void main(String[] args) {
        double[][] data1 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        double[][] data2 = {
            {7, 8, 9},
            {10, 11, 12}
        };
        double[][] data3 = {
            {1, 2},
            {3, 4},
            {5, 6}
        };

        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        Matrix matrix3 = new Matrix(data3);

        System.out.println("Матрица 1:");
        matrix1.print();
        System.out.println();

        System.out.println("Матрица 2:");
        matrix2.print();
        System.out.println();

        System.out.println("Матрица 3:");
        matrix3.print();
        System.out.println();

        System.out.println("Сложение матриц 1 и 2:");
        Matrix sum = matrix1.add(matrix2);
        sum.print();
        System.out.println();

        System.out.println("Умножение матрицы 1 на 2:");
        Matrix scaled = matrix1.multiplyByScalar(2);
        scaled.print();
        System.out.println();

        System.out.println("Умножение матрицы 1 на матрицу 3:");
        Matrix product = matrix1.multiply(matrix3);
        product.print();
        System.out.println();
    }
}
