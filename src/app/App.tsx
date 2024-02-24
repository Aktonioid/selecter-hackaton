import '@gravity-ui/uikit/styles/fonts.css';
import '@gravity-ui/uikit/styles/styles.css';
import { RouterProvider} from "react-router-dom";
import {router} from "../shared/configs/routeConfig";
import {Suspense} from "react";
import {AppLoader} from "../shared/ui/Loader";

const App = () => {
    return (
        <Suspense fallback={<AppLoader/>}>
            <RouterProvider router={router}/>
        </Suspense>
    );
};

export default App;