package com.hack.selectel.core.models;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_model")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username; // из телеги
    @Column(name = "first_name")
    private String firstName;
    @Column
    private String surname;
    @Column
    private String patronymic; //отчество
    @Temporal(TemporalType.DATE)
    @Basic
    @Column(name = "birth_date")
    private Date birthDate;
    private Gender gender;
    private int donations; // сколько донаций он сделал
    @JoinTable
    @ManyToOne
    private City city;
    @Column(name = "blood_group")
    private BloodGroup bloodGroup;
    private KellEnum kell;

    public UserModel(UUID id)
    {
        this.id = id;
    }
}
