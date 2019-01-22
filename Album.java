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
        // if (!(o instanceof Album)) {
        //     return false;
        // }
        if (getClass() != otherObj.getClass()) {
            return false;
        }
        Album other = (Album) otherObj;
        // return Objects.equals(albumTitle, other.albumTitle) && checkSongListEquality(this.songs, other.songs);
        return Objects.equals(albumTitle, other.albumTitle) && Arrays.equals(this.songs, other.songs);
    }

    // private boolean checkSongListEquality(Song[] a, Song[] b) {
    //     if (a == null && b == null) {
    //         return true;
    //     } else if ( a == null || b == null) {
    //         return false;
    //     }

    //     if (a.length != b.length) {
    //         return false;
    //     }
    //     for (int i = 0; i < a.length; i++) {
    //         if (a[i] != b[i]) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    @Override
    public int hashCode() {
        // I do not believe that this is correct given the definition of equals provided above.
        return Objects.hash(albumTitle, songs);
    }


}