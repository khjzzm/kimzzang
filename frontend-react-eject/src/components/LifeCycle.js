import React, {Component} from "react";

class LifeCycle extends Component {
    constructor(props){
        super(props);
        console.log('constructor')
    }

    componentDidMount(){
        console.log('componentDidMount');
        console.log(this.myDiv.getBoundingClientRect());
    }
    render() {
        return (
            <div ref={ref=> this.myDiv = ref}>
                <h1>생명주기</h1>
            </div>
        );
    }
}

export default LifeCycle;