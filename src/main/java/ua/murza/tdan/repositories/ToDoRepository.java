package ua.murza.tdan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.murza.tdan.entities.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
