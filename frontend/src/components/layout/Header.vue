<template>
    <div id="app">
        <router-link to="/">HelloWorld</router-link> |
        <router-link to="/example/123/post/45">Example</router-link> |
        <router-link :to="{name:'Example', params: {id: 123, post:33333}}">named-routes.</router-link> |
        <router-link to="/apple">Apple</router-link> |
        <router-link to="/ipad">Ipad</router-link> |
        <router-link to="/apple/ipadair">Ipadair</router-link> |
        <router-link to="/apple/iphone7">iphone7</router-link> |
        <router-link to="/list">List</router-link>
    </div>
</template>

<script>
export default {
    name: "Header"
}
</script>

<style scoped>

</style>