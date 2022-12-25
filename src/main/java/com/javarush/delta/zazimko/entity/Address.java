package com.javarush.delta.zazimko.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "address", schema = "movie")
public class Address {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    @Column(name = "address")
    private String addressName;
    @Column(name = "address2")
    private String addressName2;
    @Column(name = "district")
    private String districtName;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "phone")
    private String  phone;
    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

}
