import { Box, Typography } from '@mui/material';
import { useState, useEffect } from 'react';
import { getGames } from './services/games.service';
import AuthContext from '../../context/AuthContext';
import { useContext } from 'react';
import { Button } from '@mui/material';
import { Link } from 'react-router';

export default function Dashboard() {
    const [games, setGames] = useState([]);
    const { logout } = useContext(AuthContext);

    useEffect(() => {
        const fetchGames = async () => {
            try {
                const gamesData = await getGames();
                setGames(gamesData);
            } catch (error) {
                console.error('Error fetching games:', error);
            }
        };
        fetchGames();
    }, [games.length]); // Solo volver a ejecutar si la longitud de games cambia

    const logoutHandler = () => {
        logout();
    };

    return (
        <Box
            display="grid"
            justifyContent="center"
            alignItems="center"
            minHeight="80vh"
        >
            <Typography variant="h3">Dashboard</Typography>
            <Button component={Link} to="auth/login" onClick={logoutHandler}>
                Logout
            </Button>
        </Box>
    );
}
