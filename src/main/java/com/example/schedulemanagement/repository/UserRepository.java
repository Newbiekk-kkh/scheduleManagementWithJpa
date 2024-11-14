package com.example.schedulemanagement.repository;

import com.example.schedulemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);

    default User findUserByUsernameOrElseThrow(String username) {
        return findUserByUsername(username)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Does not exists username = " + username )
                );
    }

    default User findUserByIdOrElseThrow(Long id) {
        return findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Does not exists id = " + id )
                );
    }
}
