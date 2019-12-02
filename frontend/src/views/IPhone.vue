<template>
<div>
    <h1>{{ msg }}</h1>
    <h2>IPhone</h2>
    <p>안녕하세요 IPhone 7세대입니다</p>
</div>
</template>

<script>
    export default {
        name: "IPhone",
        props: {
            msg: String
        }
    }
</script>

<style scoped>
h2 {color: #b34543
}
</style>