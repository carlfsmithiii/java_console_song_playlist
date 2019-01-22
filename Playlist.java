import java.util.ArrayList;

public class Playlist {
    private ArrayList<Album> albums;
    private LinkedList<Song> playlist;

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
}