import { Box, Typography } from '@mui/material';
import { useState, useEffect } from 'react';
import { getGames } from './services/games.service';

export default function Dashboard() {
    const [games, setGames] = useState([]);

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

    return (
        <Box
            display="grid"
            justifyContent="center"
            alignItems="center"
            minHeight="80vh"
        >
            <Typography variant="h3">Dashboard</Typography>
        </Box>
    );
}
