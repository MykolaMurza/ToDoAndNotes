package ua.murza.tdan.services;

import org.springframework.stereotype.Service;
import ua.murza.tdan.entities.Note;
import ua.murza.tdan.model.request.CreateNoteRequest;
import ua.murza.tdan.model.request.DeleteNoteRequest;
import ua.murza.tdan.model.request.UpdateNoteRequest;
import ua.murza.tdan.repositories.NoteRepository;
import ua.murza.tdan.repositories.UserRepository;

import java.time.LocalDate;
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

    public void createNote(final CreateNoteRequest request, final String userId) {
        Note note = new Note();

        note.setAuthor(userRepository.findByUserId(userId));
        note.setTitle(request.getTitle());
        note.setText(request.getText());
        note.setImportant(request.isImportant());
        note.setDateTime(LocalDateTime.now());
        note.setIReadyToRemoveIt(false);

        noteRepository.save(note);
    }

    public void updateNote(final UpdateNoteRequest request, final String userId) {
        Note note = noteRepository.findByNoteId(request.getId());

        if (userRepository.findByUserId(userId).equals(note.getAuthor())) {
            note.setTitle(request.getTitle());
            note.setText(request.getText());
            note.setImportant(request.isImportant());
            note.setDateTime(LocalDateTime.now());

            noteRepository.save(note);
        } else {
            //todo Success-ответ по поводу того, что пользователь не имеет доступа к сообщению.
        }

    }

    public void removeNote(final DeleteNoteRequest request, final String userId) {
        Note note = noteRepository.findByNoteId(request.getId());

        if (userRepository.findByUserId(userId).equals(note.getAuthor())) {
            if (!request.isByQueue()) {
                noteRepository.delete(note);
            } else {
                note.setIReadyToRemoveIt(true);
                note.setRemoveDate(LocalDate.now().plusDays(14));
            }
        } else {
            //todo Success-ответ по поводу того, что пользователь не имеет доступа к сообщению.
        }
    }

    public void shareNote() {

    }

    public void stopShareNote() {

    }
}
