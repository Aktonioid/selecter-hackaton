package com.hack.selectel.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "donation_center_phones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonationCenterPhones 
{
    @Id
    private int id;
    private String phone;
    @JsonIgnore
    @JoinColumn(name = "cneter_id")
    @ManyToOne
    private DonationCenter centerId;    
    
}
