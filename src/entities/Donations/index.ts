import {BloodComponent, IDonationCenter} from "../DonationCenter";

export interface IDonation {
    id: string;
    userId: string;
    username: string;
    firstName: string;
    surname: string;
    patronymic: string;
    donationCenter: IDonationCenter;
    visitDate: number;
    bloodComponent: BloodComponent;
    isPayRequired: boolean;
}

export interface IDonationPlan {
    id: string;
    userId: string;
    username: string;
    firstName: string;
    surname: string;
    patronymic: string;
    donationCenter: IDonationCenter;
    visitDate: Date;
    bloodComponent: BloodComponent;
    isPayRequired: boolean;
}