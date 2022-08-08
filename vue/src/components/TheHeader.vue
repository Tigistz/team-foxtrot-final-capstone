




<template>
   <div>
       <div id = "container">
            <img id="banner-image" src=" " alt="">
    
            <nav>
                 <router-link v-bind:to="{ name: 'book'}">Book</router-link>
                <a href="#">About</a>
                <div> <router-link v-bind:to="{ name: 'search'}">Search</router-link></div>
                 <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.currentToken == ''">Login</router-link>
                 <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.currentToken != ''">Logout</router-link>
            
             <p v-if="$store.state.currentToken != ''">Welcome {{$store.state.currentUser.username}}</p>
            </nav>
            </div>
       </div> 

</template>

<script>
export default {
    name: 'the-header',
    data() {
        return {
        }
    }
}
</script>

<style scoped>
  #container {
     display: flex;
     flex-direction: column;
     justify-content: center;
     align-items: center;
  }

  #banner-image {
      margin-bottom: 40px;
      width: 10%;
      height: auto;
  }

  nav {
      margin-bottom: 40px;
  }

  nav a {
      padding: 15px 25px;
      background-color: rgb(3, 189, 3);
      color:black
  }

  nav a:hover {
      background-color: green;
      color: white;
  }
</style>