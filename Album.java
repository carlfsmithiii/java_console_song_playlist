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
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null) {
            return false;
        }
        // if (!(o instanceof Album)) {
        //     return false;
        // }
        if (getClass() != o.getClass()) {
            return false;
        }
        Album album = (Album) o;
        return Objects.equals(albumTitle, album.albumTitle) && checkSongListEquality(this.songs, album.songs);
    }

    private boolean checkSongListEquality(Song[] a, Song[] b) {
        if (a == null && b == null) {
            return true;
        } else if ( a == null || b == null) {
            return false;
        }

        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumTitle, songs);
    }


}