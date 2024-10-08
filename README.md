# James Savery Lloyds technical submission

This submission is a fork of another technical I did earlier. 

It's simply an app that shows surgical procedures, and opens procedures in a Bottomsheet to show details. Users can also favourite procedures. 

This project is a fork of it, where I have modularised it.

Find my original submission [here](https://github.com/jamessavery/james-code-challenge).

## Note:
- You'll find various "D_N"s scattered across the project, they provide commentary/explanation of various things I was developing.
- There are various "chores" I haven't completed due to this just being a technical. I.e using library catalogues for build.gradle dependencies, complete test coverage, etc.
- My Github email differs from what I'm using for communications with Lloyds.

## Running test suites:
Snapshot tests is achieved using [Paparazzi](https://github.com/cashapp/paparazzi).

Run all unit tests (including snapshot tests) with:
> ./gradlew runAllTests
- Run just snapshot tests with:
> ./gradlew runSnapshotTests
- To run everything but snapshot tests:
> ./gradlew test