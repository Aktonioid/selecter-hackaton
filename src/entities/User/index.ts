import {ICity} from "../Region";
import {BloodGroup} from "../DonationCenter";

export interface IUser {
    id: string;
    userName: string; // Из телеги
    firstName: string;
    surname: string;
    patronymic: string;
    birthDate: Date;
    gender: Gender;
    donations: number;
    city: ICity;
    bloodGroup: BloodGroup;
    kell: KellFactor;
}

export type Gender = 'male' | 'female'
export type KellFactor = 'positive' | 'negative'



