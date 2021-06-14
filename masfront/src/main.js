import Vue from 'vue'
import App from './App.vue'
import router from './router'


Vue.config.productionTip = false

Vue.mixin({
  data: function() {
    return {
      get API_URL() {
        return "http://localhost:8080/api/";
      }
    }
  }
})


new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
