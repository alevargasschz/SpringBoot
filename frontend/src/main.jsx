import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import Landing from './Landing';
import Profile from './Profile';

createRoot(document.getElementById('root')).render(
    <StrictMode>
        <h1>Hello, World!</h1>
        <p>Welcome to your React application.</p>
        <Landing />
        <Profile />
    </StrictMode>,
);
