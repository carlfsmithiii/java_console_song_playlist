import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Playlist {
    private static Scanner scanner = new Scanner(System.in);

    private ArrayList<Album> albums;
    private LinkedList<Song> playlist;

    public Playlist() {
        this.albums = new ArrayList<Album>();
        this.playlist = new LinkedList<Song>();
    }

    public ArrayList<Album> getAlbums() {
        return this.albums;
    }

    public LinkedList<Song> getPlaylist() {
        return this.playlist;
    }

    private boolean addAlbum(Album newAlbum) {
        if (albums.contains(newAlbum)) {
            System.out.println("Your album Collection already contains " + newAlbum.getAlbumTitle());
            return false;
        }
        if (albums.add(newAlbum)) {
            System.out.println(newAlbum.getAlbumTitle() + " was successfully added to your collection.");
            return true;
        } else {
            System.out.println("Sorry, " + newAlbum.getAlbumTitle() + " was not added to your collection.");
            return false;
        }
    }

    public boolean addAlbum() {
        System.out.print("Please enter new album title: ");
        String albumTitle = scanner.nextLine();
        Album newAlbum = Album.buildAlbum(albumTitle);
        return this.addAlbum(newAlbum);
    }

    private Album getAlbumByName(String albumName) {
        for (Album album : albums) {
            if (albumName.equals(album.getAlbumTitle())) {
                return album;
            }
        }
        return null;
    }

    private boolean addSongToPlaylist(String albumName, String songName) {
        Album album = getAlbumByName(albumName);
        if (album == null) {
            System.out.println("Sorry -- no album by the title " + albumName);
            return false;
        }
        Song song = album.getSongByTitle(songName);
        if (song == null) {
            System.out.println("Sorry -- " + albumName + " does not have a song titled " + songName);
            return false;
        }
        playlist.add(song);
        System.out.println(songName + " was successfully added to your playlist");
        return true;
    }

    public boolean addSongToPlaylist() {
        System.out.print("Please enter album name: ");
        String albumName = scanner.nextLine();
        System.out.print("Please enter song name: ");
        String songName = scanner.nextLine();
        return this.addSongToPlaylist(albumName, songName);
    }

    public void displayAlbums(boolean displaySongs) {
        if (albums.isEmpty()) {
            System.out.println("Sorry, you currently have no albums in your collection.");
        }
        for (Album album : albums) {
            album.display(displaySongs);
        }
    }

    public void displayAlbums() {
        this.displayAlbums(true);
    }

    public void displayPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("Sorry, your playlist is empty");
        }
        for (Song song : playlist) {
            song.display();
        }
    }
}