import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        activateJukeBox();
        // playlist.addAlbum();
        // playlist.addAlbum();
        // playlist.displayAlbums();
    }

    private static void activateJukeBox() {
        System.out.println("Enter your command, of press 8 to view menu.");
        boolean quit = false;
        int action;
        while (!quit) {
            action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
            case 0:
                playlist.addAlbum();
                break;
            case 1:
                playlist.addSongToPlaylist();
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
                printMenu();
                break;
            case 9:
                quit = true;
                break;
            default:
                System.out.println("Invalid command.  Here is the menu:");
                printMenu();
                break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nChoose from the menu below: ");
        System.out.printf("\t0 -- Add an album to your collection, \n" + "\t1 -- Add a song to your playlist, \n"
                + "\t2 -- List Albums\n" + "\t3 -- List Playlist\n" + "\t4 -- Skip backwards to a previous song\n"
                + "\t5 -- Skip forward to a later song\n" + "\t6 -- Replay the current song\n" + "\t9 -- Quit\n\n");
    }
}