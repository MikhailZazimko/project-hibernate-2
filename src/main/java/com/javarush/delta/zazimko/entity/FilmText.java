package com.javarush.delta.zazimko.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "film_text", schema = "movie")
public class FilmText {
    @Id
    @Column(name = "film_id")
    private Short id;
    @OneToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @Column(name = "title")
    private String title;
    @Column(name = "description",columnDefinition = "text")
    @Type(type = "text")
    private String description;
}
