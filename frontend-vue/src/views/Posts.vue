<template>
    <div id="list">
        <h1>{{ msg }}</h1>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>
                    <label class="form-checkbox">
                        <input type="checkbox" v-model="selectAll" @click="select">
                        <i class="form-icon"></i>
                    </label>
                </th>
                <th>author</th>
                <th>title</th>
                <th>delete</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="post in posts" v-bind:key="post.id">
                <td>
                    <label class="form-checkbox">
                        <input type="checkbox" :value="post.id" v-model="selected">
                        <i class="form-icon"></i>
                    </label>
                </td>
                <td>{{post.author}}</td>
                <td>{{post.title}}</td>
                <td><b-button variant="danger" v-on:click="deletePosts(post.id)">삭제</b-button></td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
                <td><b-button size="sm" variant="outline-danger" v-on:click="deleteAllByIdInQuery(selected)">선택삭제</b-button></td>
                <td colspan="3"><div class="text-uppercase text-bold">{{selected}}</div></td>
            </tr>
            </tfoot>
        </table>
        <InsertPosts msg="컴포넌트 전달" status="정상"></InsertPosts>
    </div>
</template>

<script>
    import InsertPosts from  '@/components/InsertPosts'

    export default {
        name: "List",
        components: {
            InsertPosts
        },
        data: function () {
            return {
                msg : 'Vue.js + SpringBoot(JPA)',
                posts: [],
                selected: [],
                selectAll: false,
            }
        },
        created(){
            this.$http.get('/api/list').then((resp=>{
                this.posts = resp.data;
            }));
        },
        methods: {
            select(){
                this.selected = [];
                if (!this.selectAll) {
                    for (let i in this.posts) {
                        this.selected.push(this.posts[i].id);
                    }
                }
            },
            deletePosts(id) {
                this.$http.get('/api/delete',
                    {params: {id:id} },
                    {headers: {'Content-Type': 'application/json;charset=UTF-8'}}
                ).then(function (response) {
                    if(response.status===200){
                        alert(response.status);
                        location.reload(true);
                    }
                }).catch(function (error) {
                    alert(error);
                })
            },
            deleteAllByIdInQuery(ids){
                this.$http.get('/api/deletes',
                    {params: {ids:ids.join()} },
                    {headers: {'Content-Type': 'application/json;charset=UTF-8'}}
                ).then(function (response) {
                    if(response.status===200){
                        alert(response.status);
                        location.reload(true);
                    }
                }).catch(function (error) {
                    alert(error);
                })
            }
        }
    }
</script>

<style scoped>
#list{
    margin: 30px;
}
</style>