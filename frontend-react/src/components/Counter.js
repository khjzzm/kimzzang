import React, {Component} from "react";

import Value from './Value'
import Control from './Control'

class Counter extends Component {

    state = {
        number: 0
    };

    handleIncrease = () => {
        this.setState({
            number : this.state.number + 1
        })
    };

    handleDecrease = () =>{
        this.setState({
            number : this.state.number - 1
        })
    };


    render() {
        return (
            <div>
                {/*<h1>카운터</h1>*/}
                {/*<div>값 : {this.state.number} </div>*/}
                {/*<button onClick={this.handleIncrease}>+</button>*/}
                {/*<button onClick={this.handleDecrease}>-</button>*/}
                <Value/>
                <Control/>
            </div>
        );
    }
}

export default Counter;