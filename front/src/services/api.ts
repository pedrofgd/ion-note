import axios from 'axios';

const api = axios.create({
   baseURL: 'http://20.226.53.145:8080'
})

export default api;