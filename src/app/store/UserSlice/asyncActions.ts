import {AppDispatch} from "../index.ts";
import {userSlice} from "./index.ts";

export const fetchUsers = () => (dispatch: AppDispatch) => {
    try {
        dispatch(userSlice.actions.fetchUser())

    } catch (err) {
        dispatch(userSlice.actions.fetchUserError(JSON.stringify(err)))
    }
}