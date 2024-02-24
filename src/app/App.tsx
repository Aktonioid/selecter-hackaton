import '@gravity-ui/uikit/styles/fonts.css';
import '@gravity-ui/uikit/styles/styles.css';
import { RouterProvider} from "react-router-dom";
import {router} from "../shared/configs/routeConfig";
const App = () => {
    return (
        <RouterProvider router={router}/>
    );
};

export default App;