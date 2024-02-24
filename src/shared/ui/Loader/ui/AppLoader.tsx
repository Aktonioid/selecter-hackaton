import {Loader} from "@gravity-ui/uikit";
import classes from './AppLoader.module.css'
export const AppLoader = () => {
    return (
        <div className={classes.container}>
            <Loader size='l'/>
        </div>
    );
};

