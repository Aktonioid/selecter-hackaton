import {  createBrowserRouter } from "react-router-dom";
import { MenuPage } from "../../../pages/menu";
import { LoginPage } from "../../../pages/login";
import {DonationsPage} from "../../../pages/donations";
import {NewDonationPage} from "../../../pages/donations_new";
import OneDonationsPage from "../../../pages/donation_id/ui/OneDonationsPage.tsx";
import {UserInfoPage} from "../../../pages/user_info";

export const router = createBrowserRouter([
    {
        path: '',
        element: <MenuPage/>,
    },
    {
        path: 'login',
        element: <LoginPage/>,
    },
    {
        path: 'info',
        element: <UserInfoPage/>,
    },
    {
        path: 'donations',
        element: <DonationsPage/>,
        children: [
            {
                path: ':id',
                element: <OneDonationsPage/>,
            }

        ]
    },
    {
        path: 'donation/new',
        element: <NewDonationPage/>,
    },
])