<template>
  <nav>
    <v-app-bar flat>
      <v-app-bar-nav-icon class="grey--text" @click="drawer = !drawer"></v-app-bar-nav-icon>

      <v-avatar size="50">
          <v-img class="mx-2" src="/logo-transparent-reading-logo.png" max-height="50" max-width="50" contain></v-img>
      </v-avatar>

      <v-toolbar-title class="text-uppercase grey--text">
        <span>Foxtrot Bookie</span>
        <span class="font-weight-light">&nbsp;Library</span>
      </v-toolbar-title>

      <v-spacer></v-spacer>

      <v-btn text color="grey" router :to="{ name: 'home' }">
        <span>Home</span>
        <v-icon right>mdi-home-assistant</v-icon>
      </v-btn>

      <v-btn text color="grey" router :to="{ name: 'about' }">
        <span>About</span>
        <v-icon right>mdi-information-outline</v-icon>
      </v-btn>

      <v-btn text color="grey" router :to="{ name: 'logout' }">
        <span>Log Out</span>
        <v-icon right>mdi-exit-to-app</v-icon>
      </v-btn>
    </v-app-bar>

    <v-navigation-drawer app v-model="drawer" temporary color="#1034A6">
      <v-row justify="center">
        <v-col cols="5" class="ma-10">
          <v-avatar size="100">
            <img src="/nav-drawer-library-book-logo.png" />
          </v-avatar>
        </v-col>
      </v-row>

      <v-list-item v-for="link in links" :key="link.text" router :to="link.route" class="font-weight-light, ma-2">
          <v-list-item-action>
            <v-icon class="white--text">{{ link.icon }}</v-icon>
          </v-list-item-action>
          <v-list-item-title class="font-weight, white--text">{{link.text}}</v-list-item-title>
      </v-list-item>
    </v-navigation-drawer>
  </nav>
</template>

<script>
export default {
  data() {
    return {
      drawer: false,
      links: [
               {
          icon: "mdi-home-assistant",
          text: "Home",
          route: "/",
          role: "ROLE_USER"
        },
            {
          icon: "mdi-information-outline",
          text: "About",
          route: "/about",
          role: "ROLE_USER"
        },
      
          {
          icon: "mdi-email-send-outline",
          text: "Email",
          route: "/emails",
          role: "ROLE_USER"
        },
      
      ],
    };
  },
};
</script>

<style>
  
</style>