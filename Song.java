import java.time.Duration;
import java.util.Objects;

public class Song {
    private String title;
    private Duration duration;

    public Song(String title, Duration duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return this.title;
    }

    public Duration getDuration() {
        return this.duration;
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
        Song otherSong = (Song) otherObj;
        return Objects.equals(title, otherSong.title) && (this.duration.toMillis() == otherSong.duration.toMillis());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, duration.toMillis());
    }

}