<template>
  <div class="app">
    <h2>HelloWorld</h2>
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

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h2{color: #ff3f3e
  }
</style>
