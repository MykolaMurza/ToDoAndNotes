package ua.murza.tdan.services;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ua.murza.tdan.repositories.NoteRepository;

import java.time.LocalDate;

@Service
@EnableScheduling
public class ScheduleService {
    private final NoteRepository noteRepository;

    public ScheduleService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Scheduled(cron = "0 4 * * * ", zone = "Europe/Kyiv")
    public void removeQueuedNotes() {
        noteRepository.deleteAllByTodayDate(LocalDate.now());
    }
}
