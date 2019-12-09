import React from 'react';

// 비구조화 할당 문법: https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Destructuring_assignment
const YourName = ({ name, age }) => {
    return (
        <div>
            안녕하세요! 당신의 이름은 <b>{name}</b> 입니다.
            안녕하세요! 당신의 나이는 <b>{age}</b> 입니다.
        </div>
    );
};

export default YourName;