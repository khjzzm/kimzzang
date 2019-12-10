import React, {Component} from "react";
import axios from 'axios';
import InsertPosts from '../components/InsertPosts';

class List extends Component {

    constructor(props) {
        super(props);
        this.state = {
            postLists: []
        }
    }

    async componentDidMount() {
        await axios.get('/api/list')
            .then(res => {
                const postLists = res.data;
                this.setState({
                    postLists
                });
            }).catch(err =>{
                console.log(err);
            });
    }


    //TODO InsertPosts
    render() {
        const {postLists} = this.state;

        if (postLists.length > 0) {
            return postLists.map(post => {
                return (
                    <div>
                        <InsertPosts/>
                        <div key={post.id}>
                            <p>title : {post.title}</p>
                            <p>author : {post.author}</p>
                        </div>
                    </div>
                );
            });
        } else {
            return (
                <div>
                    <h3>No Photos</h3>
                    <InsertPosts/>
                </div>
            )
        }
    }
}

export default List;