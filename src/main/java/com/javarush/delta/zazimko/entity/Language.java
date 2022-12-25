package com.javarush.delta.zazimko.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "language", schema = "movie")
public class Language {
    @Id
    @Column(name = "language_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;
    @Column(name = "name", columnDefinition = "char")
    private String languageName;
    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
