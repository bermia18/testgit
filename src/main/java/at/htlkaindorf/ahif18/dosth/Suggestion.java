package at.htlkaindorf.ahif18.dosth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Suggestion {
    private int id;
    private String title;
    private int likelyValue;

    public Suggestion(String title, int id) {
        this.id = id;
        this.title = title;
        likelyValue = 1;
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
