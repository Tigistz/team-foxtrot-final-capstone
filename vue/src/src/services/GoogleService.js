import axios from "axios";

const api_key = '&key=AIzaSyA2SB7helUW9bOBwnGTglWfkA31h0ovovg'

export default {
    getBookList(filter, query){
        return axios.get('https://www.googleapis.com/books/v1/volumes?q=' + filter + query + '&orderBy=relevance&maxResults=9' + api_key);
    }
}