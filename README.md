This project demonstrates Gradle variants: if you have `api1` (described by `api-lib` plugin) and its implementation `api1impl` (and probably other APIs
and their implementations), then `add-runtime` plugin automatically adds all project API implementations to `testRuntimeClasspath` via dependency substitution.

For example,

`gradlew.bat main:dependencies --configuration runtimeClasspath`

has only `api1` in the classpath, but

`gradlew.bat main:dependencies --configuration testRuntimeClasspath`

has `api1` and its implementation in the classpath.
