const webpack = require("webpack");

module.exports=({file,options,any})=>({
   plugins:{
       "postcss-import":{addDependencyTo:webpack},
       "postcss-nested":{},
       "postcss-extend":{},
       "postcss-css-variables":{}
   }
})
