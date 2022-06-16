package at.htlkaindorf.ahif18.dosth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * Dataclass for the Tasks
 * @project DoSth.
 * @author Michael Maier
 * @since 16.05.2022
 */
public class Task {
    private int id;
    private String type;
    private String title;
    private LocalDate from;
    private LocalDate to;
    private String description;
    private boolean checked;
}
