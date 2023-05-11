package com.example.springrest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "people")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "passport_series")
    private String passportSeries;
    @Column(name = "passport_num")
    private String passportNum;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;
    @Column(name = "mob-num")
    private String mobNum;
    @Column(name = "email")
    private String email;
    @Column(name = "employed")
    private Boolean employed;
    @Column(name = "job-title")
    private String jobTitle;
    @Column(name = "main-address")
    private String mainAddress;
    @Column(name = "citizenship")
    private String citizenship;
}
