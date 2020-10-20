package ua.murza.tdan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.murza.tdan.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
