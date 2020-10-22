package ua.murza.tdan.services;

import org.springframework.stereotype.Service;
import ua.murza.tdan.entities.Note;
import ua.murza.tdan.model.request.CreateNoteRequest;
import ua.murza.tdan.repositories.NoteRepository;
import ua.murza.tdan.repositories.UserRepository;

import java.time.LocalDateTime;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteService(NoteRepository noteRepository,
                       UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    public void createNote(final CreateNoteRequest request, String userId) {
        Note note = new Note();

        note.setAuthor(userRepository.findByUserId(userId));
        note.setTitle(request.getTitle());
        note.setText(request.getText());
        note.setImportant(request.isImportant());
        note.setDateTime(LocalDateTime.now());

        noteRepository.save(note);
    }

    public void updateNote() {

    }

    public void removeQueueNote() {

    }

    public void removeNote() {

    }

    public void shareNote() {

    }

    public void stopShareNote() {

    }
}
