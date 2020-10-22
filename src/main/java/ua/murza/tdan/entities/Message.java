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
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long messageId;

    private String text;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy  HH:mm:ss")
    private LocalDateTime dateTime;
    private boolean received;

    @ManyToOne
    @JoinColumn(name = "sender", referencedColumnName = "user_id")
    private User sender;
    @ManyToOne
    @JoinColumn(name = "receiver", referencedColumnName = "user_id")
    private User receiver;
}
