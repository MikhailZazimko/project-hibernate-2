package com.javarush.delta.zazimko.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Collection;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "category", schema = "movie")
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;
    @Column(name = "name")
    private String categoryName;
    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    @ManyToMany
    @JoinTable(name = "film_category"
            ,joinColumns =@JoinColumn(name = "category_id",referencedColumnName = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id",referencedColumnName = "film_id"))
    private Collection<Film> films;
}
