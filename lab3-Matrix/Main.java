//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(2, 3);
        Matrix matrix2 = new Matrix(2, 3);

        matrix1.populateRandom();
        matrix2.populateRandom();

        System.out.println("Matrix 1:");
        System.out.println(matrix1);

        System.out.println("Matrix 2:");
        System.out.println(matrix2);

        Matrix sum = matrix1.add(matrix2);

        System.out.println("Sum:");
        System.out.println(sum);


        Matrix matrix3 = new Matrix(3, 2);
        matrix3.populateRandom();

        System.out.println("Matrix 3:");
        System.out.println(matrix3);

        Matrix product = matrix1.multiply(matrix3);

        System.out.println("Product:");
        System.out.println(product);

        try {
            Matrix wrongMatrix = new Matrix(3, 3);
            matrix1.add(wrongMatrix);
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding matrices.");
        }
        try {
            Matrix wrongMatrix = new Matrix(4, 4);
            matrix1.multiply(wrongMatrix);
        } catch (IllegalArgumentException e) {
            System.out.println("Error multiplying matrices.");
        }
    }
}