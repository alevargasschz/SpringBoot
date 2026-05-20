import { Typography, Card, Button } from '@mui/material';
import { useState } from 'react';

export default function ProfileCard(props) {
    const name = props.name || 'Alejandro';
    const img = props.img || 'https://picsum.photos/id/101/200/300';
    const age = props.age || 19;
    
    const [likes, setLikes] = useState(0);
    
    const incrementLikes = () => {
        console.log('Likes incremented!');
        setLikes(likes + 1);
        setLikes(likes => likes + 3);
        setLikes(likes => likes + 2);
    };

    return (
        <Card 
            style={{ 
                padding: '20px', 
                margin: '20px', 
                textAlign: 'center', 
                display: 'flex', 
                flexDirection: 'column', 
                alignItems: 'center', 
                justifyContent: 'center'
            }}
            elevation ={10}
        >
            <Typography variant="h4" style={{ marginBottom: '10px' }}>
                {name}'s Profile
            </Typography>
            <img src={img} alt={`${name}'s profile picture`} />
            <Typography style={{ marginTop: '10px' }}>
                Age: {age}
            </Typography>
            <Typography>Likes {likes ?? 0}</Typography>
            <Button
                variant='contained'
                onClick={incrementLikes}
                // onClick={() => incrementLikes()}
            >
                Likes!
            </Button>
        </Card>
    );
}