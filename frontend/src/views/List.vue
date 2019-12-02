<template>
    <div>
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
                <th>title 수정</th>
                <th>delete</th>
                <th>update</th>
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
                <!--<td> <b-form-input-->
                        <!--id="utitle"-->
                        <!--v-model="title"-->
                        <!--type="text"-->
                        <!--required-->
                        <!--placeholder="Enter Update Title"></b-form-input>-->
                <!--</td>-->
                <td><b-button variant="danger" v-on:click="deletePosts(post.id)">삭제</b-button></td>
                <td><b-button variant="success" v-on:click="updatePosts(post.id)">수정</b-button></td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
                <td><b-button size="sm" variant="outline-danger" v-on:click="deleteAllByIdInQuery(selected)">선택삭제</b-button></td>
                <td colspan="3"><div class="text-uppercase text-bold">{{selected}}</div></td>
            </tr>
            </tfoot>
        </table>

        <InsertPosts></InsertPosts>
    </div>
</template>

<script>
    import InsertPosts from  '@/components/InsertPosts'

    export default {
        name: "List",
        components: {
            InsertPosts
        },
        data(){
            return {
                msg : 'BackEnd API call',
                posts: [],
                selected: [],
                selectAll: false
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
            },
            // updatePosts(){
            //     this.$http.post('/api/update',
            //         JSON.stringify(this.form),
            //         {headers: {'Content-Type': 'application/json;charset=UTF-8'}}
            //     ).then(function (response) {
            //         if(response.status===200){
            //             alert(response.status);
            //             location.reload(true);
            //         }
            //     }).catch(function (error) {
            //         alert(error);
            //     })
            // }
        }
    }
</script>

<style scoped>

</style>