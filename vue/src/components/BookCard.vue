<template>
  <div class="book">
    <div class="book-title"></div>
    <img class="book-cover" />
    <div class="book-author"></div>
    <div class="book-genre"></div>
    <button class="buy"></button>


  </div>
 

</template>

<script>



export default {
    name: 'book-card',
    data() {
        return {
            info: ''
        }
    },

    methods: {
       getBooks() {
           
       }
    }
}
</script>






























<style>
.book {  
  display: inline-block;
  width: 230px;
  height: 390px;
  box-shadow: 0 0 20px #aaa;
  margin: 25px;
  padding: 10px 10px 0 10px;
  vertical-align: top;
  transition: height 1s;
}

.book-cover {
    width: 100%;
    height: auto;
    display: block;

}

.book-title {
   margin-top: 12px;
   font-size: 20px;
   text-align: center; 
}

.book-author {

}

</style>