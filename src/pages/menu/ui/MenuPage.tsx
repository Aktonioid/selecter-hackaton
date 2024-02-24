import {AppLink} from "../../../shared/ui/Link";


const MenuPage = () => {
    return (
        <main>
            <AppLink to='donations'>Донации</AppLink>
            <AppLink to='info'>Персональная информация</AppLink>
            <AppLink to='centers'>Центры Донации</AppLink>
            <AppLink to='donations/planned'>Запланированные донации</AppLink>

        </main>
    );
};

export default MenuPage;