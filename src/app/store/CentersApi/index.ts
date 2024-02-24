import {createApi, fetchBaseQuery} from "@reduxjs/toolkit/query/react";
import {BloodGroupType, IDonationCenter} from "../../../entities/DonationCenter";

interface queryParams {
    bloodGroup: BloodGroupType,
    cityId: number,
    regionId: string
}

export const centersApi = createApi({
    reducerPath: 'centersApi',
    baseQuery: fetchBaseQuery({
        baseUrl: 'http://localhost:5000',
    }),
    endpoints: build => ({
        getCenters: build.query<IDonationCenter[], queryParams>({
            query: (query) => ({
                url: '/api/blood_center/user/',
                query,
            })
        }),
        getAllCenters: build.query<IDonationCenter[], number>({
            query: (page) => ({
                url: '/api/blood_center/',
                query: {
                    page
                }
            })
        }),
        getCurrentDonationCenter: build.query<IDonationCenter, number>({
            query: (id) => ({
                url: `/api/blood_center/${id}`
            })
        })
    })
})