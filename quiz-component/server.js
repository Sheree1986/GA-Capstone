//Install express server
const express = require('express');
const path = require('path');

const app = express();

// Serve only the static files form the dist directory
app.use(express.static('./dist/ga-capstone'));


app.get('/*', (req, res, next) =>
    res.sendFile('index.html', {root: 'dist/ga-capstone/'}),

);



// Start the app by listening on the default Heroku port
app.listen(process.env.PORT || 8080);




