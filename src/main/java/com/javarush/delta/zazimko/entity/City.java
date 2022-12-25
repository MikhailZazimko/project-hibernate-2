package com.javarush.delta.zazimko.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "city",schema = "movie")
public class City {
    @Id
    @Column(name="city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    @Column(name = "city")
    private String cityName;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;


}
