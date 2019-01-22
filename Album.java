import java.util.Objects;
import java.util.Arrays;

public class Album {
    private String albumTitle;
    private Song[] songs;

    public Album(String albumTitle, Song[] songs) {
        this.albumTitle = albumTitle;
        this.songs = songs;
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