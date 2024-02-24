import {FC} from "react";
import {AppLinkProps} from "./types";
import {Link} from "react-router-dom";
import {Card, Link as UILink} from "@gravity-ui/uikit";
import classes from "./AppLink.module.css";
export const AppLink:FC<AppLinkProps> = ({children, ...other}) => {
    return (
        <Card className={classes.card} theme='warning'>
            <Link {...other} className={classes.link}>
                <UILink href={''}>{children}</UILink>
            </Link>
        </Card>

    );
};

