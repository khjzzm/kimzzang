import React from 'react';

const Search = ({location}) => {
    return (
        <div>
            {/*TODO*/}
            {new URLSearchParams(location.search).get('keyword')} 검색
        </div>
    );
};

export default Search;


