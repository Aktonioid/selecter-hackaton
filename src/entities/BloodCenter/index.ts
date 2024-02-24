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

export type BloodGroupStatus = 'need' | 'no_need' | 'unknown';
export type BloodComponentsStatus = 'accept' | 'no_accept' | 'unknown';
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

export enum BloodComponent {
    BLOOD = 'blood',
    PLASMA = 'plasma',
    PLATELETS = 'platelets',
    ERYTHROCYTES = 'erythrocytes',
    LEUKOCYTES = 'leukocytes',
}
