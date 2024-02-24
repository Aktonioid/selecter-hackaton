import {FC} from "react";
import {DonationCardProps} from "./types.ts";
import {Button, Card, Label, TextInput} from "@gravity-ui/uikit";
import {TrashBin} from '@gravity-ui/icons';
import {CircleInfoFill} from '@gravity-ui/icons';
import {DatePicker} from "@consta/uikit/DatePicker";
import {BloodComponentObject} from "../../../../entities/DonationCenter";
import classes from './DonationCard.module.css'

export const DonationCard: FC<DonationCardProps> = ({donation}) => {
    const date = new Date(donation.visitDate)
    const component = BloodComponentObject[donation.bloodComponent]
    return (
        <Card className={classes.card}>
            <div>
                <Label theme='info'>Центр</Label>
                <TextInput value={donation.donationCenter.title} disabled={true}/>
            </div>
            <div>
                <Label theme='info'>Дата</Label>
                <DatePicker value={date} disabled={true}/>
            </div>
            <div>
                <Label theme='info'>компонент</Label>
                <TextInput value={component} disabled={true}/>
            </div>
            <div>
                <Button>
                    <TrashBin/>
                </Button>
                <Button>
                    <CircleInfoFill/>
                </Button>
            </div>
        </Card>
    );
};

