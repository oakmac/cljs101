# ClojureScript 101

This repository contains programming exercises for a beginning ClojureScript
programmer. These exercises are part of the curriculum for the [Professional ClojureScript course].

The exercises are focused on the basics of the language:

- parenthesis balancing
- `def` forms
- Strings
- TODO: Numbers and Math
- Keywords
- Maps
- Vectors
- Sets
- TODO: functions
- TODO: conditionals

The exercises do not contain logic problems. They are focused on writing basic
syntax, learning fundamentals, and getting comfortable with your development
environment.

## Install / Setup

Make sure that [Node.js], [npm], and the [JVM] are installed. Then, from this directory type:

```sh
npm install
```

This will create a folder named `node_modules/` in this directory.

## Instructions

You will be writing in the `.cljs` files found in the `src-cljs/cljs101/exercises/` folder.

Open the file `src-cljs/cljs101/exercises/ex101_def_forms.cljs` in your text
editor and follow the instructions in the code.

In a terminal, run from the project root:

```sh
npx shadow-cljs watch tests
```

This command will automatically compile your code and run a test suite to check your answers.

Your goal is to get the test suite to pass all conditions. Good luck!

## License

[ISC License](LICENSE.md)

[Professional ClojureScript course]:https://cljs.pro
[Node.js]:https://nodejs.org/
[npm]:https://en.wikipedia.org/wiki/Npm_(software)
[JVM]:https://adoptopenjdk.net/
