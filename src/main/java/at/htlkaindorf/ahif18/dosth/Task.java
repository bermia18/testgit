package at.htlkaindorf.ahif18.dosth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private String title;
    private String from;
    private String to;
    private String description;
    private boolean checked;
}
