import {ICity} from "../Region";

export interface IDonationCenter {
    id: number;
    city: ICity;
    title: string;
    address: string;
    site: string;
    phoneNumbers: string[];
    schedule: ISchedule;
    o_plus: BloodGroupStatus;
    o_minus: BloodGroupStatus;
    a_plus: BloodGroupStatus;
    a_minus: BloodGroupStatus;
    b_plus: BloodGroupStatus;
    b_minus: BloodGroupStatus;
    ab_plus: BloodGroupStatus;
    ab_minus: BloodGroupStatus;
    blood: BloodComponentsStatus;
    plasma: BloodComponentsStatus;
    platelets: BloodComponentsStatus;
    erythrocytes: BloodComponentsStatus;
    leukocytes: BloodComponentsStatus;
}

export interface ISchedule {
    id: number;
    dow: string;
    start: string;
    end: string;
}

export type BloodGroupStatus = 'NEED' | 'NO_NEED' | 'UNKNOWN';
export type BloodComponentsStatus = 'ACCEPT' | 'NO_ACCEPT' | 'UNKNOWN';
export enum BloodGroup {
    FIRST_POSITIVE = 'o_plus',
    FIRST_NEGATIVE = 'o_minus',
    SECOND_POSITIVE = 'a_plus',
    SECOND_NEGATIVE = 'a_minus',
    THIRD_POSITIVE = 'b_plus',
    THIRD_NEGATIVE = 'b_minus',
    FOURTH_POSITIVE = 'ab_plus',
    FOURTH_NEGATIVE = 'ab_minus',
}

export type BloodComponentType =
    | BloodComponent.BLOOD
    | BloodComponent.PLASMA
    | BloodComponent.ERYTHROCYTES
    | BloodComponent.LEUKOCYTES
    | BloodComponent.PLATELETS

export type BloodGroupType =
    | BloodGroup.FIRST_NEGATIVE
    | BloodGroup.FIRST_POSITIVE
    | BloodGroup.SECOND_NEGATIVE
    | BloodGroup.SECOND_POSITIVE
    | BloodGroup.THIRD_NEGATIVE
    | BloodGroup.THIRD_POSITIVE
    | BloodGroup.FOURTH_NEGATIVE
    | BloodGroup.FOURTH_POSITIVE

    export enum BloodComponent {
    BLOOD = 'BLOOD',
    PLASMA = 'PLASMA',
    PLATELETS = 'PLATELETS',
    ERYTHROCYTES = 'ERYTHROCYTES',
    LEUKOCYTES = 'LEUKOCYTES',
}
export const BloodComponentObject: Record<BloodComponent, string>  = {
    [BloodComponent.BLOOD]: 'кровь',
    [BloodComponent.PLASMA]: 'плазма',
    [BloodComponent.PLATELETS]: 'тромбоциты',
    [BloodComponent.ERYTHROCYTES]: 'эритроциты',
    [BloodComponent.LEUKOCYTES]: 'лейкоциты'
}
