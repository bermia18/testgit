package at.htlkaindorf.ahif18.dosth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Objects;

/**
 * Suggestion Data class
 * @project DoSth.
 * @author Michael M, Michael B
 * @since 13.06.2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Suggestion {
    private int id;
    private String title;

    /**
     * Constructor for the Suggestions
     */
    public Suggestion(String title, int id) {
        this.id = id;
        this.title = title;
    }


    /**
     * Override method equals to only compare the title of suggestions
     * @return boolean true or false if the titles to compare are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suggestion that = (Suggestion) o;
        return title.equals(that.title);
    }

    /**
     * Override Method
     */
    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
