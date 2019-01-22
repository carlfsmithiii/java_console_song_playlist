import java.time.Duration;
import java.util.Objects;

public class Song {
    private String title;
    private Duration duration;

    public Song(String title, Duration duration) {
        this.title = title;
        this.duration = duration;
    }

    public Song(String title, int minutes, int seconds) {
        this(title, Duration.ofMinutes(minutes).plusSeconds(seconds));
    }

    public String getTitle() {
        return this.title;
    }

    public Duration getDuration() {
        return this.duration;
    }

    public void display() {
        System.out.printf("Song title: %s\t\tDuration: %d:%02d\n", this.title, this.duration.toMinutesPart(),
                this.duration.toSecondsPart());
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