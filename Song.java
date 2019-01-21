import java.time.Duration;

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
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null) {
            return false;
        }
        // if (!(o instanceof Song)) {
        //     return false;
        // }
        if (getClass() != o.getClass()) {
            return false;
        }
        Song song = (Song) o;
        return Objects.equals(title, song.title) && (this.duration.toMillis() == song.duration.toMillis());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, duration.toMillis());
    }

}