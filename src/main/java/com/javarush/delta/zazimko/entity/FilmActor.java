//package com.javarush.delta.zazimko.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.time.LocalDateTime;
//import java.util.Date;
//
////@NoArgsConstructor
////@AllArgsConstructor
////@ToString
////@Data
////@Entity
////@Table(name = "film_actor", schema = "movie")
//public class FilmActor {
//    @ManyToMany
//    @JoinColumn(name = "film_id")
//    private Film film;
//    @OneToOne
//    @JoinColumn(name ="actor_id")
//    private Actor actor;
//    @UpdateTimestamp
//    @Column(name = "last_update")
//    private LocalDateTime lastUpdate;
//}
