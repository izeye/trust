module.exports = {
  entry: "./web-resources/js/app.js",
  output: {
    path: __dirname,
    filename: "./src/main/resources/public/js/bundle.js"
  },
  module: {
    loaders: [
      {
        test: /\.js$/,
        loader: 'babel',
        query: {
          presets: ['react']
        }
      }
    ]
  }
};
