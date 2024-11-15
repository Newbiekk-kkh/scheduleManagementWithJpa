package com.example.schedulemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 영속성 전이 Schedule -> comment
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private List<Comment> comment = new ArrayList<>();

    public static void remove(final EntityManager entityManager) {
        Schedule schedule = entityManager.find(Schedule.class, 1L);
        entityManager.remove(schedule);
    }

    public Schedule () {
    }

    public Schedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void updateSchedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
