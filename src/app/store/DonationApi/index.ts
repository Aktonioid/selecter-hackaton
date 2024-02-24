import {createApi, fetchBaseQuery} from "@reduxjs/toolkit/query/react";

export const donationApi = createApi({
    reducerPath: 'donationApi',
    baseQuery: fetchBaseQuery({
        baseUrl: 'http://localhost:5000',
    }),
    endpoints: build => ({

    })
})