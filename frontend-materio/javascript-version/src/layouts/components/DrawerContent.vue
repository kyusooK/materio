<template>
  <div class="nav-header">
    <RouterLink
      to="/"
      class="app-logo d-flex align-center gap-x-3 app-title-wrapper"
    >
      <div v-html="logo"></div>
      <Transition name="vertical-nav-app-title">
        <h1 class="font-weight-semibold leading-normal text-xl text-uppercase">
          Materio
        </h1>
      </Transition>
    </RouterLink>
  </div>
  <ul>
    <VerticalNavLink
      :item="{
        title: 'Home',
        to: 'index',
        icon: { icon: 'mdi-home-outline' }
      }"
    />
    <v-list :opened="open" style="background-color: #F4F5FA;">
      <template v-slot:activator="{ props }">
        <v-list-item
          v-bind="props"
          prepend-icon="mdi-account-circle"
          title="Users"
        ></v-list-item>
      </template>

      <v-list-group value="Basic">
        <template v-slot:activator="{ props }">
          <v-list-item
            style="margin-left: 10px;"
            v-bind="props"
            title="Basic"
          ></v-list-item>
        </template>

        <v-list-item
          v-for="item in basic"
          :key="item.key"
          :title="item.name"
          :value="item.name"
          :to="item.url"
        ></v-list-item>
      </v-list-group>

      <v-list-group value="Inventory">
        <template v-slot:activator="{ props }">
          <v-list-item
            style="margin-left: 10px;"
            v-bind="props"
            title="Inventory"
          ></v-list-item>
        </template>

        <v-list-item
          v-for="item in inventory"
          :key="item.key"
          :title="item.name"
          :value="item.name"
          :to="item.url"
        ></v-list-item>
      </v-list-group>
      <v-list-group value="Sales">
        <template v-slot:activator="{ props }">
          <v-list-item
            style="margin-left: 10px;"
            v-bind="props"
            title="Sales"
          ></v-list-item>
        </template>

        <v-list-item
          v-for="item in sales"
          :key="item.key"
          :title="item.name"
          :value="item.name"
          :to="item.url"
        ></v-list-item>
      </v-list-group>
    </v-list>
  </ul>
</template>

<script setup>
import logo from '@/assets/logo.svg?raw'
import { VerticalNavLink, VerticalNavSectionTitle,} from '@layouts'
import { ref } from 'vue';
import { useTheme } from 'vuetify';

const vuetifyTheme = useTheme();

const urlPath = null;
const sideBar = true;
const drawer = true;
const open = ['Users'];

const basic = [
  { key: 'companies', url: '/companies', name: '회사' },
  { key: 'products', url: '/products', name: '상품' },
];
const inventory = [
  {key: 'inventories', url: '/inventories', name: '재고'}
];
const sales = [
  {key: 'sales', url: '/sales', name: '수주'}
];

function changeUrl() {
  const path = document.location.href.split("#/");
  urlPath.value = path[1];
}

function goHome() {
  urlPath.value = null;
}
</script>

<style lang="scss">

</style>
