package com.hack.selectel.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "city")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City 
{
    @Id
    private int id;
    @Column
    private String title;

    @JoinTable
    @ManyToOne
    @JsonIgnore
    Region region;

    public City(int id)
    {
        this.id = id;
    }
}
