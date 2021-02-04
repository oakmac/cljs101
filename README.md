# ClojureScript 101

Programming exercises for a beginning ClojureScript programmer.

These exercises are focused on the basics of the language:

- parenthesis balancing
- `def` forms
- Strings
- Numbers
- Keywords
- Map, Vector, Set literals

These exercises do not contain much logic. They are more focused on practicing
writing basic syntax and getting comfortable with your development environment.

## Get Started / Install

Make sure that [Node.js], [npm], and the [JVM] are installed. Then, from this directory type:

```sh
npm install
```

This will install a folder named `node_modules/` into this folder.

## Exercise Directions

You will be writing in the `.cljs` files found in the `src-cljs/cljs101/exercises/` folder.

Open the file `src-cljs/cljs101/exercises/ex101_def_forms.cljs` in your text
editor and follow the instructions in the code.

In a terminal, run from the project root:

```sh
npx shadow-cljs watch tests
```

This command will automatically compile your code and run a test suite to check your answers.

The goal is to get the test suite to pass all conditions. Good luck!

## License

[ISC License](LICENSE.md)

[Node.js]:https://nodejs.org/
[npm]:https://en.wikipedia.org/wiki/Npm_(software)
[JVM]:https://adoptopenjdk.net/
