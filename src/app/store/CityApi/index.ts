import {createApi,  fetchBaseQuery} from "@reduxjs/toolkit/query/react";
import {ICity} from "../../../entities/Region";

export const cityApi = createApi({
    reducerPath: 'cityApi',
    baseQuery: fetchBaseQuery({
        baseUrl: 'http://localhost:5000',
    }),
    endpoints: build => ({
        getCityBySearch: build.query<ICity, string>({
            query: (queryString) => ({
                url: '/api/city/',
                query: {
                    query_str: queryString
                }
            })
        })
    })
})