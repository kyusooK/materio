<template>
  <v-app id="inspire">
        <Snackbar/>
        <v-col cols="10" style="margin: 0px; padding: 0px;">
            <v-main>
                <v-container v-if="urlPath" style="max-width:100vw !important;" class="py-8 px-6 mt-10" fluid>
                    <router-view></router-view>
                </v-container>
                <v-container v-else class="py-8 px-6 mt-10" fluid>
                    <v-row>
                        <v-card
                            v-for="(card, index) in cards"
                            :key="index"
                            class="mx-auto"
                            style="height:300px; width:300px; margin-bottom:20px;"
                            outlined
                        >
                            <v-list-item>
                                <v-list-item-avatar class="mx-auto" size="80" style="margin-top:80px;">
                                    <v-icon color="primary" size="64">mdi-apps</v-icon>
                                </v-list-item-avatar>
                            </v-list-item>
                            
                            <v-card-actions>
                            <v-tooltip bottom>
                                <template v-slot:activator="{ on }">
                                    <v-btn
                                        v-on="on"
                                        class="mx-auto"
                                        outlined
                                        rounded
                                        :to="card.link"
                                        @click="changeUrl()"
                                        style="font-weight:500; font-size:20px; border:solid 2px; max-width:250px; overflow:hidden"
                                    >
                                        {{ card.text }}
                                    </v-btn>
                                </template>
                                <span>{{ card.text }}</span>
                            </v-tooltip>
                            </v-card-actions>
                        </v-card>
                    </v-row>
                </v-container>
            </v-main>
        </v-col>
    </v-app>
</template>

<script>
import { ref, onMounted, computed } from 'vue';

export default {
  name: 'App',
  data: () => ({
    basic: [
      { key: 'companies', name: 'Company', url: '/companies' },
      { key: 'inventory', name: 'Inventory', url: '/inventories' },
      { key: 'ranks', name: 'Rank', url: '/ranks' },
    ],
    useComponent: "",
    drawer: true,
    components: {},
    sideBar: true,
    urlPath: null,
    menus: [
      {
        id: 'basic',
        title: 'Basic',
        icon: 'ri:home-6-line',
        items: [
          { key: 'companies', url: '/companies', name: 'Company' },
          { key: 'inventory', url: '/inventories', name: 'Inventory' },
          { key: 'sales', url: '/sales', name: 'Sales' },
        ],
      },
    ],
    cards: [
      {
        text: 'Company',
        link: '/companies',
      },
      {
        text: 'Inventory',
        link: '/inventories',
      },
      {
        text: 'Rank',
        link: '/finance',
      },
    ],
    activeMenu: null,
  }),

  async created() {
    var path = document.location.href.split("#/")
    this.urlPath = path[1];
    },

  mounted() {
    var me = this;
    me.components = this.$ManagerLists;
  },
  computed: {
      activeMenuItems() {
        const activeMenu = this.menus.find(menu => menu.id === this.activeMenu);
        return activeMenu ? activeMenu.items : [];
      }
  },
  methods: {
    changeMenu(menuId) {
      this.activeMenu = this.activeMenu === menuId ? null : menuId;
    },
    changePath(event) {
      let targetUrl = event.currentTarget.getAttribute('data-to');
      this.$router.push(targetUrl);
    },
    openSideBar(){
      this.sideBar = !this.sideBar
    },
    changeUrl() {
      var path = document.location.href.split("#/")
      this.urlPath = path[1];
    },
    goHome() {
      this.urlPath = null;
    },
  }
};

</script>


