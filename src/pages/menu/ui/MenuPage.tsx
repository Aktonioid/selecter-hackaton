import {AppLink} from "../../../shared/ui/Link";
import classes from './Menu.module.css'

const MenuPage = () => {
    return (
        <main className={classes.menu}>
            <AppLink to='donations'>Донации</AppLink>
            <AppLink to='info'>Персональная информация</AppLink>
            <AppLink to='centers'>Центры Донации</AppLink>
            <AppLink to='donations/planned'>Запланированные донации</AppLink>
        </main>
    );
};

export default MenuPage;