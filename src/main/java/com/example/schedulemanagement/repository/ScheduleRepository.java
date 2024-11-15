package com.example.schedulemanagement.repository;

import com.example.schedulemanagement.entity.Schedule;
import com.example.schedulemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Optional<Schedule> findUserById(Long id);

    // id로 Schedule 찾는데 없으면 404 NOT_FOUND 반환
    default Schedule findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id = " + id));
    }

    // id로 User 찾는데 없으면 404 NOT_FOUND 반환
    default Schedule findUserByIdOrElseThrow(Long id) {
        return findUserById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id = " + id));
    }

    Page<Schedule> findAllByOrderByModifiedAtDesc(Pageable pageable);
}
