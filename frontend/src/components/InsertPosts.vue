<template>
    <div id="InsertPosts">
        <b-form @submit="onSubmit" @reset="onReset" v-if="show">
            <b-form-group id="input-group-1" label="제목:" label-for="input-1" description="제목을 작성해주세요.">
                <b-form-input
                        id="title"
                        v-model="form.title"
                        type="text"
                        required
                        placeholder="Enter title"></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-2" label="작성자:" label-for="input-2">
                <b-form-input
                        id="author"
                        v-model="form.author"
                        placeholder="Enter author"></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-3" label="내용:" label-for="input-3">
                <b-form-input
                        id="content"
                        v-model="form.content"
                        placeholder="Enter author"></b-form-input>
            </b-form-group>

            <b-button type="submit" variant="primary">글등록</b-button>
            <b-button type="reset" variant="danger">초기화</b-button>

        </b-form>

        <b-card class="mt-3" header="Form Data Result">
            <pre class="m-0">{{ form }}</pre>
        </b-card>
    </div>
</template>

<script>
    export default {
        name: "InsertPosts",
        data() {
            return {
                form: {title: '', author: '', content: ''},
                show: true
            }
        },
        methods: {
            onSubmit(evt) {
                evt.preventDefault();

                this.$http.post('/api/insert',
                    JSON.stringify(this.form),
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
            onReset(evt) {
                evt.preventDefault();
                this.form.title = '';
                this.form.author = '';
                this.form.content = '';
            }
        }
    }
</script>

<style scoped>
#InsertPosts{
    margin: 30px;
}
</style>