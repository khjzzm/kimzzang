<template>
<div>
    <h1>{{ msg }}</h1>
    <h2>IPad</h2>
    <p>안녕하세요 IPad 7세대입니다</p>
</div>
</template>

<script>
    export default {
        name: "IPad",
        props: {
            msg: String
        }
    }
</script>

<style scoped>
h2 {color: mediumseagreen}
</style>