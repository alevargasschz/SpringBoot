import { createBrowserRouter } from 'react-router';
import ProfileCard from '../components/ProfileCard';

const router = createBrowserRouter([
    {
        path: '/',
        element: <ProfileCard name="Alejandro" img="https://picsum.photos/id/101/200/300" age={19} />,
    },
    {
        path: '/login',
        element: <h1>Login</h1>,
    },
    {
        path: '/profile',
        Component: ProfileCard,
    }
], { basename: '/frontend' });

export default router;

