import axiosClient from '../../../lib/axios/axiosClient';

export async function login(username, password) {
    try {
        const response = await axiosClient.post('/auth/login', {username,password,});
        console.log('Login succesful:', response.data);
        return response.data;
    } catch (error) {
        console.error('Login failed:', error);
        throw error;
    }
}
