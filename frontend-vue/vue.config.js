'use strict';

const path = require('path');

module.exports = {
    publicPath: "/",
    outputDir: path.resolve(__dirname, "../src/main/resources/static"),
    productionSourceMap: false,
    devServer: {
        proxy: { // proxyTable 설정
            '/api': {
                target: 'http://localhost:8081',
                changeOrigin: true
            }
        }
    }

};
