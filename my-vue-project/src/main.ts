import { createApp } from 'vue'
import App from './App.vue'
import {createRouter,createWebHistory} from 'vue-router'
import HomePage from '@/pages/HomePage.vue'
import AboutPage from '@/pages/AboutPage.vue'
import NewsPage from '@/pages/NewsPage.vue'
//1.配置路由规则
const routes = [
    {path:"/",redirect:"/home"},   //或者{path:"/",component:HomePage},
    {path:"/home",component:HomePage},
    {path:"/about",component:AboutPage},
    {path:"/news",component:NewsPage,name:'news'}
]
//2.创建路由器
const router = createRouter({
    history:createWebHistory(),
    routes     //是routers:routers的简写
})
//3.加载路由器
const app = createApp(App)
app.use(router)

//引入pinia
import {createPinia} from 'pinia'
const pinia = createPinia()
app.use(pinia)
import {userStore} from "@/store/user"
import {storeToRefs} from 'pinia'
const user = userStore()
console.log(user.getUsername)
const piniaUser = storeToRefs(user)
user.changeUsername('666')
console.log(piniaUser)
app.provide('piniaUser',piniaUser)
app.mount('#app')
