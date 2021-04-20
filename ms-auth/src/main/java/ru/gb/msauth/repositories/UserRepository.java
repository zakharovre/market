package ru.gb.msauth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.msauth.models.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername (String username);

}
