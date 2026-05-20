import { createBrowserRouter } from 'react-router';
import ProfileCard from '../components/ProfileCard';
import Login from '../pages/Login/Login';
import Register from '../pages/Register/Register';

const router = createBrowserRouter([
    {
        path: '/',
        element: <ProfileCard name="Alejandro" img="https://picsum.photos/id/101/200/300" age={19} />,
    },
    {
        path: '/login',
        element: <Login />,
    },
    {
        path: '/register',
        element: <Register />,
    },
    {
        path: '/auth',
        children: [
            {
                element: <Login />,
                index: true,
            },
            {
                path: 'login',
                element: <Login />,
            },
            {
                path: 'register',
                element: <Register />
            }
        ]
    },
    {
        path: '/profile',
        element: <ProfileCard name="Alejandro" img="https://picsum.photos/id/101/200/300" age={19} />,
    }
], { basename: '/frontend' });

export default router;

