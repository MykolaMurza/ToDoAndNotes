package ua.murza.tdan.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "todo")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 45)
    private String title;
    @Column(length = 100)
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy  HH:mm:ss")
    private LocalDateTime start;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy  HH:mm:ss")
    private LocalDateTime deadline;
    private boolean finalized;
    private boolean urgent;

    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "user_id")
    private User author;
}
