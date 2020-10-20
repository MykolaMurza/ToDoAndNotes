package ua.murza.tdan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.murza.tdan.entities.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
