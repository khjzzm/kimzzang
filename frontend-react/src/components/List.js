import React, { Component } from "react";
import axios from "axios";

import { Table, TableHead, TableBody, TableRow, TableCell } from "@material-ui/core";

class List extends Component {
  constructor(props) {
    super(props);
    this.state = {
      postLists: []
    };
  }

  componentDidMount() {
    // this._callAPI();
    this._callAPI2();
  }

  _callAPI = () => {
    axios
      .get("/api/list")
      .then(res => {
        const postLists = res.data;
        this.setState({
          postLists
        });
      })
      .catch(err => {
        console.log(err);
      });
  };

  _callAPI2 = async () => {
    await fetch("/api/list")
      .then(response => response.json())
      .then(result =>
        this.setState({
          postLists: result
        })
      );
  };

  //TODO InsertPosts
  render() {
    const { postLists } = this.state;

    if (postLists.length > 0) {
      return postLists.map((post, index) => {
        return (
          <Table>
            <TableBody>
              <TableRow>
                <TableCell>index : {index}</TableCell>
                <TableCell><p>title : {post.title}</p></TableCell>
                <TableCell><p>author : {post.author}</p></TableCell>
                <TableCell><p><img src={post.img+"/"+index} alt="logo"/></p></TableCell>
              </TableRow>
            </TableBody>
          </Table>
        );
      });
    } else {
      return (
        <div>
          <h3>No Posts</h3>
        </div>
      );
    }
  }
}

export default List;
