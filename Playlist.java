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

    public boolean addAlbum(Album newAlbum) {
        if (albums.contains(newAlbum)) {
            System.out.println("Your album Collection already contains " + newAlbum.getAlbumTitle());
            return false;
        } 
        return albums.add(newAlbum);
    }

    public void addAlbum() {
        System.out.print("Please enter new album title: ");
        String albumTitle = scanner.nextLine();
        Album newAlbum = Album.buildAlbum(albumTitle);
        this.addAlbum(newAlbum);
    }

    private Album getAlbumByName(String albumName) {
        for (Album album : albums) {
            if (albumName.equals(album.getAlbumTitle())) {
                return album;
            }
        }
        return null;
    }

    public boolean addSongToPlaylist(String albumName, String songName) {
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
        return true;
    }

    public void displayAlbums() {
        for (Album album : albums) {
            System.out.println(album.getAlbumTitle());
            for (Song song : album.getSongs()) {
                System.out.println("\t" + song.getTitle());
            }
        }
    }
}