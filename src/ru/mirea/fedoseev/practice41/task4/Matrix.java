package ru.mirea.fedoseev.practice41.task4;

public class Matrix {
    private double[][] data;
    private int rows;
    private int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];
    }

    public Matrix(double[][] data) {
        this.rows = data.length;
        this.columns = data[0].length;
        this.data = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }

    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.columns != other.columns) {
            throw new IllegalArgumentException("Матрицы должны быть одинакового размера");
        }
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    public Matrix multiplyByScalar(double scalar) {
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.data[i][j] = this.data[i][j] * scalar;
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        if (this.columns != other.rows) {
            throw new IllegalArgumentException(
                "Количество столбцов первой матрицы должно равняться количеству строк второй");
        }
        Matrix result = new Matrix(this.rows, other.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                for (int k = 0; k < this.columns; k++) {
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return result;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("%8.2f ", data[i][j]);
            }
            System.out.println();
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
