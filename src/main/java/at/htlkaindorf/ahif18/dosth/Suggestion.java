package at.htlkaindorf.ahif18.dosth;

import lombok.Data;

import java.util.Objects;

@Data
public class Suggestion {
    private String title;

    public Suggestion(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suggestion that = (Suggestion) o;
        return title.equals(that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
