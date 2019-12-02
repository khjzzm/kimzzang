<template>
    <div>
        <h1>{{ msg }}</h1>
        <b-table striped hover :items="posts"></b-table>
        <Posts></Posts>
        <p v-for="post in posts" :key="post.id">{{post.author}} : {{post.content}} : {{post.title}}</p>
    </div>
</template>

<script>
    import Posts from  '@/components/PostsSave'

    export default {
        name: "List",
        components: {
            Posts
        },
        data(){
            return {
                msg : 'BackEnd API call',
                posts: []
            }
        },
        created(){
            this.$http.get('/api/list').then((resp=>{
                this.posts = resp.data;
            }));
        }
    }
</script>

<style scoped>

</style>