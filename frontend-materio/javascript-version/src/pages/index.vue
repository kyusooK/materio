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
                                    <v-icon style="margin-top: 30%; margin-left: 37.5%;" color="primary" size="64">mdi-apps</v-icon>
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
                                        style="font-weight:500; font-size:20px; border:solid 2px; max-width:250px; overflow:hidden; margin-top: 10%;"
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
    useComponent: "",
    drawer: true,
    components: {},
    sideBar: true,
    urlPath: null,
    menus: [
            { id: 'basic', title: '기준정보',
                items: [
                    { key: 'companies', url: '/companies', name: '회사' },
                    { key: 'products', url: '/products', name: '상품정보' },
                ]
            },
            { id: 'inventory', title: '재고',
                items: [
                    { key: 'inventories', url: '/inventories', name: 'Inventory' },
                ]
            },
            { id: 'sales', title: '수주',
                items: [
                    { key: 'salesOrders', url: '/salesOrders', name: '수주' },
                ]
            },
        ],
        cards: [
            {
                text: "회사",
                link: "/companies",
            },
            {
                text: "상품정보",
                link: "/products",
            },
            {
                text: "재고",
                link: "/inventories",
            },
            {
                text: "수주",
                link: "/salesOrders",
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


