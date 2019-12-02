import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/views/HelloWorld'
import Example from '@/views/Example'
import Apple from '@/views/Apple'
import IPad from '@/views/IPad'
import IPadair from '@/views/IPadair'
import IPhone from '@/views/IPhone'
import List from '@/views/List'
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
            path: '/list',
            name: 'List',
            component: List
        },
        {
            path: '/apple/:product?',
            name: 'Apple',
            component: Apple,
            children:[
                {
                    path: '/ipad',
                    name: 'IPad',
                    component: IPad
                },
                {
                    path: 'iPadair',
                    name: 'IPadair',
                    component: IPadair
                },
                {
                    path: 'iphone7',
                    name: 'iphone7',
                    component: IPhone
                },
            ]
        }
    ]
});