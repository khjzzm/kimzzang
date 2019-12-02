import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.prototype.$http = axios;

Vue.use(BootstrapVue);

new Vue({
    el: '#app',
    data: function () {
        return {
            message: '안녕하세요. 뷰(Vue)입니다.'
        }
    },
    router,
    render: h => h(App)
});

