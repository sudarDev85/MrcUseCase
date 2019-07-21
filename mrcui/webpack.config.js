const HtmlWebpackPlugin = require("html-webpack-plugin");
const path=require("path");
const outputDirectory="dist";
const webpack = require("webpack");
const CopyWebpackPlugin= require('copy-webpack-plugin');
module.exports={
    entry:["@babel/polyfill","./src/App.js"],
    output:{
        path:path.join(__dirname,outputDirectory),
        filename:"bundle.js"
    },
    mode:"development",
    module:{
        rules:[
            {
                test:/\.js$/,
                exclude:/node_modules/,
                use:{
                    loader:"babel-loader"
                }
            },
            {
                test: /\.scss$/,
                loader:  ['style-loader', 'css-loader', 'resolve-url-loader', 'sass-loader?sourceMap']
              },
            {
                test:/\.css$/,
                use:[
                    "style-loader",
                    {
                        loader:"css-loader",
                        options:{
                            importLoader:1
                        }
                    },{
                    loader: 'resolve-url-loader',
                    },
                    {
                        loader:"postcss-loader",
                        options:{
                            sourceMap: true,
                            config:{
                                path: path.resolve("./postcss.config.js")
                            }
                        }
                    }
                ]
            },
            {
                test: /\.woff(2)?(\?v=[0-9]\.[0-9]\.[0-9])?$/,
                loader: 'url-loader?limit=10000&mimetype=application/font-woff'
              },
              {
                test: /\.(ttf|eot|svg|gif|png)(\?v=[0-9]\.[0-9]\.[0-9])?$/,
                loader: 'file-loader'
              }

        ]
    },
    devServer:{
        contentBase: path.join(__dirname,"dist"),
        historyApiFallback: true,
        compress: true,
        port: 9000,
        proxy:{
            "/api": "http://localhost:8080"
        }
    },
    plugins:[
        new CopyWebpackPlugin([{from:"./src/static/images",to:"images"}]),
        new HtmlWebpackPlugin({
            template: "./public/index.html"
        })
    ]
}