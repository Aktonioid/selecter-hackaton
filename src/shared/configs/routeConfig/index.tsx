import {  createBrowserRouter } from "react-router-dom";
import { MenuPage } from "../../../pages/menu";
import { LoginPage } from "../../../pages/login";
import {DonationsPage} from "../../../pages/donations";
import {NewDonationPage} from "../../../pages/donations_new";
import OneDonationsPage from "../../../pages/donation_id/ui/OneDonationsPage.tsx";
import {UserInfoPage} from "../../../pages/user_info";
import {PlannedPage} from "../../../pages/planned_donations";
import {CentersPage} from "../../../pages/centers";

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
    },
    {
        path: 'donations/:id',
        element: <OneDonationsPage/>,
    },
    {
        path: 'donation/new',
        element: <NewDonationPage/>,
    },
    {
        path: 'donations/planned',
        element: <PlannedPage/>
    },
    {
        path: 'centers',
        element: <CentersPage/>
    }
])