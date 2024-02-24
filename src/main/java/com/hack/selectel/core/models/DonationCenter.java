package com.hack.selectel.core.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "donation_center")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonationCenter 
{
    @Id
    private int id;
    @JoinColumn
    @ManyToOne
    private City city;
    private String title;
    private String address;
    private String site;
    @JoinColumn(name = "phone_numbers")
    @OneToMany
    private Set<DonationCenterPhones> phoneNumbers;
    @JoinColumn(name = "schedule_id")
    @OneToMany
    private Set<ScheduleModel> schedule;
    //резусы и т.д
    BloodGroupStatus o_plus;
    BloodGroupStatus o_minus;
    BloodGroupStatus a_plus;
    BloodGroupStatus a_minus;
    BloodGroupStatus b_plus;
    BloodGroupStatus b_minus;
    BloodGroupStatus ab_plus;
    BloodGroupStatus ab_minus;
    //принимаемые компоненты
    BloodComponentsStatus blood;
    BloodComponentsStatus plasma;
    BloodComponentsStatus platelets;
    BloodComponentsStatus erythrocytes;
    BloodComponentsStatus leukocytes;

    public DonationCenter(int id)
    {
        this.id = id;
    }
}
