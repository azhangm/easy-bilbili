import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/LoginView'
Vue.use(VueRouter)

const routes = [
  {
    path: '*',
    name: 'login',
    component: Login
  },

]

const router = new VueRouter({
  routes,
  mode:'history'
})

export default router
