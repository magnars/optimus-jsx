# optimus-jsx [![Build Status](https://secure.travis-ci.org/magnars/optimus-jsx.png)](http://travis-ci.org/magnars/optimus-jsx)

A [React JSX](http://facebook.github.io/react/docs/jsx-in-depth.html) asset loader for [Optimus](http://github.com/magnars/optimus).

## Install

- Add `[optimus-jsx "0.1.1"]` to `:dependencies` in your `project.clj`.
- It requires Optimus version minimum `0.13.6`.

## Usage

Add `(:require optimus-jsx.core)` to the namespace declaration where
you're loading assets.

The `load-jsx-asset` function will be declared as a custom loader for
`.jsx` files with Optimus' `load-asset` multimethod. This is in turn
used by `load-assets`, `load-bundle` and `load-bundles` - so
everything works like before, but now it also supports JSX files.

#### Bundling

The `.jsx` files are immediately transpiled into `.js` files. This
means you can safely bundle JS and JSX files together. It also means
that the bundle identifier has to be `.js`. Like so:

```cl
(assets/load-bundle "public"
                    "app.js"
                    ["/script/lib.js"
                     "/script/code.jsx"])
```

## Contribute

Yes, please do.

If you're looking to add other transpilers, I think that would be best
in a separate project. But please do let me know about it, so I can
link to it in the Optimus README. :-)

Remember to add tests for your feature or fix, or I'll certainly break
it later.

#### Installing dependencies

You need [npm](https://npmjs.org/) installed to fetch the JavaScript
dependencies. The actual fetching is automated however.

#### Running the tests

`lein midje` will run all tests.

`lein midje :autotest` will run all the tests indefinitely. It sets up a
watcher on the code files. If they change, only the relevant tests will be
run again.

## License

Copyright © 2014 Magnar Sveen

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
