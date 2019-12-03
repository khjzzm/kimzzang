<template>
  <div class="app">
    <h2>Hello Vue.js</h2>
    <img alt="Vue logo" src="../assets/logo.png">
  </div>
</template>

<script>
    export default {
        name: "HelloWorld",
        props: {
            msg: String
        }
    }
</script>
<style scoped>
  h2{color: #3f916e}
</style>
