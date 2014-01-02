(ns optimus-jsx.core-test
  (:require [optimus-jsx.core :refer :all]
            [test-with-files.core :refer [with-files public-dir *last-modified*]]
            [midje.sweet :refer :all]))

(fact
 "It transforms JSX to JS."

 (transform "/** @jsx React.DOM */
var MyComponent = React.createClass({/*...*/});
var app = <MyComponent someProperty={true}><div color=\"blue\"></div></MyComponent>;")

 => "/** @jsx React.DOM */
var MyComponent = React.createClass({displayName: 'MyComponent',/*...*/});
var app = MyComponent( {someProperty:true}, React.DOM.div( {color:\"blue\"}));")

(fact
 "It creates JS assets."

 (with-files [["/code.jsx" "/** @jsx React.DOM */ var a = <h1></h1>;"]]
   (load-jsx-asset public-dir "/code.jsx") =>
   {:path "/code.js"
    :original-path "/code.jsx"
    :contents "/** @jsx React.DOM */ var a = React.DOM.h1(null);"
    :last-modified *last-modified*}))

(fact
 "It includes path in error messages."

 (with-files [["/code.jsx" "/** @jsx React.DOM */ var a = <h1></h2>;"]]
   (load-jsx-asset public-dir "/code.jsx") =>
   (throws Exception "Exception in /code.jsx: Parse Error: Line 1: Expected corresponding XJS closing tag for h1")))

(fact
 "It straps into Optimus' load-asset."

 (with-files [["/code.jsx" ""]]
   (-> (optimus.assets.creation/load-asset public-dir "/code.jsx") :path) => "/code.js"))
