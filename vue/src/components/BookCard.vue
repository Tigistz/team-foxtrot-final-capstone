<template>
  <div class="book">
    <div class="book-title">The Alchemist</div>
    <img class="book-cover" src='../assets/SampleImage.jpg'/>
    <div class="book-author">Paulo Coelho</div>
    <button class="buy">Buy Now</button>


  </div>
 

</template>

<script>
export default {
    name: 'book-card',

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