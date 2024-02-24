package com.hack.selectel.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "schedule_model")
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleModel 
{
    @Id
    private int id;
    @Column(name = "day_of_week")
    private String dow;
    @Column(name = "start_day")
    private String start;
    @Column(name = "end_day")
    private String end;
    @JoinColumn(name = "center_id")
    @ManyToOne
    @JsonIgnore
    private DonationCenter centerId;
    
    public ScheduleModel(int id)
    {
        this.id = id;
    }
}
