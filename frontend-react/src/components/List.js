import React, {Component} from "react";
import axios from 'axios';

// import InsertPosts from '../components/InsertPosts';

class List extends Component {

    constructor(props) {
        super(props);
        this.state = {
            postLists: []
        }
    }

    componentDidMount() {
        this._callAPI();
        this._callAPI2();
    }

    _callAPI = () => {
        axios.get('/api/list')
            .then(res => {
                const postLists = res.data;
                this.setState({
                    postLists
                });
            }).catch(err => {
            console.log(err);
        });
    };

    _callAPI2 = async () => {
        await fetch('/api/list')
            .then(response => response.json())
            .then(result => this.setState({
                postLists: result
            }))
    };

    //TODO InsertPosts
    render() {
        const {postLists} = this.state;

        if (postLists.length > 0) {
            return postLists.map(post => {
                return (
                    <div>
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
                    <h3>No Posts</h3>
                </div>
            )
        }
    }
}

export default List;