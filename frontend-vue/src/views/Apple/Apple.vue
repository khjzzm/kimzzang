<template>
    <div id="apple">
        <h2>Apple</h2>
        <img alt="Vue logo" src="../../assets/apple.png">
        <p>누군가의 연말연시를 특별하게</p>
        <router-link to="/apple/mac">Mac</router-link> |
        <router-link to="/apple/ipad">iPad</router-link> |
        <router-link to="/apple/iphone">iPhone</router-link> |
        <router-link to="/apple/watch">Watch</router-link> |
        <router-view></router-view>
    </div>
</template>

<script>
    export default {
        name: "Apple",
    }
</script>

<style scoped>
h2{
    color:red;
}
p{
    padding: 10px;
}
</style>