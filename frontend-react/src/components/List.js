import React, {Component} from "react";
import axios from 'axios';

class List extends Component {

    constructor(props){
        super(props);
        this.state = {
            postLists: []
        }
    }

    async componentDidMount(){
        await axios.get('/api/list')
            .then(res => {
                const postLists = res.data;
                this.setState({ postLists });
            });
    }


    render() {
        const {postLists} = this.state;

        if (postLists.length > 0) {
            return postLists.map(post => {
                return (
                    <div key={post.id}>
                        <p>title : {post.title}</p>
                        <p>author : {post.author}</p>
                    </div>
                );
            });
        } else {
            return <h3>No Photos</h3>;
        }
    }
}

export default List;