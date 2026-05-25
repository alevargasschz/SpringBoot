import axiosClient from '../../../lib/axios/axiosClient';

export async function getGames() {
    try {
        const response = await axiosClient.get('/games');
        return response.data;
    } catch (error) {
        console.error('Error fetching games:', error);
        throw error;
    }
}
