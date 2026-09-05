//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();

    Random rng = new Random();

    int[] a = new int[n];
    int[] b = new int[n];
    int[] c = new int[n];

    for (int i = 0; i < n; i++) {
        a[i] = rng.nextInt(100);
        b[i] = rng.nextInt(100);
        c[i] = a[i] * b[i];
    }

    System.out.println("Array A: " + Arrays.toString(a));
    System.out.println("Array B: " + Arrays.toString(b));
    System.out.println("Array C: " + Arrays.toString(c));
    }
}