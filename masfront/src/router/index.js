import Vue from 'vue'
import VueRouter from 'vue-router'
import List from '../views/List.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'List',
    component: List
  },
  {
    path: '/flat/:id',
    name: 'Flat',
    component: () => import('../views/Flat.vue')
  },
  {
    path: '/form/:id',
    name: 'Form',
    component: () => import('../views/Form.vue')
  },
  {
    path: '/summary',
    name: 'Summary',
    component: () => import('../views/Summary.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
