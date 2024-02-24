package com.hack.selectel.core.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "region")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Region 
{
    @Id
    private int id;
    @Column
    private String title;

    public Region(int id)
    {
        this.id =id;
    }
}
