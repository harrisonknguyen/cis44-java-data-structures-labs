//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();
        int option;

        do{
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Play Next Song");
            System.out.println("4. Display Playlist");
            System.out.println("5. Exit");
            System.out.print("Select: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    System.out.print("Please enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine();
                    Song song = new Song(title, artist);
                    playlist.addSong(song);
                    break;

                case 2:
                    System.out.print("Enter title to remove: ");
                    String removeTitle = scanner.nextLine();

                    playlist.removeSong(removeTitle);
                    break;

                case 3:
                    playlist.playNext();
                    break;

                case 4:
                    playlist.displayPlaylist();
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