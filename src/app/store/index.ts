import {configureStore} from "@reduxjs/toolkit";
import {userSlice} from "./UserSlice";
import {centersApi} from "./CentersApi";
import {cityApi} from "./CityApi";

export const store = configureStore({
    reducer: {
        user: userSlice.reducer,
        [centersApi.reducerPath]: centersApi.reducer,
        [cityApi.reducerPath]: cityApi.reducer
    },
    middleware: getDefaultMiddleware =>
        getDefaultMiddleware().concat(centersApi.middleware, cityApi.middleware)
})


export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch