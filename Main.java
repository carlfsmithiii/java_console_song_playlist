import java.util.Scanner;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        activateJukeBox(playlist);
    }

    private static void activateJukeBox(Playlist playlist) {
        boolean quit = false;
        int action;
        while (!quit) {
            System.out.print("Please enter command, or press 8 to view main menu: ");
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
                System.out.print("Display songs as well? (y/n) ");
                String response = scanner.nextLine();
                if (response.equals("y")) {
                    playlist.displayAlbums(true);
                } else {
                    playlist.displayAlbums(false);
                }
                break;
            case 3:
                playlist.displayPlaylist();
                break;
            case 4:
                playMusic(playlist);
                break;
            case 8:
                printMainMenu();
                break;
            case 9:
                System.out.println("Good bye!");
                quit = true;
                break;
            default:
                System.out.println("Invalid command.  Here is the menu:");
                printMainMenu();
                break;
            }
        }
    }

    private static void playMusic(Playlist playlist) {
        boolean quit = false;
        boolean isGoingForward = true;
        int action;
        LinkedList<Song> songList = playlist.getPlaylist();

        ListIterator<Song> listIterator = songList.listIterator();
        if (songList.isEmpty()) {
            System.out.println("Your playlist is empty.  Returning to main menu...");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().getTitle());
        }
        printPlayMenu();

        while (!quit) {
            System.out.print("Enter your command, or press 8 to view menu: ");
            action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
            case 0: // play next song
                if (!isGoingForward) {
                    if (listIterator.hasNext()) {
                        listIterator.next();
                    }
                    isGoingForward = true;
                }
                if (listIterator.hasNext()) {
                    System.out.println("Now Playing " + listIterator.next().getTitle());
                } else {
                    System.out.println("You have reached the end of your playlist");
                    isGoingForward = false;
                }
                break;
            case 1: // skip back
                System.out.print("How many songs back do you want to go? ");
                int howFarBack = scanner.nextInt();
                scanner.nextLine();
                if (isGoingForward) {
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                    }
                    isGoingForward = false;
                }
                for (int i = 0; i < howFarBack; i++) {
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                    } else {
                        System.out.println("You are now at the beginning of your playlist");
                        break;
                    }
                }
                if (listIterator.hasNext()) {
                    System.out.println("The next song on the playlist is " + listIterator.next().getTitle());
                    listIterator.previous();
                    isGoingForward = true;
                }
                break;
            case 2: // skip forward
                System.out.print("How many songs forward do you want to go? ");
                int howFarForward = scanner.nextInt();
                scanner.nextLine();
                if (!isGoingForward) {
                    if (listIterator.hasNext()) {
                        listIterator.next();
                    }
                    isGoingForward = true;
                }
                for (int i = 0; i < howFarForward; i++) {
                    if (listIterator.hasNext()) {
                        listIterator.next();
                    } else {
                        System.out.println("You are now at the end of your playlist");
                        listIterator.previous();
                        break;
                    }
                }
                if (listIterator.hasNext()) {
                    System.out.println("The next song on the playlist is " + listIterator.next().getTitle());
                    listIterator.previous();
                } else {
                    System.out.println("You have reached the end of your playlist");
                    isGoingForward = false;
                }
                break;
            case 3: // replay
                if (listIterator.hasPrevious()) {
                    listIterator.previous();
                } else {
                    System.out.println("Sorry, you are already at the beginning of the playlist");
                    break;
                }
                if (listIterator.hasNext()) {
                    System.out.println("Now Playing " + listIterator.next().getTitle());
                    isGoingForward = true;
                } else {
                    System.out.println("You have reached the end of your playlist");
                    isGoingForward = false;
                }
                break;
            case 8:
                printPlayMenu();
                break;
            case 9:
                System.out.println("Returning to Main menu...");
                quit = true;
                break;
            default:
                printPlayMenu();
                break;
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\nChoose from the menu below: ");
        System.out.printf("\t0 -- Add an album to your collection, \n" + "\t1 -- Add a song to your playlist, \n"
                + "\t2 -- List Albums\n" + "\t3 -- List Playlist\n" + "\t4 -- Play Some Music!\n"
                + "\t8 -- Display Main Menu\n" + "\t9 -- Quit\n\n");
    }

    private static void printPlayMenu() {
        System.out.println("\nChoose from the menu below: ");
        System.out.println("\t0 -- Play next song\n" + "\t1 -- Skip backwards to a previous song\n"
                + "\t2 -- Skip forward to a later song\n" + "\t3 -- Replay the current song\n" + "\t8 -- Display Menu\n"
                + "\t9 -- Return to Main Menu\n");
    }
}