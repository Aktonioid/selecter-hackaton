import ReactDOM from 'react-dom/client'
import App from './app/App.tsx'
import RootProvider from "./app/providers/RootProvider";

const container = document.getElementById('root')
if(!container) throw new Error('No container to render app')
const root =  ReactDOM.createRoot(container)
root.render(
    <RootProvider>
        <App />
    </RootProvider>,
)
