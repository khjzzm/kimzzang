<template>
    <div id="header">
        <router-link to="/">HelloWorld</router-link> |
        <router-link to="/example/0509/post/91">Example</router-link> |
        <router-link :to="{name:'Example', params: {id: 509, post:91}}">named-routes</router-link> |
        <router-link to="/posts">Posts</router-link> |
        <router-link to="/apple">Apple</router-link>

    </div>
</template>

<script>
export default {
    name: "Header"
}
</script>

<style scoped>
#header{
    border-bottom: #3f916e 2px solid;
    padding-bottom: 30px;
    margin-bottom: 30px;
}
</style>