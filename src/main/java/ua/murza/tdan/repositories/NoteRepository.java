package ua.murza.tdan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.murza.tdan.entities.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    Note findByNoteId(long id);
}
