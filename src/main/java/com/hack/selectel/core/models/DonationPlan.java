package com.hack.selectel.core.models;

import java.util.Date;
import java.util.UUID;

import org.hibernate.type.YesNoConverter;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "donation_plan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonationPlan 
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id; // id плана 
    
    @JoinColumn(name = "user_id")
    @ManyToOne
    private UserModel userId; //id юзера
    @Column
    private String username;
    @Column(name = "first_name")
    private String firstName;
    @Column
    private String surname;
    @Column
    private String patronymic; //отчество
    @JoinTable
    @ManyToOne
    private DonationCenter donationCenter;
    @Temporal(TemporalType.DATE)
    @Basic
    @Column(name = "visit_date")
    private Date visitDate;
    @Column(name = "blood_component")
    private BloodComponent bloodComponent;
    @Column(name = "is_payment_required")
    @Convert(converter = YesNoConverter.class)
    private boolean isPayRequired;
    
    
}
