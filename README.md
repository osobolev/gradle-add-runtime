This project demonstrates Gradle variants: if you have `api1` (described by `api-lib` plugin) and its implementation in `impl-src` folder (and probably other APIs
and their implementations), then `lib` plugin automatically adds all API implementations found in the project to `testRuntimeClasspath` of the `:main` project
via dependency substitution.

For example,

`gradlew.bat main:dependencies --configuration runtimeClasspath`

has only `api1` in the classpath, but

`gradlew.bat main:dependencies --configuration testRuntimeClasspath`

has `api1` and its implementation in the classpath.
