import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        int option;

        do{
            System.out.println("1. Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Exit");
            System.out.print("Select: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    System.out.print("Enter text: ");
                    String text = scanner.nextLine();
                    editor.add(text);
                    break;

                case 2:
                    System.out.println("Undo: " + editor.undo());
                    break;

                case 3:
                    System.out.println("Redo: " + editor.redo());
                    break;

                case 4:
                    editor.printCurrent();
                    break;

                case 5:
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }
        while (option != 5);

        scanner.close();
    }
}
