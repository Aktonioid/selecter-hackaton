import {ThemeProvider} from "@gravity-ui/uikit";
import React from "react";
import {Provider} from "react-redux";
import {store} from "../../store";
import {useTelegram} from "../../../shared/hooks/useTelegramData.ts";

interface RootProviderProps {
    children: React.ReactElement;
}
const RootProvider:React.FC<RootProviderProps> = ({children}) => {
    const tg = useTelegram()
    return (
        <ThemeProvider theme={ tg.colorScheme ? tg.colorScheme : 'light' } >
            <Provider store={store}>
                {children}
            </Provider>
        </ThemeProvider>
    );
};

export default RootProvider;