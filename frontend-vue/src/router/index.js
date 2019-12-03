import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/views/HelloWorld'
import Example from '@/views/Example'
import Apple from '@/views/Apple/Apple'
import Mac from '@/views/Apple/Mac/Mac'
import IPad from '@/views/Apple/iPad/IPad'
import IPhone from '@/views/Apple/iPhone/IPhone'
import Watch from '@/views/Apple/Watch/Watch'
import Posts from '@/views/Posts'
import NotFound from  '@/components/NotFound'

Vue.use(Router);

export default new Router({
    mode: "history",
    routes: [
        {
            path: '*',
            component: NotFound
        },
        {
            path: '/',
            name: 'Hello',
            component: HelloWorld
        },
        {
            path: '/example/:id/post/:post_id?',
            name: 'Example',
            component: Example
        },
        {
            path: '/apple/:product?',
            name: 'Apple',
            component: Apple,
            children:[
                {
                    path: 'mac',
                    name: 'mac',
                    component: Mac
                },
                {
                    path: 'ipad',
                    name: 'ipad',
                    component: IPad
                },
                {
                    path: 'iphone',
                    name: 'iphone',
                    component: IPhone
                },
                {
                    path: 'watch',
                    name: 'watch',
                    component: Watch
                },
            ]
        },
        {
            path: '/posts',
            name: 'Posts',
            component: Posts
        }
    ]
});