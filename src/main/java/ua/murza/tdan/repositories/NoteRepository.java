package ua.murza.tdan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.murza.tdan.entities.Note;

import java.time.LocalDate;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    Note findByNoteId(long id);

    @Query(value = "DELETE FROM Note as n WHERE n.iReadyToRemoveIt = true AND n.removeDate = ?1")
    void deleteAllByTodayDate(LocalDate localDate);
}
