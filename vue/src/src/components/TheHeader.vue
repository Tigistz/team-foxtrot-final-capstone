<template>
   <div>





<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <!-- <a class="navbar-brand" href="#">Team Foxtrot Books</a> -->

 
      <img id="fox-logo" src="../assets/fox-only-2.png"/>
      
    

  <router-link class="navbar-brand" v-bind:to="{ name: 'home'}">Foxtrot Book Library</router-link>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <router-link class="nav-link" v-bind:to="{ name: 'home'}">Home</router-link>
      </li>
      <li class="nav-item">
        <!-- <a class="nav-link" href="#">Search anchor Link</a> -->
        <router-link class="nav-link" v-bind:to="{ name: 'search'}">Search</router-link>
      </li>
      <li class="nav-item">
        <!-- <a class="nav-link" href="#">Mybooks anchor Link</a> -->
        <router-link class="nav-link" v-bind:to="{ name: 'myBooks'}" v-if="$store.state.token != ''">My Books</router-link>
      </li>
            <li class="nav-item">
        <!-- <a class="nav-link" href="#">Mybooks anchor Link</a> -->
        <router-link class="nav-link" 
        v-bind:to="{ name: 'addBook'}"
        v-if="$store.state.token != ''"
        >Add a Book</router-link>
      </li>
      <li class="nav-item">
        <!-- <a class="nav-link disabled" href="#">Login Anchor</a> -->
        <router-link class="nav-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token == ''">Login</router-link>
        <router-link class="nav-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </li>
    </ul>
  </div>
</nav>


       </div> 
</template>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


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

.navbar-brand {
  margin-left: 2vw;
}
.navbar {
  color:#23272B;
  display: flex;
  justify-content: space-between;
}
.navbar-expand-lg .navbar-collapse {
  background:#23272B;
  justify-content: flex-end;
  margin-right: 2vw;
}

#fox-logo {
  
  width:110px;
  height:auto;
  

  
}
 
 
</style>