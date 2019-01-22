import java.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Album {
    private static Scanner scanner = new Scanner(System.in);

    private String albumTitle;
    private Song[] songs;

    public Album(String albumTitle, Song[] songs) {
        this.albumTitle = albumTitle;
        this.songs = songs;
    }

    public static Album buildAlbum(String albumTitle) {
        Song[] songs = buildSongList();
        return new Album(albumTitle, songs);
    }

    private static Song[] buildSongList() {
        ArrayList<Song> songList = new ArrayList<Song>();
        while (true) {
            System.out.println("Enter song title, or \"q\" to quit");
            String songTitle = scanner.nextLine();
            if (songTitle.equals("q")) {
                break;
            }
            System.out.println("Enter duration in format mm:ss: ");
            String durationString = scanner.nextLine();
            String[] minutesAndSeconds = durationString.split(":");
            int minutes = Integer.parseInt(minutesAndSeconds[0]);
            int seconds = Integer.parseInt(minutesAndSeconds[1]);
            Song song = new Song(songTitle, minutes, seconds);
            songList.add(song);
        }
        return songList.toArray();
    }

    public String getAlbumTitle() {
        return this.albumTitle;
    }

    public Song[] getSongs() {
        return this.songs;
    }

    public Song getSongByTitle(String songTitle) {
        for (Song song : songs) {
            if (songTitle.equals(song.getTitle())) {
                return song;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object otherObj) {
        if (otherObj == this)
            return true;
        if (otherObj == null) {
            return false;
        }
        if (getClass() != otherObj.getClass()) {
            return false;
        }
        Album other = (Album) otherObj;
        return Objects.equals(albumTitle, other.albumTitle) && Arrays.equals(this.songs, other.songs);
    }


    @Override
    public int hashCode() {
        // I do not believe that this is correct given the definition of equals provided above.
        return Objects.hash(albumTitle, songs);
    }


}