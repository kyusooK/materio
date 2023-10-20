/* eslint-disable import/order */
import '@/@iconify/icons-bundle'
import App from '@/App.vue'
import vuetify from '@/plugins/vuetify'
import { loadFonts } from '@/plugins/webfontloader'
import router from '@/router'
import '@/styles/styles.scss'
import '@core/scss/index.scss'
import { createPinia } from 'pinia'
import { createApp } from 'vue'
import axios from 'axios';
import { Icon } from '@iconify/vue';

axios.defaults.baseURL = ''

const vuetify = createVuetify({
    components,
    directives,
})



loadFonts()

const app = createApp(App)

app.config.globalProperties.$axios = axios;
app.config.globalProperties.$fixUrl = fixUrl;

app.use(vuetify)

app.use(createPinia())

app.use(router)

app.component('Icon',Icon)

app.mount('#app')
