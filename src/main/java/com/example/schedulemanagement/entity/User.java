package com.example.schedulemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "user")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    // 영속성 전이 user -> schedule
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Schedule> schedule = new ArrayList<>();

    // 영속성 전이 user -> comment
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comment = new ArrayList<>();

    public static void remove(final EntityManager entityManager) {
        User user = entityManager.find(User.class, 1L);
        entityManager.remove(user);
    }

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
