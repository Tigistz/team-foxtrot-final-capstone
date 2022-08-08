import axios from 'axios';

export default {

    search (searchType, searchString){
        return axios.get('https://www.googleapis.com/books/v1/volumes?q=' + searchType + searchString);
    }
}