<template>
<div>
    <h1>{{ msg }}</h1>
    <h2>IPad Air</h2>
    <p>안녕하세요 IPad Air 3세대입니다</p>
</div>
</template>

<script>
    export default {
        name: "IPadair",
        props: {
            msg: String
        }
    }
</script>

<style scoped>
h2 {color: #b34543
}
</style>