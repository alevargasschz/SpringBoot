import { useRef, useState } from 'react';
import { Box, Typography, TextField, Button, Paper, Stack } from '@mui/material';
import login from '../Login/services/login.service';
import { useNavigate } from 'react-router';

export default function Login() {
    const ref = useRef();
    const nav = useNavigate();

    const [user, setUser] = useState({
        username: '',
        password: '',
        error: null,
    });

    const onSubmit = (e) => {
        e.preventDefault(); // Evitar que el formulario se envíe de forma tradicional
        const formData = new FormData(ref.current);
        const data = Object.fromEntries(formData.entries());
        const response = login(data.username, data.password);
        localStorage.setItem('token', response.token);
        nav('/profile');
    };

    return (
        <Box
            display="grid"
            justifyContent="center"
            alignItems="center"
            minHeight="80vh"
            p={2}
            placeItems="center"
        >
            <Paper elevation={3} sx={{ p: 4, width: 360 }}>
                <Typography variant="h5" mb={2} align="center">
                    Iniciar sesión
                </Typography>
                <Stack component="form" ref={ref} onSubmit={onSubmit} spacing={3}>
                    <TextField
                        label="Username"
                        fullWidth
                        margin="normal"
                        value={user.username}
                        onChange={(e) => setUser({ ...user, username: e.target.value })}
                    />
                    <TextField
                        label="Contraseña"
                        type="password"
                        fullWidth
                        margin="normal"
                        value={user.password}
                        onChange={(e) => setUser({ ...user, password: e.target.value })}
                    />
                    {user.error && (
                        <Typography color="error" variant="body2" mt={1}>
                            {user.error}
                        </Typography>
                    )}
                    <Button type="submit" variant="contained" color="primary" fullWidth sx={{ mt: 2 }}>
                        Entrar
                    </Button>
                </Stack>
            </Paper>
        </Box>
    );
}