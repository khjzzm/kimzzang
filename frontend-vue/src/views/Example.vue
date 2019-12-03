<template>
    <div id="app">
        <h2>Example</h2>
        <p>{{ $route.params }}</p>
        <p>{{ $route.params.id }}</p>
    </div>
</template>

<script>
    export default {
        name: "Example"
    }
</script>

<style scoped>
    h2{color: #435aff
    }
</style>