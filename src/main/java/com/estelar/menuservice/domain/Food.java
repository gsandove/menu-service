package com.estelar.menuservice.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "food")
@Entity
public class Food {
    private static final Long seriaVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    private String description;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "user_created", nullable = false)
    private String userCreated;

    @Column(name = "deleted_at", nullable = true)
    private Date deletedAt;

    @Column(name = "user_deleted", nullable = true)
    private String userDeleted;

}
