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
    FIRST_POSITIVE = 'O_PLUS',
    FIRST_NEGATIVE = 'O_MINUS',
    SECOND_POSITIVE = 'A_PLUS',
    SECOND_NEGATIVE = 'A_MINUS',
    THIRD_POSITIVE = 'B_PLUS',
    THIRD_NEGATIVE = 'B_MINUS',
    FOURTH_POSITIVE = 'AB_PLUS',
    FOURTH_NEGATIVE = 'AB_MINUS',
}

export type BloodComponentType =
    | BloodComponent.BLOOD
    | BloodComponent.PLASMA
    | BloodComponent.ERYTHROCYTES
    | BloodComponent.LEUKOCYTES
    | BloodComponent.PLATELETS
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
