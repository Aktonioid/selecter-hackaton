import {createSlice, PayloadAction} from "@reduxjs/toolkit";
import {IUser} from "../../../entities/User";

export interface UserState {
    user: IUser | null;
    error: string | null,
    loading: boolean,
}

const initialState:UserState = {
    user: null,
    error: null,
    loading: false,
}

export const userSlice = createSlice({
    name: 'userSlice',
    initialState,
    reducers: {
        fetchUser: (state) => {
            state.loading = true;
            state.error = null;
            state.user = null;
        },
        fetchUserSuccess: (state, action: PayloadAction<IUser>) => {
            state.loading = false;
            state.user = action.payload;
            state.error = null;
        },
        fetchUserError: (state, action: PayloadAction<string>) => {
            state.loading = false;
            state.error = action.payload;
        },
    }
})