import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import { RouterProvider } from 'react-router';
import router from './router/Router';
import AuthContext from './context/AuthContext';

createRoot(document.getElementById('root')).render(
    <StrictMode>
        <AuthContext>
            <RouterProvider router={router}></RouterProvider>
        </AuthContext>
    </StrictMode>,
);
