#!/bin/sh

mkdir -p resources

if [ ! -d "node_modules/react-tools" ]; then
    npm install react-tools
fi

if [ ! -d "node_modules/browserify" ]; then
    npm install browserify
fi

if [ ! -f "resources/react-tools.js" ]; then
    ./node_modules/.bin/browserify -r react-tools -o resources/react-tools.js
fi
