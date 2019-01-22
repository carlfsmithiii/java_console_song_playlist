import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.addAlbum();
        playlist.addAlbum();
        playlist.displayAlbums(); 
    }
}